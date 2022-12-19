package com.blog.kariyer.Services.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.blog.kariyer.Core.utilities.DataResult;
import com.blog.kariyer.Core.utilities.ErrorResult;
import com.blog.kariyer.Core.utilities.Result;
import com.blog.kariyer.Core.utilities.SuccessDataResult;
import com.blog.kariyer.Core.utilities.SuccessResult;

import com.blog.kariyer.Entities.Users;

import com.blog.kariyer.Repositories.UserRepository;
import com.blog.kariyer.Services.abstracts.IUserService;

@Service
public class UserManager implements IUserService{

	private UserRepository userRepository;
	@Autowired
	public UserManager(UserRepository userRepository){
		super();
		this.userRepository=userRepository;
	}

	@Override
	public Result create(Users user) {
		// TODO Auto-generated method stub
		if(!this.userRepository.existsByUsername(user.getUsername())
			&&  !this.userRepository.existsByEmail(user.getEmail())	) {
			this.userRepository.save(user);
			return  new SuccessResult("kullanici eklendi");
		}
		return  new ErrorResult("hata");
	}

	@Override
	public Result update(int id, Users user) {
		// TODO Auto-generated method stub
		Users myUser=this.userRepository.findByIdOrError(id);
		if(!this.userRepository.existsByUsername(user.getUsername())
				&&  !this.userRepository.existsByEmail(user.getEmail())) {
			myUser.setUsername(user.getUsername());
			myUser.setFirst_name(user.getFirst_name());
			myUser.setLast_name(user.getLast_name());
			myUser.setPassword(user.getPassword());
			myUser.setEmail(user.getEmail());
			this.userRepository.save(myUser);
			return  new SuccessResult("user guncellendi.");
		}
		return  new ErrorResult("user guncellenemedi.");
	}

	@Override
	public Result delete(int id) {
		// TODO Auto-generated method stub
		Users myUser=this.userRepository.findByIdOrError(id);
		this.userRepository.delete(myUser);
		return new SuccessResult("user silindi.");
	}

	@Override
	public DataResult<List<Users>> getAll() {
		// TODO Auto-generated method stub
		return new SuccessDataResult<List<Users>>(this.userRepository.findAll(),"kullanicilar listelendi.");
	}

	@Override
	public DataResult<Users> getById(int id) {
		// TODO Auto-generated method stub
		return new SuccessDataResult<Users>(this.userRepository.findByIdOrError(id),"kullanici listelendi.");
	}

	@Override
	public DataResult<List<Users>> sameName(String first_name, String last_name) {
		// TODO Auto-generated method stub
		return new SuccessDataResult<List<Users>>(this.userRepository.sameName(first_name,last_name),"ayni isimli kullanicilar listelendi.");
	}

	@Override
	public DataResult<List<Users>> samePassword(String password) {
		// TODO Auto-generated method stub
		return new SuccessDataResult<List<Users>>(this.userRepository.samePassword(password),"ayni sifreli kullanicilar listelendi.");
	}

	@Override
	public DataResult<Users> login(String email, String password) {
		// TODO Auto-generated method stub
		return new SuccessDataResult<Users>(this.userRepository.login(email,password),"login islemi");
	}

	@Override
	public DataResult<Users> findByEmail(String email) {
		// TODO Auto-generated method stub
		return new SuccessDataResult<Users>(this.userRepository.findByEmail(email),"emaile göre arama islemi");
	}

	@Override
	public DataResult<Users> findByUserName(String userName) {
		// TODO Auto-generated method stub
		return new SuccessDataResult<Users>(this.userRepository.findByUsername(userName),"username göre arama islemi");
	}

	@Override
	public DataResult<Boolean> existsByEmail(String email) {
		// TODO Auto-generated method stub
		return new SuccessDataResult<Boolean>(this.userRepository.existsByEmail(email),"emaile kayitli kullanici var mı?");
	}

	@Override
	public DataResult<Boolean> existsByUserName(String userName) {
		// TODO Auto-generated method stub
		return new SuccessDataResult<Boolean>(this.userRepository.existsByUsername(userName),"username e kayitli kullanici var mı?");
	}


}
