package com.api.estado.model;

import java.io.Serializable;
import java.util.Comparator;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="tb_microsoft_security")
public class Value implements Comparator<Value>, Serializable {
    private static final long serialVersionUID = -2420346134960559062L;
	
	@Id
	private String ID;
	
	private String Alias;
	
	private String DocumentTitle;
	

	private String Severity;
	

	private String InitialReleaseDate;


    private String CurrentReleaseDate;
	

    private String CvrfUrl;
	
		
	public String getID() {
		return ID;
	}



	public void setID(String iD) {
		ID = iD;
	}



	public String getAlias() {
		return Alias;
	}



	public void setAlias(String alias) {
		Alias = alias;
	}



	public String getDocumentTitle() {
		return DocumentTitle;
	}



	public void setDocumentTitle(String documentTitle) {
		DocumentTitle = documentTitle;
	}



	public String getSeverity() {
		return Severity;
	}



	public void setSeverity(String severity) {
		Severity = severity;
	}



	public String getInitialReleaseDate() {
		return InitialReleaseDate;
	}



	public void setInitialReleaseDate(String initialReleaseDate) {
		InitialReleaseDate = initialReleaseDate;
	}



	public String getCurrentReleaseDate() {
		return CurrentReleaseDate;
	}



	public void setCurrentReleaseDate(String currentReleaseDate) {
		CurrentReleaseDate = currentReleaseDate;
	}



	public String getCvrfUrl() {
		return CvrfUrl;
	}



	public void setCvrfUrl(String cvrfUrl) {
		CvrfUrl = cvrfUrl;
	}
	

	@Override
	public int compare(Value u1, Value u2) {
		int resultado = u1.getAlias().compareTo(u2.getAlias());
		if(resultado == 0)
			resultado = u1.getCurrentReleaseDate().compareTo(u2.getCurrentReleaseDate());
		return resultado;
	}
    
  
}
