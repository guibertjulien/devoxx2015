package com.palo.fablab.domain;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;


public class PlayerDTO {

	private String id;
	
	private String firstName;
	
	private String lastName;
	
	private String email;
	
	private String company;
	
	private String job;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
	}

	public String getJob() {
		return job;
	}

	public void setJob(String job) {
		this.job = job;
	}
	
	@Override
	public boolean equals(Object obj){
		if (obj instanceof PlayerDTO) {
			PlayerDTO other = (PlayerDTO) obj;
	        EqualsBuilder builder = new EqualsBuilder();
	        builder.append(getId(), other.getId());
	        builder.append(getFirstName(), other.getFirstName());
	        builder.append(getLastName(), other.getLastName());
	        builder.append(getEmail(), other.getEmail());
	        builder.append(getCompany(), other.getCompany());
	        builder.append(getJob(), other.getJob());
	        return builder.isEquals();
	    }
	    return false;
	}
	
	
	@Override
	public int hashCode(){
		HashCodeBuilder builder = new HashCodeBuilder();
	    builder.append(getId());
	    builder.append(getFirstName());
	    builder.append(getLastName());
	    return builder.toHashCode();
	}
	
	
	
}
