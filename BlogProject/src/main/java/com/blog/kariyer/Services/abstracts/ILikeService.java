package com.blog.kariyer.Services.abstracts;

import java.util.List;

import com.blog.kariyer.Core.utilities.DataResult;
import com.blog.kariyer.Core.utilities.Result;
import com.blog.kariyer.Entities.Likes;

public interface ILikeService {
	Result create(Likes like);
	Result delete(int id);
	Result getById(int id);
	
	DataResult<List<Likes>> findByPostId(int id);
	
	DataResult<List<Likes>> findByUserId(int id);

}
