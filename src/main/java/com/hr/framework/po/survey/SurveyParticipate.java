package com.hr.framework.po.survey;

import com.hr.framework.config.audit.Auditable;
import com.hr.framework.config.audit.EntityListener;
import com.hr.framework.po.person.Person;
import lombok.Data;

import java.util.Date;

import javax.persistence.*;

@Entity
@Table(name = "survey_participate")
@Data
@EntityListeners(EntityListener.class)
public class SurveyParticipate extends Auditable<SurveyParticipate>{
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "part_id", updatable = false, nullable = false)
	private Long id;
	
	/* Survey FK	*/
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "survey_id" , nullable = false)
	private Survey survey;

	/* Person FK    */
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name  = "person_id" , nullable = false)
	private Person persons;

	@Column(name  = "email" , nullable = false)
	private String email;
	
	@Column(name  = "participation_date")
	@Temporal(TemporalType.TIMESTAMP)
	private Date   participationDate;
	
	

}
