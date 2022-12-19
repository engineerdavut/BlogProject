package com.blog.kariyer.Entities;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Max;
import javax.validation.constraints.NotEmpty;

import org.hibernate.annotations.CreationTimestamp;

@Entity
@Table(name="posts")
public class Posts {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	@Column(length=50,nullable = false)
	@NotEmpty(message="baslik bos birakilamaz")
	@Max(value =50, message = "Maximum 50 karakter Girilebilir.")
	public String title;
	@Column(length=1500,nullable = false)
	@NotEmpty(message="baslik bos birakilamaz")
	@Max(value =1500, message = "Maximum 1500 karakter Girilebilir.")
	public String content;
	
	public boolean status; 
	@CreationTimestamp //nhibernate
	// spring jpa @CreatedDate
	private Date create_time;
	public int tagId;
	public int authorId;

	public int getId() {
		return id;
	}

	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
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

	public int getTagId() {
		return tagId;
	}

	public void setTagId(int tagId) {
		this.tagId = tagId;
	}

	public void setAuthorId(int authorId) {
		this.authorId = authorId;
	}

	public int getAuthorId() {
		return authorId;
	}


	
}
