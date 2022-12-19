package com.blog.kariyer.Entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Max;
import javax.validation.constraints.NotEmpty;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
@Data
@Entity
@Getter
@AllArgsConstructor
@NoArgsConstructor

@Table(name="authors")
public class Authors {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	@Column(length=50 , unique=true)
	@NotEmpty(message="bos birakilamaz")
	@Max(value =50, message = "Maximum 50 karakter Girilebilir.")
	@Setter
	public String avatar;
	@Setter
	public String author_image;
	
	@Column(length=250)
	@NotEmpty(message="bos birakilamaz")
	@Max(value =250, message = "Maximum 250 karakter Girilebilir.")
	@Setter
	public String  description;
	public int userid;
	public int getId() {
		return id;
	}
	public String getAvatar() {
		return avatar;
	}

	public void setAvatar(String avatar) {
		this.avatar = avatar;
	}
	public String getAuthor_image() {
		return author_image;
	}
	public void setAuthor_image(String author_image) {
		this.author_image = author_image;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public int getUserid() {
		return userid;
	}

}
