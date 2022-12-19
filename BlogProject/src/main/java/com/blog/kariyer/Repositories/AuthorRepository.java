package com.blog.kariyer.Repositories;

import java.util.List;

import javax.persistence.EntityNotFoundException;
import javax.security.auth.message.callback.PrivateKeyCallback.Request;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

import com.blog.kariyer.Entities.Authors;




@Repository
public interface AuthorRepository extends JpaRepository<Authors,Integer> {

	Authors findByAvatar( String avatar);
	List<Authors> getByDescriptionContains(String description);
	
	List<Authors> getByDescriptionStartsWith(String description);
	Boolean existsByAvatar(String avatar);
    default Authors findByIdOrError(Integer id) {
        return findById(id).orElseThrow(EntityNotFoundException::new);
    } 
}
