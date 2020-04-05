package com.mindtree.company.dto;

import javax.validation.constraints.NotNull;

public class CompanyDTO {
private long companyId;
@NotNull(message = "Company Name Cannot Be Empty")
private String companyName;
@NotNull(message = "Company Location Cannot Be Empty")
private String location;
public CompanyDTO() {
	super();
	
}
public CompanyDTO(@NotNull(message = "Company Name Cannot Be Empty") String companyName,
		@NotNull(message = "Company Location Cannot Be Empty") String location) {
	super();
	this.companyName = companyName;
	this.location = location;
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
@Override
public int hashCode() {
	final int prime = 31;
	int result = 1;
	result = prime * result + ((companyName == null) ? 0 : companyName.hashCode());
	result = prime * result + ((location == null) ? 0 : location.hashCode());
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
	CompanyDTO other = (CompanyDTO) obj;
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
	return true;
}
@Override
public String toString() {
	return "CompanyDTO [companyId=" + companyId + ", companyName=" + companyName + ", location=" + location + "]";
}


		}
