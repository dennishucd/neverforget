package cn.dennishucd.neverforget.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.dennishucd.neverforget.model.User;
import cn.dennishucd.neverforget.repository.UserRepository;
import cn.dennishucd.utils.CodeMsg;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;

@Service
/* @Transactional indicates that each method in this service should run within a transaction.
 * Spring will commit the operation if the method is completed successfully
 * and will rollback if any runtime exception occurs. 
 */
@Transactional  
public class UserServiceImpl implements UserService {
	@Autowired
	private UserRepository userRepository;
	
	public ObjectNode login(User user) {
		ObjectNode node = new ObjectMapper().createObjectNode();
		
		User tUser = userRepository.findByLoginName(user.getLoginName());
		
		if (tUser == null) {
			node.put(CodeMsg.CODE, CodeMsg.FAILURE_CODE);
			node.put(CodeMsg.MSG, "用户不存在!");
		} else if (tUser.getPasswd().endsWith(user.getPasswd())) {
			node.put(CodeMsg.CODE, CodeMsg.SUCCESS_CODE);
			node.put(CodeMsg.MSG, CodeMsg.SUCCESS_MSG);
		} else {
			node.put(CodeMsg.CODE, CodeMsg.FAILURE_CODE);
			node.put(CodeMsg.MSG, "密码错误");
		}
		
		return node;
	}
}