package com.blog.kariyer.Services.abstracts;

import java.util.Date;
import java.util.List;

import org.springframework.data.repository.query.Param;

import com.blog.kariyer.Core.utilities.DataResult;
import com.blog.kariyer.Core.utilities.Result;
import com.blog.kariyer.Entities.Comments;

public interface ICommentService {
	Result create(Comments comment);
	Result update(int id,Comments comment);
	Result delete(int id);
	//DataResult<List<Comments>> getAll();
	DataResult<Comments> getById(int id);
	
	
	DataResult<List<Comments>> findByPostId(int id);
	
	DataResult<List<Comments>> findByUserId(int id);
	
	DataResult<List<Comments>> findByUserIdAndPostId(int userid,int postid);
	
	DataResult<List<Comments>> findByStatus(boolean status);
	
	DataResult<List<Comments>> getByContentContains(String content);
	
	DataResult<List<Comments>> getByContentStartsWith(String content);
	
	DataResult<List<Comments>> getAllBetweenDates(Date startDate,Date endDate);
	
	DataResult<List<Comments>> getByUserIdAllBetweenDates(int userid,Date startDate,Date endDate);
	
	DataResult<List<Comments>> getByPostIdAllBetweenDates(int postid,Date startDate,Date endDate);
}
