package com.blog.kariyer.Repositories;

import java.util.Date;
import java.util.List;

import javax.persistence.EntityNotFoundException;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.blog.kariyer.Entities.Comments;
import com.blog.kariyer.Entities.Likes;
import com.blog.kariyer.Entities.Posts;

@Repository
public interface PostRepository  extends JpaRepository<Posts,Integer>{
	@Query(value = "from Posts p where create_time BETWEEN :startDate AND :endDate")
	public List<Posts> getAllBetweenDates(@Param("startDate")Date startDate,@Param("endDate")Date endDate);
	
	List<Posts> findByAuthorId(int id);
	List<Posts> findByTagId(int id);
	List<Posts> findByStatus(boolean status);
	
	List<Posts> getByContentContains(String content);
	
	List<Posts> getByContentStartsWith(String content);
	
	List<Posts> getByTitleContains(String title);
	
	List<Posts> getByTitleStartsWith(String title);
	
	Posts getByTitle(String title);
	
    default Posts findByIdOrError(Integer id) {
        return findById(id).orElseThrow(EntityNotFoundException::new);
    } 

}
