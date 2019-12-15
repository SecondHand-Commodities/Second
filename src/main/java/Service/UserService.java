package Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.secondhand.springboot.bean.Person;
import com.secondhand.springboot.bean.User;
import com.secondhand.springboot.mapper.PersonMapper;

@Service
public class UserService {
	@Autowired
	PersonMapper personMapper;
	
	public boolean Login(String usename,String password) {
		Integer number=personMapper.checkUser(usename, password);
		if (number >0)
			return true;
		else return false;
	}
	
	public boolean Regist(User user,Person person ,String confirmPassword) {
		Integer number=personMapper.checkUser(user.getUserName(), user.getPassword());
		if (number<=0) return false;
		Integer isInsertUser =personMapper.insertUserOne(user);
		if (isInsertUser<=0) return false;
		Integer isInsertPerson =personMapper.insertPerson(person);
		if (isInsertPerson<=0)
			return false;
		else return true;		
	}
}
