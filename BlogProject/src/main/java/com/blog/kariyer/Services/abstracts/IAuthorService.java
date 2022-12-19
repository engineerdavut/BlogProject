package com.blog.kariyer.Services.abstracts;

import java.util.List;

import com.blog.kariyer.Core.utilities.DataResult;
import com.blog.kariyer.Core.utilities.Result;
import com.blog.kariyer.Entities.Authors;

public interface IAuthorService {
	Result create(Authors author);
	Result update(int id,Authors author);
	Result delete(int id);
	DataResult<List<Authors>> getAll();
	DataResult<Authors> getById(int id);
	
	DataResult<Authors> findByAvatar( String avatar);
	DataResult<List<Authors>> getByDescriptionContains(String description);
	
	DataResult<List<Authors>> getByDescriptionStartsWith(String description);
	DataResult<Boolean> existsByAvatar(String avatar);
	

}
