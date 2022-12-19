package com.blog.kariyer.Services.abstracts;

import java.util.Date;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.repository.query.Param;

import com.blog.kariyer.Core.utilities.DataResult;
import com.blog.kariyer.Core.utilities.Result;
import com.blog.kariyer.Entities.Posts;




public interface IPostService {
	Result create(Posts post);
	Result update(int id,Posts post);
	Result delete(int id);
	DataResult<List<Posts>> getAll();
	DataResult<Posts> getById(int id);

	//sayfalama
	DataResult<Page<Posts>> getPaginated(int pageNo,int pageSize);
	DataResult<Page<Posts>> getPaginatedAndSorted(int pageNo, int pageSize, String sortField, String sortDirection);
	
	DataResult<List<Posts>>  findByAuthorId(int id);
	DataResult<List<Posts>>  findByTagId(int id);
	DataResult<List<Posts>>  findByStatus(boolean status);
	
	DataResult<List<Posts>>  getByContentContains(String content);
	
	DataResult<List<Posts>>  getByContentStartsWith(String content);
	
	DataResult<List<Posts>>  getByTitleContains(String title);
	
	DataResult<List<Posts>>  getByTitleStartsWith(String title);
	
	DataResult<Posts>  getByTitle(String title);
	
	DataResult<List<Posts>> getAllBetweenDates(Date startDate,Date endDate);
}
