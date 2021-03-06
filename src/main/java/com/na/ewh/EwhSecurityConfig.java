package com.na.ewh;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.na.ewh.model.EwhUserDetails;
import com.na.ewh.model.UserInfo;
import com.na.ewh.repositroy.IUserDetailServiceRepository;

@EnableWebSecurity
public class EwhSecurityConfig extends WebSecurityConfigurerAdapter {
	@Autowired
	private IUserDetailServiceRepository userDetailRepo;
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests()
			.antMatchers("/").permitAll()
			.antMatchers("/customers","/savecustomer","/savecommodity","/updatecustomer","/savegodown","/logout").hasAnyRole("USER","ADMIN")
			.antMatchers("/admin", "/h2-console/**").hasRole("ADMIN")
			.and().csrf().ignoringAntMatchers("/h2-console/**","/savecustomer","/savecommodity","/savegodown","/updatecustomer")//don't apply CSRF protection to /h2-console
			.and().headers().frameOptions().sameOrigin()//allow use of frame to same origin urls
			.and().formLogin();//enable form login instead of basic login
			//.loginPage("/login");
	}

	/**
	 *This method overrides base class method to fetch and load login user details from db.
	 */
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(new UserDetailsService() {
			@Override
			public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
				Optional<UserInfo> user = userDetailRepo.findByUserName(username);
				user.orElseThrow(() -> new UsernameNotFoundException("Not found:"+username));
				return user.map(EwhUserDetails::new).get();
			}
		});
	}

	@Bean
	public PasswordEncoder getPasswordEncoder() {
		return NoOpPasswordEncoder.getInstance();
	}
	
	/**
	 * @return currently logged in user
	 */
	public String currentLoggedUser() {
		Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		if (principal instanceof UserDetails) {
			return ((UserDetails) principal).getUsername();
		} else {
			return principal.toString();
		}
	}
}