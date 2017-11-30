package com.hr.framework.po.survey;

import com.hr.framework.config.audit.Auditable;
import com.hr.framework.config.audit.EntityListener;
import lombok.Data;

import java.util.Date;

import javax.persistence.*;

@Entity
@Table(name  = "response")
@Data
@EntityListeners(EntityListener.class)
public class Response extends Auditable<Response>{
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "response_id", updatable = false, nullable = false)
	private Long id;
	
	@Column(name  = "response_name" , nullable = false)
	private String responseName;
	
	@Column(name  = "response_title" , nullable = false)
	private String responseTitle;
	
	@Column(name  = "added_date" , nullable = false)
	private Date addedDate;
	
	@Column( name = "survey_code" , nullable = false)
    private String surveyCode;
	
	
   
    
	
}
