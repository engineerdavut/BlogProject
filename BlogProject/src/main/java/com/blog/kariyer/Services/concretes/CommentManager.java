package com.blog.kariyer.Services.concretes;


import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.blog.kariyer.Core.utilities.DataResult;
import com.blog.kariyer.Core.utilities.Result;
import com.blog.kariyer.Core.utilities.SuccessDataResult;
import com.blog.kariyer.Core.utilities.SuccessResult;
import com.blog.kariyer.Entities.Comments;

import com.blog.kariyer.Repositories.CommentRepository;
import com.blog.kariyer.Services.abstracts.ICommentService;

@Service
public class CommentManager implements ICommentService{
	
	private CommentRepository commentRepository;
	
	@Autowired
	public CommentManager(CommentRepository commentRepository){
		super();
		this.commentRepository=commentRepository;
	}

	@Override
	public Result create(Comments comment) {
		// TODO Auto-generated method stub
		this.commentRepository.save(comment);
		return new SuccessResult("yorum eklendi.");
	}

	@Override
	public Result update(int id, Comments comment) {
		// TODO Auto-generated method stub
		Comments myComment=this.commentRepository.findByIdOrError(id);
		myComment.setContent(comment.content);
		myComment.setStatus(comment.status);
		this.commentRepository.save(myComment);
		return new SuccessResult("comment guncellendi");
	}

	@Override
	public Result delete(int id) {
		// TODO Auto-generated method stub
		Comments myComment=this.commentRepository.findByIdOrError(id);
		this.commentRepository.delete(myComment);
		return new SuccessResult("comment silindi");
	}
/*
	@Override
	public DataResult<List<Comments>> getAll() {
		// TODO Auto-generated method stub
		return new  SuccessDataResult<List<Comments>>(this.commentRepository.findAll(),"");
	}
*/
	@Override
	public DataResult<Comments> getById(int id) {
		// TODO Auto-generated method stub
		return new  SuccessDataResult<Comments>(this.commentRepository.findByIdOrError(id),"yorum bulundu");
	}

	@Override
	public DataResult<List<Comments>> getAllBetweenDates(Date startDate, Date endDate) {
		// TODO Auto-generated method stub
		return new  SuccessDataResult<List<Comments>>
		(this.commentRepository.getAllBetweenDates(startDate,endDate),"iki tarih arasında yorumlar listelendi.");
	}

	@Override
	public DataResult<List<Comments>> findByPostId(int id) {
		// TODO Auto-generated method stub
		return new  SuccessDataResult<List<Comments>>
		(this.commentRepository.findByPostId(id),"gönderinin yorumları.");
	}

	@Override
	public DataResult<List<Comments>> findByUserId(int id) {
		// TODO Auto-generated method stub
		return new  SuccessDataResult<List<Comments>>
		(this.commentRepository.findByUserId(id),"kullanıcının yorumları.");
	}

	@Override
	public DataResult<List<Comments>> findByStatus(boolean status) {
		// TODO Auto-generated method stub
		return new  SuccessDataResult<List<Comments>>
		(this.commentRepository.findByStatus(status),"duruma göre yorumlar.");
	}

	@Override
	public DataResult<List<Comments>> getByContentContains(String content) {
		// TODO Auto-generated method stub
		return new  SuccessDataResult<List<Comments>>
		(this.commentRepository.getByContentContains(content),"aranan yazıyı içeren yorumlar.");
	}

	@Override
	public DataResult<List<Comments>> getByContentStartsWith(String content) {
		// TODO Auto-generated method stub
		return new  SuccessDataResult<List<Comments>>
		(this.commentRepository.getByContentStartsWith(content),"aranan yazı ile başlayan yorumlar.");
	}

	@Override
	public DataResult<List<Comments>> findByUserIdAndPostId(int userid, int postid) {
		// TODO Auto-generated method stub
		return new  SuccessDataResult<List<Comments>>
		(this.commentRepository.findByUserIdAndPostId(userid,postid) ,"kullanicinin gönderiye yorumları..");
	}

	@Override
	public DataResult<List<Comments>> getByUserIdAllBetweenDates(int userid, Date startDate, Date endDate) {
		// TODO Auto-generated method stub
		return new  SuccessDataResult<List<Comments>>
		(this.commentRepository.getByUserIdAllBetweenDates(userid,startDate,endDate) ,"kullanicinin tarihe göre yorumları..");
	}

	@Override
	public DataResult<List<Comments>> getByPostIdAllBetweenDates(int postid, Date startDate, Date endDate) {
		// TODO Auto-generated method stub
		return new  SuccessDataResult<List<Comments>>
		(this.commentRepository.getByUserIdAllBetweenDates(postid,startDate,endDate) ,"gönderinin tarihe göre yorumları..");
	}



}
