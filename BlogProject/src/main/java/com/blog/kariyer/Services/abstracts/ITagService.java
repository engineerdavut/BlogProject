package com.blog.kariyer.Services.abstracts;

import java.util.List;

import com.blog.kariyer.Core.utilities.DataResult;
import com.blog.kariyer.Core.utilities.Result;
import com.blog.kariyer.Entities.Tags;

public interface ITagService {
	Result create(Tags tag);
	Result update(int id,Tags tag);
	Result delete(int id);
	DataResult<List<Tags>> getAll();
	DataResult<Tags> getById(int id);
	
	DataResult<Tags> getByName(String name);
	DataResult<List<Tags>> getByNameContains(String name);
	
	DataResult<List<Tags>> getByNameStartsWith(String name);
	DataResult<Boolean> existsByName(String name);
}
