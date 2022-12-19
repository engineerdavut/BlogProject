package com.blog.kariyer.Repositories;

import java.util.Date;
import java.util.List;

import javax.persistence.EntityNotFoundException;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;


import com.blog.kariyer.Entities.Comments;






@Repository
public interface CommentRepository extends JpaRepository<Comments,Integer>{

	
	List<Comments> findByPostId(int id);
	
	List<Comments> findByUserId(int id);
	
	List<Comments> findByUserIdAndPostId(int userid,int postid);
	
	List<Comments> findByStatus(boolean status);
	
	List<Comments> getByContentContains(String content);
	
	List<Comments> getByContentStartsWith(String content);
	
	@Query(value = "from Comments c where create_time BETWEEN :startDate AND :endDate")
	public List<Comments> getAllBetweenDates(@Param("startDate")Date startDate,@Param("endDate")Date endDate);
	
	@Query(value = "from Comments c where user_id=:userid and create_time BETWEEN :startDate AND :endDate")
	public List<Comments> getByUserIdAllBetweenDates(@Param("userid")int userid,
			@Param("startDate")Date startDate,@Param("endDate")Date endDate);
	@Query(value = "from Comments c where post_id=:postid and create_time BETWEEN :startDate AND :endDate")
	public List<Comments> getByPostIdAllBetweenDates(@Param("postid")int postid,
			@Param("startDate")Date startDate,@Param("endDate")Date endDate);
	
	
    default Comments findByIdOrError(Integer id) {
        return findById(id).orElseThrow(EntityNotFoundException::new);
    } 
	
}
