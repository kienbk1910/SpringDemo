package gst.fsoft.com.vn.controller;

import gst.fsoft.com.vn.dao.UserRepository;
import gst.fsoft.com.vn.model.ApplicationUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Role;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by chikien276 on 21/10/2016.
 */
@Controller
public class UserController {

    @Autowired
    private UserRepository repository;

    @RequestMapping("/user")
    @PreAuthorize("hasRole('ADMIN')")
    public String index(ModelAndView modelAndView) {
        Iterable<ApplicationUser> users = repository.findAll();
        modelAndView.addObject("users", users);
        return "user/index";
    }
}
