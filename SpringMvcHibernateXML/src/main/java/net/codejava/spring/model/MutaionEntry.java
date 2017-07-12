package net.codejava.spring.model;

import java.util.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.CascadeType;

import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;



@Entity
@Table(name = "USERS")
public class MutaionEntry {
	private String MutationEntryNo;
	private String Village;
	private String Hobli;
	private String Comment;
	private String Year;
	public String getYear() {
		return Year;
	}
	public void setYear(String year) {
		Year = year;
	}
	private List<MutaionSurvey> SurveyNum = new ArrayList<MutaionSurvey>();
	@Column(columnDefinition = "LONGBLOB")
	private byte[] fileContent; 
	@Id
	@Column(name = "MUTATION_ENTRY_NUM")
	public String getMutationEntryNo() {
		return MutationEntryNo;
	}
	public void setMutationEntryNo(String mutationEntryNo) {
		MutationEntryNo = mutationEntryNo;
	}
	public String getVillage() {
		return Village;
	}
	public void setVillage(String village) {
		Village = village;
	}
	
	public String getHobli() {
		return Hobli;
	}
	public void setHobli(String hobli) {
		Hobli = hobli;
	}
	public String getComment() {
		return Comment;
	}
	public void setComment(String comment) {
		Comment = comment;
	}
	@OneToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "MUTAION_SURVEY", joinColumns = { @JoinColumn(name = "MUTATION_ENTRY_NUM") }, inverseJoinColumns = { @JoinColumn(name = "SURVEY_NUM") })
	public List<MutaionSurvey> getSurveyNum() {
		return this.SurveyNum;
	}

	public void setSurveyNum(List<MutaionSurvey> studentPhoneNumbers) {
		this.SurveyNum = studentPhoneNumbers;
	}
	public byte[] getFileContent() {
		return fileContent;
	}
	public void setFileContent(byte[] fileContent) {
		this.fileContent = fileContent;
	}


}
