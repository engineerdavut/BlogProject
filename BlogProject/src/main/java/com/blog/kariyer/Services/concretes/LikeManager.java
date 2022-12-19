package com.blog.kariyer.Services.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.blog.kariyer.Core.utilities.DataResult;
import com.blog.kariyer.Core.utilities.Result;
import com.blog.kariyer.Core.utilities.SuccessDataResult;
import com.blog.kariyer.Core.utilities.SuccessResult;
import com.blog.kariyer.Entities.Likes;

import com.blog.kariyer.Repositories.LikeRepository;
import com.blog.kariyer.Services.abstracts.ILikeService;

@Service
public class LikeManager implements ILikeService{

	private LikeRepository likeRepository;
	@Autowired
	public LikeManager(LikeRepository likeRepository){
		super();
		this.likeRepository=likeRepository;
	}

	@Override
	public Result create(Likes like) {
		// TODO Auto-generated method stub
		this.likeRepository.save(like);
		return new SuccessResult("post begenildi");
	}

	@Override
	public Result delete(int id) {
		// TODO Auto-generated method stub
		Likes myLike=this.likeRepository.findByIdOrError(id);
		this.likeRepository.delete(myLike);
		return new SuccessResult("begeni geri cekildi");
	}

	@Override
	public DataResult<Likes> getById(int id) {
		// TODO Auto-generated method stub
		return new SuccessDataResult<Likes>(this.likeRepository.findByIdOrError(id),"begeni getirildi.");
	}

	@Override
	public DataResult<List<Likes>> findByPostId(int id) {
		// TODO Auto-generated method stub
		return new SuccessDataResult<List<Likes>> 
		(this.likeRepository.findByPostId(id),"gönderinin begenileri");
	}

	@Override
	public DataResult<List<Likes>> findByUserId(int id) {
		// TODO Auto-generated method stub
		return new SuccessDataResult<List<Likes>> 
		(this.likeRepository.findByUserId(id),"kullanicinin begenileri");
	}


}
