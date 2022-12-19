package com.blog.kariyer.Services.concretes;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.blog.kariyer.Core.utilities.DataResult;
import com.blog.kariyer.Core.utilities.Result;
import com.blog.kariyer.Core.utilities.SuccessDataResult;
import com.blog.kariyer.Core.utilities.SuccessResult;
import com.blog.kariyer.Entities.Posts;

import com.blog.kariyer.Repositories.PostRepository;
import com.blog.kariyer.Services.abstracts.IPostService;

@Service
public class PostManager implements IPostService{
	
	private PostRepository postRepository;
	@Autowired
	public PostManager(PostRepository postRepository){
		super();
		this.postRepository=postRepository;
	}

	@Override
	public Result create(Posts post) {
		// TODO Auto-generated method stub
		this.postRepository.save(post);
		return new SuccessResult("post eklendi");
	}

	@Override
	public Result update(int id, Posts post) {
		// TODO Auto-generated method stub
		Posts myPost=this.postRepository.findByIdOrError(id);
		myPost.setTitle(post.getTitle());
		myPost.setContent(post.getContent());
		myPost.setStatus(post.isStatus());
		this.postRepository.save(myPost);
		return new SuccessResult("post guncellendi.");
	}

	@Override
	public Result delete(int id) {
		// TODO Auto-generated method stub
		Posts myPost=this.postRepository.findByIdOrError(id);
		this.postRepository.delete(myPost);
		return new SuccessResult("post silindi");
	}

	@Override
	public DataResult<List<Posts>> getAll() {
		// TODO Auto-generated method stub
		return new SuccessDataResult<List<Posts>>(this.postRepository.findAll(),"gönderiler listelendi.");
	}

	@Override
	public DataResult<Posts> getById(int id) {
		// TODO Auto-generated method stub
		return new SuccessDataResult<Posts>(this.postRepository.findByIdOrError(id),"gönderi listelendi.");
	}

	@Override
	public DataResult<Page<Posts>> getPaginated(int pageNo, int pageSize) {
		// TODO Auto-generated method stub
		Pageable pageable = PageRequest.of(pageNo-1, pageSize);
		return new SuccessDataResult<Page<Posts>>(this.postRepository.findAll(pageable),"gönderiler listelendi.");
	}

	@Override
	public DataResult<Page<Posts>> getPaginatedAndSorted(int pageNo, int pageSize, String sortField, String sortDirection) {
		// TODO Auto-generated method stub
	    Sort sort = sortDirection.equalsIgnoreCase(Sort.Direction.ASC.name()) ? Sort.by(sortField).ascending() :
	        Sort.by(sortField).descending();
	    
	       Pageable pageable = PageRequest.of(pageNo - 1, pageSize, sort);
	       return  new SuccessDataResult<Page<Posts>>(this.postRepository.findAll(pageable),"gönderiler listelendi.");
		 
	}

	@Override
	public DataResult<List<Posts>> findByAuthorId(int id) {
		// TODO Auto-generated method stub
		return new SuccessDataResult<List<Posts>>(this.postRepository.findByAuthorId(id),"kullanicinin gönderileri listelendi.");
	}

	@Override
	public DataResult<List<Posts>> findByTagId(int id) {
		// TODO Auto-generated method stub
		return new SuccessDataResult<List<Posts>>(this.postRepository.findByTagId(id),"etiketin gönderileri listelendi.");
	}

	@Override
	public DataResult<List<Posts>> findByStatus(boolean status) {
		// TODO Auto-generated method stub
		return new SuccessDataResult<List<Posts>>(this.postRepository.findByStatus(status),"gönderiler duruma göre listelendi.");
	}

	@Override
	public DataResult<List<Posts>> getByContentContains(String content) {
		// TODO Auto-generated method stub
		return new SuccessDataResult<List<Posts>>(this.postRepository.getByContentContains(content)," listelendi.");
	}

	@Override
	public DataResult<List<Posts>> getByContentStartsWith(String content) {
		// TODO Auto-generated method stub
		return new SuccessDataResult<List<Posts>>(this.postRepository.getByContentStartsWith(content)," listelendi.");
	}

	@Override
	public DataResult<List<Posts>> getByTitleContains(String title) {
		// TODO Auto-generated method stub
		return new SuccessDataResult<List<Posts>>(this.postRepository.getByTitleContains(title)," listelendi.");
	}

	@Override
	public DataResult<List<Posts>> getByTitleStartsWith(String title) {
		// TODO Auto-generated method stub
		return new SuccessDataResult<List<Posts>>(this.postRepository.getByTitleStartsWith(title)," listelendi.");
	}

	@Override
	public DataResult<Posts> getByTitle(String title) {
		// TODO Auto-generated method stub
		return new SuccessDataResult<Posts>(this.postRepository.getByTitle(title)," listelendi.");
	}

	@Override
	public DataResult<List<Posts>> getAllBetweenDates(Date startDate, Date endDate) {
		// TODO Auto-generated method stub
		return new SuccessDataResult<List<Posts>>(this.postRepository.getAllBetweenDates(startDate,endDate)," listelendi.");
	}



}
