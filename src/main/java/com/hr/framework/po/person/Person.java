package com.hr.framework.po.person;

import com.hr.framework.config.audit.Auditable;
import com.hr.framework.config.audit.EntityListener;
import com.hr.framework.po.address.City;
import com.hr.framework.po.survey.SurveyParticipate;
import lombok.Data;

import java.util.List;

import javax.persistence.*;

@Entity
@Table(name = "person_table")
@Data
@EntityListeners(EntityListener.class)
public class Person extends Auditable<Person>{
	
	
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id", updatable = false, nullable = false)
	private Long id;
	
	
	@Column(name = "first_name" , nullable = false)
	private String firstName;
	
	@Column(name = "second_name" , nullable = false)
	private String secondName;
	
	@Column(name = "last_name" , nullable = false)
	private String lastName;
	
	@Column(name = "birth_place" , nullable = true)
	private String birthName;
	
	@Column(name = "birth_place" , nullable = true)
	private String birthPlace;

	@Column(name = "religious_name" , nullable = false)
	private String religiuosName;

	@OneToMany(fetch =  FetchType.LAZY , mappedBy = "persons")
	private List<Citizen> citizens;
	
	@OneToMany(fetch =  FetchType.LAZY , mappedBy = "persons")
	private List<Contact> contacts;
	
	@OneToMany(fetch =  FetchType.LAZY , mappedBy = "persons")
	private List<DegreeObtained> degrees;
	
	@OneToMany(fetch =  FetchType.LAZY , mappedBy = "persons")
	private List<Employeed> employeed;
	
	
	@OneToMany(fetch =  FetchType.LAZY , mappedBy = "persons")
	private List<Identification> identification;
	
	@OneToOne(fetch = FetchType.LAZY , cascade = CascadeType.ALL , mappedBy = "maritals")
	@JoinColumn(name = "marital_id" , nullable = true)
	private MaritalStatus status;
	
	@OneToMany(fetch =  FetchType.LAZY , cascade =  CascadeType.ALL,  mappedBy = "persons")
	private List<Passport> passports;
	
	@OneToMany(fetch =  FetchType.LAZY , mappedBy = "persons")
	private List<SkillsProcessed> skills;

	@OneToMany(fetch = FetchType.LAZY , cascade = CascadeType.ALL ,  mappedBy = "persons")
	private List<SurveyParticipate> surveyParticipates;
	

	
    /*Address BirthCode*/

    private String bodCity;


	/*Living Address*/
	private String livingCity;
	
	
}
