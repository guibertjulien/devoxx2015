package com.palo.it.devoxx2015.back.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotBlank;

import com.palo.it.devoxx2015.back.services.dao.Identifiable;

@Entity
public class Player implements Identifiable<Long> {

    // =========================================================================
    // ATTRIBUTES
    // =========================================================================
    private static final long serialVersionUID = -5527566248002296042L;

    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    private Long              uid;

    @NotBlank
    @NotNull
    private String            firstName;

    @NotBlank
    @NotNull
    private String            lastName;

    @Email
    @NotNull
    private String            email;

    private String            company;

    private String            job;

    // =========================================================================
    // CONSTRUCTOR
    // =========================================================================
    public Player() {
        super();
    }

    // =========================================================================
    // OVERRIDES
    // =========================================================================
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((uid == null) ? 0 : uid.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        boolean result = this == obj;

        Player other = null;
        if (!result && obj != null && obj instanceof Player) {
            other = (Player) obj;
        }

        if (other != null) {
            if (uid == null || other.getUid() == null) {
                //@formatter:off
                boolean sameFirstname = firstName==null?other.getFirstName()==null:firstName.equals(other.getFirstName());
                boolean sameLastname  = lastName ==null?other.getLastName()==null:lastName.equals(other.getLastName());
                boolean sameEmail     = email    ==null?other.getEmail()==null:email.equals(other.getEmail());
                boolean sameCompany   = company  ==null?other.getCompany()==null:company.equals(other.getCompany());
                boolean sameJob       = job      ==null?other.getFirstName()==null:job.equals(other.getJob());
                //@formatter:on
                result = sameFirstname && sameLastname && sameEmail && sameCompany && sameJob;

            } else {
                result = uid.equals(other.getUid());
            }
        }
        return result;
    }

    // =========================================================================
    // GETTERS & SETTERS
    // =========================================================================

    @Override
    public Long getUid() {
        return uid;
    }

    @Override
    public void setUid(Long uid) {
        this.uid = uid;

    }

    @Override
    public boolean isUidSet() {
        return uid != null;
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

}
