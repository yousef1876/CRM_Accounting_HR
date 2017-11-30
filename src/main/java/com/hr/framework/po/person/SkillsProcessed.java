package com.hr.framework.po.person;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.*;

import com.embedded.pk.CompositeKeySkills;
import com.hr.framework.config.audit.Auditable;
import com.hr.framework.config.audit.EntityListener;
import lombok.Data;

@Entity
@Table(name = "skills_processed")
@IdClass(CompositeKeySkills.class)
@Data
@EntityListeners(EntityListener.class)
public class SkillsProcessed extends Auditable<SkillsProcessed> implements Serializable{

	 @Column(name = "description" , nullable = true)
	 private String description;
	 
	 @Column(name = "note" , nullable = true)
	 private String note;
	 
	 @Column(name = "last_used" , nullable = false)
	 private Date lastUsed;

	 @Id
	 @ManyToOne(fetch =  FetchType.LAZY)
	 @JoinColumn(name = "skill_id" , nullable = false)
	 private Skills skills;
	 
	 @Id
	 @ManyToOne(fetch =  FetchType.LAZY)
	 @JoinColumn(name = "person_id" , nullable = false)
	 private Person persons;
	 
	 

	
	 	
	/*Skill FK*/
	
	/*FK person*/
	

}
