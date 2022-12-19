package com.blog.kariyer.Entities;

import java.util.Date;

import javax.persistence.Column;
import  javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Max;
import javax.validation.constraints.NotEmpty;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import lombok.Data;
import lombok.Setter;
@Data
@Entity
@Table(name="comments")
public class Comments {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public int id;
	@Column(length=300)
	@NotEmpty(message="bos birakilamaz")
	@Max(value =300, message = "Maximum 300 karakter Girilebilir.")
	@Setter
	public String content;
	@Setter
	public boolean status; 
	@CreationTimestamp
	public Date create_time;
	@UpdateTimestamp
	public Date updated_time;
	public int postId;
	public int userId;
	public int getId() {
		return id;
	}

	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public boolean isStatus() {
		return status;
	}
	public void setStatus(boolean status) {
		this.status = status;
	}
	public Date getCreate_time() {
		return create_time;
	}

	public Date getUpdated_time() {
		return updated_time;
	}

	public int getPostId() {
		return postId;
	}

	public int getUserId() {
		return userId;
	}

}
