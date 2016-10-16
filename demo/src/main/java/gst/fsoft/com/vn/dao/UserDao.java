package gst.fsoft.com.vn.dao;
import gst.fsoft.com.vn.models.User;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.repository.CrudRepository;

@Transactional
public interface  UserDao extends CrudRepository<User,Long>{
	public List<User> findByUser(String user);
	
}
