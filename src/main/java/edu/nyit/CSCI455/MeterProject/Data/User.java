package edu.nyit.CSCI455.MeterProject.Data;

import java.util.Date;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "User")
public class User{

	@Id
	public String Id;
	
	private String firstName;
	private String lastName;
	private Date dateAdded;
	private String email;
	private String password;
	private Boolean admin;
	
	public User (){
		
	}
	public User (String first, String last, String email, String password){
		firstName = first;
		lastName = last;
		this.email = email;
		this.password = password;
		admin = false;
		dateAdded = new Date();
		Id = this.lastName + this.firstName + dateAdded;
	}
	public User (String first, String last, String email, String password, boolean admin){
		firstName = first;
		lastName = last;
		this.email = email;
		this.password = password;
		this.admin = admin;
		dateAdded = new Date();
		Id = this.lastName + this.firstName + dateAdded;
	}
	public User (String first, String last, String email, String password, boolean admin, Date added){
		firstName = first;
		lastName = last;
		this.email = email;
		this.password = password;
		this.admin = admin;
		dateAdded = added;
		Id = this.lastName + this.firstName + dateAdded;
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
	public Date getDateAdded() {
		return dateAdded;
	}
	public void setDateAdded(Date dateAdded) {
		this.dateAdded = dateAdded;
	}
	public String getEmail() {
		return email;
	}
	public void setemail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Boolean getAdmin() {
		return admin;
	}
	public void setAdmin(Boolean admin) {
		this.admin = admin;
	}
}
