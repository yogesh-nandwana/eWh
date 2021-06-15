package com.na.ewh.model;

import java.util.Set;

import javax.persistence.*;

@Entity
public class StackInfo {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@OneToMany
	private Set<ContainerInfo> containers;
}
