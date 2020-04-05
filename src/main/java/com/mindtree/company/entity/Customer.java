package com.mindtree.company.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Customer implements Comparable<Customer>{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int customerId;
	private String customerName;
	private int age;
	private String gender;
	private double premiumToPay;
	@ManyToOne
	@JsonIgnore
	private Policy policy;
	public Customer() {
		super();
		
	}
	public Customer(String customerName, int age, String gender, double premiumToPay, Policy policy) {
		super();
		this.customerName = customerName;
		this.age = age;
		this.gender = gender;
		this.premiumToPay = premiumToPay;
		this.policy = policy;
	}
	public int getCustomerId() {
		return customerId;
	}
	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}
	public String getCustomerName() {
		return customerName;
	}
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public double getPremiumToPay() {
		return premiumToPay;
	}
	public void setPremiumToPay(double premiumToPay) {
		this.premiumToPay = premiumToPay;
	}
	public Policy getPolicy() {
		return policy;
	}
	public void setPolicy(Policy policy) {
		this.policy = policy;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + age;
		result = prime * result + customerId;
		result = prime * result + ((customerName == null) ? 0 : customerName.hashCode());
		result = prime * result + ((gender == null) ? 0 : gender.hashCode());
		result = prime * result + ((policy == null) ? 0 : policy.hashCode());
		long temp;
		temp = Double.doubleToLongBits(premiumToPay);
		result = prime * result + (int) (temp ^ (temp >>> 32));
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
		Customer other = (Customer) obj;
		if (age != other.age)
			return false;
		if (customerId != other.customerId)
			return false;
		if (customerName == null) {
			if (other.customerName != null)
				return false;
		} else if (!customerName.equals(other.customerName))
			return false;
		if (gender == null) {
			if (other.gender != null)
				return false;
		} else if (!gender.equals(other.gender))
			return false;
		if (policy == null) {
			if (other.policy != null)
				return false;
		} else if (!policy.equals(other.policy))
			return false;
		if (Double.doubleToLongBits(premiumToPay) != Double.doubleToLongBits(other.premiumToPay))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Customer [customerId=" + customerId + ", customerName=" + customerName + ", age=" + age + ", gender="
				+ gender + ", premiumToPay=" + premiumToPay + ", policy=" + policy + "]";
	}
	@Override
	public int compareTo(Customer o) {
		
		return -(int)(this.customerName.compareToIgnoreCase(o.customerName));
	}
	

}
