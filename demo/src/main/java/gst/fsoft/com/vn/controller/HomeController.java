package gst.fsoft.com.vn.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.ui.Model;
import gst.fsoft.com.vn.dao.UserDao;
import gst.fsoft.com.vn.models.User;
import org.springframework.web.bind.annotation.ModelAttribute;
/**
 * 
 * @author kienpd2 
 *
 */

@Controller
public class HomeController {
	@Autowired
    private UserDao userDao;
	
	@RequestMapping("/")
	ModelAndView  home(@RequestParam(value="user", required=false, defaultValue="") String username){
		ModelAndView mav = new ModelAndView("index");
		mav.addObject("current",username);
		if (username.length() >0){
			User user = new User(username);
			userDao.save(user);
		}
		List<User> allUser = (List<User>) userDao.findAll();
		mav.addObject("users",allUser);
		return mav;
	}
	@RequestMapping("/login")
	String addUser(){
		
		return "login";
	}
}
