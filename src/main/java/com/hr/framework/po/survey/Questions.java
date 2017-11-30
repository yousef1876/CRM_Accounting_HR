package com.hr.framework.po.survey;

import javax.persistence.*;

import com.enums.QuestionType;
import com.hr.framework.config.audit.Auditable;
import com.hr.framework.config.audit.EntityListener;

import java.util.List;


@Entity
@Table( name  = "survey_questions")
@Inheritance(strategy=InheritanceType.JOINED)
@EntityListeners(EntityListener.class)
public class Questions extends Auditable<Questions>{

	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "question_id", updatable = false, nullable = false)
	private Long id;
	
	@Column( name = "question" , nullable = false)
	private String question;
	
	@Column(name  = "text" , nullable = true)
	private String text;
	
	@Column(name  = "type" , nullable = false)
	private QuestionType type;
	
	@Column(name  = "expected_actual_answer" , nullable = false)
	private String expectedActualAnswer;

	@OneToMany(fetch = FetchType.LAZY , cascade = CascadeType.ALL , mappedBy = "questions")
	private List<QuestionChoices> questions;

	/* Survey FK */
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "survey_id" , nullable =  false)
	private Survey survives;
}
