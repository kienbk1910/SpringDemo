package gst.fsoft.com.vn.controller;

import gst.fsoft.com.vn.dao.UserRepository;
import gst.fsoft.com.vn.dto.CreateUser;
import gst.fsoft.com.vn.model.ApplicationUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Role;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by chikien276 on 21/10/2016.
 */
@Controller
public class UserController {

    @Autowired
    private UserRepository repository;

    @RequestMapping("/user")
    public String index(Model modelAndView) {
        Iterable<ApplicationUser> users = repository.findAll();
        modelAndView.addAttribute("users", users);
        return "user/index";
    }

    @RequestMapping(value = "/user/create", method = RequestMethod.GET)
    public String create() {
        return "user/create";
    }

    @RequestMapping(value = "/user/create", method = RequestMethod.POST)
    public String createPost(CreateUser dto) {
        return "redirect:/";
    }

}
