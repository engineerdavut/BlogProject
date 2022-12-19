package com.blog.kariyer.Services.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.blog.kariyer.Core.utilities.DataResult;
import com.blog.kariyer.Core.utilities.Result;
import com.blog.kariyer.Entities.Users;

public interface IUserService {
	Result create(Users user);
	Result update(int id,Users user);
	Result delete(int id);
	DataResult<List<Users>> getAll();
	DataResult<Users> getById(int id);
	
	DataResult<List<Users>> sameName( String first_name,String last_name);
	
	DataResult<List<Users>> samePassword( String password);
	
	DataResult<Users> login(String email,String password);
	DataResult<Users> findByEmail(String email);
	DataResult<Users> findByUserName(String userName);
	DataResult<Boolean> existsByEmail(String email);
	DataResult<Boolean> existsByUserName(String username);
}
