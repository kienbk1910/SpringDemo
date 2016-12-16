package gst.fsoft.com.vn.controller;

import com.google.gson.ExclusionStrategy;
import com.google.gson.FieldAttributes;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import gst.fsoft.com.vn.dao.UserRepository;
import gst.fsoft.com.vn.dto.CreateUser;
import gst.fsoft.com.vn.dto.DeleteUserModel;
import gst.fsoft.com.vn.dto.PasswordModel;
import gst.fsoft.com.vn.model.ApplicationUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Role;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.HttpRequestHandler;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletResponse;
import java.util.Objects;

/**
 * Created by chikien276 on 21/10/2016.
 */
@Controller
public class UserController {

    @Autowired
    private UserRepository repository;

    @Autowired
    private PasswordEncoder encoder;

    @RequestMapping("/user")
    public String index(Model modelAndView, @RequestParam(name = "message", required = false) String message) {
        Iterable<ApplicationUser> users = repository.findAll();
        modelAndView.addAttribute("users", users);
        modelAndView.addAttribute("message", message);
        Gson gson = new GsonBuilder().excludeFieldsWithoutExposeAnnotation().create();
        modelAndView.addAttribute("usersInJson", gson.toJson(users));
        return "user/index";
    }

    @RequestMapping(value = "/user/create", method = RequestMethod.GET)
    public String create() {
        return "user/create";
    }

    @RequestMapping(value = "/user/create", method = RequestMethod.POST)
    public String createPost(@ModelAttribute CreateUser dto, Model model) {
        ApplicationUser user = repository.findOne(dto.userName);
        if (user != null) {
            model.addAttribute("message", "User exist");
            return "/user/create";
        }
        if (!Objects.equals(dto.getPassword(), dto.getRetypePassword())) {
            model.addAttribute("message", "Password mismatch");
            return "/user/create";
        }
        ApplicationUser newUser = new ApplicationUser();
        newUser.password = encoder.encode(dto.password);
        newUser.enabled = true;
        newUser.userName = dto.userName;
        repository.save(newUser);
        return "redirect:/user?message=User+created";
    }

    @RequestMapping(value = "/user/edit/{userName}", method = RequestMethod.GET)
    public String editUser(@PathVariable(name = "userName") String userName, Model model, HttpServletResponse response) {
        ApplicationUser user = repository.findOne(userName);
        if (user == null) {
            response.setStatus(HttpServletResponse.SC_NOT_FOUND);
        }
        PasswordModel passwordModel = new PasswordModel();
        passwordModel.userName = user.userName;
        model.addAttribute("passwordModel", passwordModel);

        return "user/edit";
    }

    @PostMapping("/user/edit")
    public String editUser(@ModelAttribute PasswordModel pwmd, HttpServletResponse response, Model model) {
        ApplicationUser user = repository.findOne(pwmd.userName);
        if (user == null) {
            response.setStatus(HttpServletResponse.SC_NOT_FOUND);
            return "redirect:/user";
        }
        if (!encoder.matches(pwmd.oldPassword, user.password)) {
            model.addAttribute("error", "Wrong old password!");
            return "user/edit";
        }
        if (!Objects.equals(pwmd.newPassword, pwmd.retypePassword)) {
            model.addAttribute("error", "Password not match");
            return "user/edit";
        }

        user.password = encoder.encode(pwmd.newPassword);
        repository.save(user);
        return "redirect:/user?message=Password+changed";

    }

    @RequestMapping(value = "/user/delete/{userName}", method = RequestMethod.GET)
    public String deleteUser(@PathVariable(name = "userName") String userName, Model model, HttpServletResponse response) {
        ApplicationUser user = repository.findOne(userName);
//        Iterable<ApplicationUser> allUserEnabled = repository.findAllUserEnabled();
        if (user == null) {
            response.setStatus(HttpServletResponse.SC_NOT_FOUND);
        }
        DeleteUserModel dmodel = new DeleteUserModel();
        dmodel.setUserName(userName);
        model.addAttribute("model", dmodel);
        return "user/delete";
    }

    @PostMapping("/user/delete")
    public String deleteUserConfirm(@ModelAttribute DeleteUserModel model, HttpServletResponse response) {
        ApplicationUser user = repository.findOne(model.getUserName());
        if (user == null) {
            response.setStatus(HttpServletResponse.SC_NOT_FOUND);
        }
        repository.delete(user);
        return "redirect:/user?message=User+deleted";
    }

}
