package com.blog.kariyer.Repositories;

import java.util.List;

import javax.persistence.EntityNotFoundException;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


import com.blog.kariyer.Entities.Likes;

@Repository
public interface LikeRepository extends JpaRepository<Likes,Integer>{
	
	List<Likes> findByPostId(int id);
	
	List<Likes> findByUserId(int id);
    default Likes findByIdOrError(Integer id) {
        return findById(id).orElseThrow(EntityNotFoundException::new);
    } 

}
