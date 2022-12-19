package com.blog.kariyer.Services.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.blog.kariyer.Core.utilities.DataResult;
import com.blog.kariyer.Core.utilities.ErrorResult;
import com.blog.kariyer.Core.utilities.Result;
import com.blog.kariyer.Core.utilities.SuccessDataResult;
import com.blog.kariyer.Core.utilities.SuccessResult;
import com.blog.kariyer.Entities.Tags;

import com.blog.kariyer.Repositories.TagRepository;
import com.blog.kariyer.Services.abstracts.ITagService;

@Service
public class TagManager implements ITagService {

	private TagRepository tagRepository;
	@Autowired
	public TagManager(TagRepository tagRepository){
		super();
		this.tagRepository=tagRepository;
	}


	@Override
	public Result create(Tags tag) {
		// TODO Auto-generated method stub
		if(!this.tagRepository.existsByName(tag.getName())) {
			this.tagRepository.save(tag);
			return  new SuccessResult("tag eklendi");
		}
		return  new ErrorResult("hata");
	}

	@Override
	public Result update(int id, Tags tag) {
		// TODO Auto-generated method stub
		Tags myTag=this.tagRepository.findByIdOrError(id);
		if(!this.tagRepository.existsByName(tag.getName()) || myTag.getName().equals(tag.getName())) {
			myTag.setName(tag.getName());
			myTag.setCount(tag.getCount());
			myTag.setFrequency(tag.getFrequency());
			this.tagRepository.save(myTag);
			return  new SuccessResult("tag guncellendi.");
		}
		return  new ErrorResult("hata");
	}

	@Override
	public Result delete(int id) {
		// TODO Auto-generated method stub
		Tags myTag=this.tagRepository.findByIdOrError(id);
		this.tagRepository.delete(myTag);
		return new SuccessResult("tag silindi");
	}

	@Override
	public DataResult<List<Tags>> getAll() {
		// TODO Auto-generated method stub
		return new SuccessDataResult<List<Tags>>(this.tagRepository.findAll(),"etiketler listelendi.");
	}

	@Override
	public DataResult<Tags> getById(int id) {
		// TODO Auto-generated method stub
		return new SuccessDataResult<Tags>(this.tagRepository.findByIdOrError(id),"etiket listelendi.");
	}

	@Override
	public DataResult<Tags> getByName(String name) {
		// TODO Auto-generated method stub
		return new SuccessDataResult<Tags>(this.tagRepository.getByName(name),"etiket listelendi.");
	}

	@Override
	public DataResult<List<Tags>> getByNameContains(String name) {
		// TODO Auto-generated method stub
		return new SuccessDataResult<List<Tags>>(this.tagRepository.getByNameContains(name),"etiketler listelendi.");
	}

	@Override
	public DataResult<List<Tags>> getByNameStartsWith(String name) {
		// TODO Auto-generated method stub
		return new SuccessDataResult<List<Tags>>(this.tagRepository.getByNameStartsWith(name),"etiketler listelendi.");
	}

	@Override
	public DataResult<Boolean> existsByName(String name) {
		// TODO Auto-generated method stub
		return new SuccessDataResult<Boolean>(this.tagRepository.existsByName(name),"etiket durumu");
	}


}
