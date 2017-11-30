package com.hr.framework.po.survey;

import com.hr.framework.config.audit.Auditable;
import com.hr.framework.config.audit.EntityListener;
import lombok.Data;

import java.io.Serializable;
import javax.persistence.*;

@Entity
@Table(name  = "survey_question_choices")
@Data
@EntityListeners(EntityListener.class)
public class QuestionChoices extends Auditable<QuestionChoices> implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "choice_id", updatable = false, nullable = false)
	private Long id;

	@Column(name  = "choice_name" , nullable = false)
	private String choiceName;
	
	/* Question FK */
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "question_id" , nullable = false)
	private Questions questions;
}
