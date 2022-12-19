package com.blog.kariyer.Entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.Max;
import javax.validation.constraints.NotEmpty;

import lombok.Data;
import lombok.Getter;

@Entity
@Data
@Getter
@Table(name="users")
public class Users {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private  int  id;
	@NotEmpty(message="baslik bos birakilamaz")
	@Column(length=25, unique=true)
	@Max(value =25, message = "Maximum 25 karakter Girilebilir.")
	public String username;
	@NotEmpty(message="baslik bos birakilamaz")
	@Max(value =25, message = "Maximum 25 karakter Girilebilir.")
	public String first_name;
	@NotEmpty(message="baslik bos birakilamaz")
	@Max(value =25, message = "Maximum 25 karakter Girilebilir.")
	public String last_name;
	@NotEmpty(message="baslik bos birakilamaz")
	@Max(value =40, message = "Maximum 40 karakter Girilebilir.")
	public String password;
	@Column(length=50, unique=true)
	@Email(message="email hatali")
	public String email;
	public int getId() {
		return id;
	}

	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getFirst_name() {
		return first_name;
	}
	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}
	public String getLast_name() {
		return last_name;
	}
	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	

}
