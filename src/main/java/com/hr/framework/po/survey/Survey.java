package com.hr.framework.po.survey;

import java.util.Date;
import java.util.List;

import javax.persistence.*;

import com.hr.framework.config.audit.Auditable;
import com.hr.framework.config.audit.EntityListener;
import com.hr.framework.po.transaction.logger.Roles;
import lombok.Data;

@Entity
@Table(name  = "survey")
@Data
@EntityListeners(EntityListener.class)
public class Survey extends Auditable<Survey>{

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "survey_id", updatable = false, nullable = false)
	private Long id;
	
	@Column(name  = "survey_code" , nullable = false)
	private String surveyCode;
	
	@Column(name  = "survey_name" , nullable = false)
	private String surveyName;
	
	@Column(name  = "description" , nullable = false)
	private String description;
	
	@Column(name  = "summary" , nullable = false)
	private String summary;
	
	@Column(name  = "welcom_msg" , nullable = false)
	private String welcomMsg;
	
	@Column(name  = "end_msg" , nullable = false)
	private String endMsg;
	
	@Column(name = "start_date" , nullable = false)
	@Temporal(TemporalType.TIMESTAMP)
	private Date   startDate;
	
	@Column(name = "expire_date" , nullable = false)
	@Temporal(TemporalType.TIMESTAMP)
	private Date   expireDate;
	
	@Column(name = "public_date" , nullable = false)
	@Temporal(TemporalType.TIMESTAMP)
	private Date   publicationDate;

	@OneToMany(fetch = FetchType.LAZY , cascade = CascadeType.ALL , mappedBy = "survives")
	private List<Survey> survives;

	@OneToMany(fetch = FetchType.LAZY , cascade = CascadeType.ALL , mappedBy = "survey")
	private List<SurveyParticipate> surveyParticipates;
	
	
}
