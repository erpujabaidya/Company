package com.mindtree.company.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Company {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
private long companyId;
	private String companyName;
	private String location;
	@OneToMany(mappedBy = "company",cascade = CascadeType.ALL)
	private List<Policy> policys;
	@JsonIgnore
	public Company() {
		super();
		
	}
	@Override
	public String toString() {
		return "Company [companyId=" + companyId + ", companyName=" + companyName + ", location=" + location
				+ ", policys=" + policys + "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (companyId ^ (companyId >>> 32));
		result = prime * result + ((companyName == null) ? 0 : companyName.hashCode());
		result = prime * result + ((location == null) ? 0 : location.hashCode());
		result = prime * result + ((policys == null) ? 0 : policys.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Company other = (Company) obj;
		if (companyId != other.companyId)
			return false;
		if (companyName == null) {
			if (other.companyName != null)
				return false;
		} else if (!companyName.equals(other.companyName))
			return false;
		if (location == null) {
			if (other.location != null)
				return false;
		} else if (!location.equals(other.location))
			return false;
		if (policys == null) {
			if (other.policys != null)
				return false;
		} else if (!policys.equals(other.policys))
			return false;
		return true;
	}
	public long getCompanyId() {
		return companyId;
	}
	public void setCompanyId(long companyId) {
		this.companyId = companyId;
	}
	public String getCompanyName() {
		return companyName;
	}
	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public List<Policy> getPolicys() {
		return policys;
	}
	public void setPolicys(List<Policy> policys) {
		this.policys = policys;
	}
	public Company(String companyName, String location, List<Policy> policys) {
		super();
		this.companyName = companyName;
		this.location = location;
		this.policys = policys;
	}
	
	
}
