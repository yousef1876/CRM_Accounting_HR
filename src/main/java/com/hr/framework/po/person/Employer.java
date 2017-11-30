package com.hr.framework.po.person;

import lombok.Data;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name  = "employer")
@Data
public class Employer {

	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id", updatable = false, nullable = false)
	private Long id;
	
	@Column(name = "employer_name" , nullable = false)
	private String employerName;
	
	@Column(name = "address" , nullable = false)
	private String address;
	
	@Column(name = "employer_code" , nullable = false)
	private String employerCode;
	
	@Column(name = "email" , nullable = false)
	private String email;
	
	@Column(name = "head_addrs_name" , nullable = false)
	private String headAddName;
	
	@Column(name = "head_phone" )
	private String headphone;

	/*Jobs FK*/
	
	@OneToMany(fetch = FetchType.LAZY , mappedBy = "jobs")
	private List<Job> jobs;
	
	
	

	
    
	/* PersonName; FK */
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name  = "person_id" , nullable = false)
	private Person persons;
	
}
