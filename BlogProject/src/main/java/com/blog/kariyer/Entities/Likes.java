package com.blog.kariyer.Entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

@Entity
@Table(name="likes")
public class Likes {
		@Id
		@GeneratedValue(strategy=GenerationType.IDENTITY)
		private int id;
		@NotEmpty(message="bos birakilamaz")
		public int userId;
		@NotEmpty(message="bos birakilamaz")
		public int postId;
}
