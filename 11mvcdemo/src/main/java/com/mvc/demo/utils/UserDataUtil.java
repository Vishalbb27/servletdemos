package com.mvc.demo.utils;

import java.util.ArrayList;
import java.util.List;

import com.mvc.demo.model.User;

public class UserDataUtil {
	public static List<User> getUsers(){
		
		List<User> user= new ArrayList<>();
		user.add(new User("jack","Wilson","j@gmail.com","123"));
		return user;
		
	}
}
