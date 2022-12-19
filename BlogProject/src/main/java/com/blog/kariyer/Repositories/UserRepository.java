package com.blog.kariyer.Repositories;

import java.util.List;

import javax.persistence.EntityNotFoundException;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.blog.kariyer.Entities.Tags;
import com.blog.kariyer.Entities.Users;

@Repository
public interface UserRepository extends JpaRepository<Users,Integer>{
	@Query(value="select * from users where first_name=:first_name and last_name=:last_name",nativeQuery=true)
	public List<Users> sameName(@Param("first_name") String first_name,@Param("last_name") String last_name);
	@Query(value="select * from users where  password=:password ",nativeQuery=true)
	public List<Users> samePassword(@Param("password") String password);
	@Query(value="select * from users where email=:email and password=:password LIMIT 1",nativeQuery=true)
	public Users login(@Param("email") String email,@Param("password") String password);
	Users findByEmail(String email);
	Users findByUsername(String username);
	Boolean existsByEmail(String email);
	Boolean existsByUsername(String username);
    default Users findByIdOrError(Integer id) {
        return findById(id).orElseThrow(EntityNotFoundException::new);
    } 
}
