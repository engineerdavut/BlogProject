package com.blog.kariyer.Repositories;

import java.util.List;

import javax.persistence.EntityNotFoundException;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


import com.blog.kariyer.Entities.Tags;
@Repository
public interface TagRepository  extends JpaRepository<Tags,Integer>{
	Tags getByName(String name);
	List<Tags> getByNameContains(String name);
	
	List<Tags> getByNameStartsWith(String name);
	Boolean existsByName(String name);
    default Tags findByIdOrError(Integer id) {
        return findById(id).orElseThrow(EntityNotFoundException::new);
    } 
}
