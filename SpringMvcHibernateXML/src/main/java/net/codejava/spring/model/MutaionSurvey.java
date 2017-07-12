package net.codejava.spring.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table(name = "MUTATION_SURVEY")
public class MutaionSurvey {
	private String MutationEntryNo;
	private String SurveyNo;
	public String getMutationEntryNo() {
		return MutationEntryNo;
	}
	public void setMutationEntryNo(String mutationEntryNo) {
		MutationEntryNo = mutationEntryNo;
	}
	@Id
	@Column(name = "SURVEY_NUM")
	public String getSurveyNo() {
		return SurveyNo;
	}
	public void setSurveyNo(String surveyNo) {
		SurveyNo = surveyNo;
	}
	
}
