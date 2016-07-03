package cn.dennishucd.neverforget.service;


import cn.dennishucd.neverforget.model.User;

import com.fasterxml.jackson.databind.node.ObjectNode;


public interface UserService {

	public ObjectNode login(User user);
	
}