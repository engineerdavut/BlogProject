package com.blog.kariyer.Services.concretes;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.blog.kariyer.Core.utilities.DataResult;
import com.blog.kariyer.Core.utilities.ErrorResult;
import com.blog.kariyer.Core.utilities.Result;
import com.blog.kariyer.Core.utilities.SuccessDataResult;
import com.blog.kariyer.Core.utilities.SuccessResult;
import com.blog.kariyer.Entities.Authors;
import com.blog.kariyer.Repositories.AuthorRepository;

import com.blog.kariyer.Services.abstracts.IAuthorService;




@Service
public class AuthorManager implements IAuthorService{
	
	private AuthorRepository authorRepository;
	@Autowired
	public AuthorManager(AuthorRepository authorRepository) {
		super();
		this.authorRepository=authorRepository;
	}

	@Override
	public Result create(Authors author) {
		// TODO Auto-generated method stub
		if(!this.authorRepository.existsByAvatar(author.avatar)) {
			this.authorRepository.save(author);
			return  new SuccessResult("yazar eklendi");
		}
		return new ErrorResult("yazar zaten kayitli.");
	}

	@Override
	public Result update(int id, Authors author) {
		// TODO Auto-generated method stub
		Authors myAuthor=this.authorRepository.findByIdOrError(id);
		if(!this.authorRepository.existsByAvatar(author.getAvatar()) || myAuthor.getAvatar().equals(author.getAvatar())) {
			myAuthor.setAvatar(author.getAvatar());
			myAuthor.setDescription(author.getDescription());
			myAuthor.setAuthor_image(author.getAuthor_image());
			this.authorRepository.save(myAuthor);
			return new SuccessResult("yazar guncellendi");
		}
		return new ErrorResult("yazar guncellenemedi");

	}

	@Override
	public Result delete(int id) {
		Authors myAuthor=this.authorRepository.findByIdOrError(id);
		this.authorRepository.delete(myAuthor);
		return new SuccessResult("yazar silindi");
	}

	@Override
	public DataResult<List<Authors>> getAll() {
		// TODO Auto-generated method stub
		return new SuccessDataResult<List<Authors>>
		(this.authorRepository.findAll(),"data listelendi.");
	}

	@Override
	public DataResult<Authors> getById(int id) {
		// TODO Auto-generated method stub
		return new SuccessDataResult<Authors>
		(this.authorRepository.findByIdOrError(id),"data listelendi.");
	}

	@Override
	public DataResult<Authors> findByAvatar(String avatar) {
		// TODO Auto-generated method stub
		return new SuccessDataResult<Authors>
		(this.authorRepository.findByAvatar(avatar),"yazar listelendi.");
	}

	@Override
	public DataResult<List<Authors>> getByDescriptionContains(String description) {
		// TODO Auto-generated method stub
		return new SuccessDataResult<List<Authors>>
		(this.authorRepository.getByDescriptionContains(description)," yazarlar listelendi.");
	}

	@Override
	public DataResult<List<Authors>> getByDescriptionStartsWith(String description) {
		// TODO Auto-generated method stub
		return new SuccessDataResult<List<Authors>>
		(this.authorRepository.getByDescriptionStartsWith(description)," yazarlar listelendi.");
	}

	@Override
	public DataResult<Boolean> existsByAvatar(String avatar) {
		// TODO Auto-generated method stub
		return new SuccessDataResult<Boolean>
		(this.authorRepository.existsByAvatar(avatar)," yazarlar listelendi.");
	}


}
