package com.hr.framework.po.person;

import com.hr.framework.config.audit.Auditable;
import com.hr.framework.config.audit.EntityListener;
import lombok.Data;

import java.util.List;

import javax.persistence.*;

@Entity
@Table(name = "country_code")
@Data
@EntityListeners(EntityListener.class)
public class CountryCode extends Auditable<CountryCode>{

	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id", updatable = false, nullable = false)
	private Long id;
	
	
	@Column(name = "country_name" , nullable = false)
	private String countryCode;
	
	
	@Column(name = "country_name" , nullable = false)
	private String countryName;


	@OneToMany(fetch =  FetchType.LAZY , mappedBy = "codes")
	private List<Citizen> citizens;
	
	@OneToMany(fetch =  FetchType.LAZY , mappedBy = "codes")
	private List<Passport> passports;
	
	@OneToMany(fetch =  FetchType.LAZY , mappedBy = "codes")
	private List<PersonLanguage> langs;
	

}
