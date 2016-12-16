package gst.fsoft.com.vn;

import gst.fsoft.com.vn.dao.UserRepository;
import gst.fsoft.com.vn.model.ApplicationUser;
import gst.fsoft.com.vn.model.UserRole;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;

@RunWith(SpringRunner.class)
@SpringBootTest
public class Demo2ApplicationTests {

    @Test
    public void contextLoads() {
    }

    @Autowired
    UserRepository repository;

    @Autowired
    private PasswordEncoder encoder;

    @Test
    public void testCascadeUpdate() {

        ApplicationUser user = new ApplicationUser();
        user.userName = "testUserName";
        user.password = encoder.encode("rawPassword");
        user.enabled = true;
        user.roles = new ArrayList<>();
        UserRole uploadRole = new UserRole();
        uploadRole.role = "upload";
        uploadRole.user = user;

        UserRole downloadRole = new UserRole();
        downloadRole.role = "download";
        downloadRole.user = user;

        user.roles.add(uploadRole);
        user.roles.add(downloadRole);

        repository.save(user);
        Assert.assertEquals(repository.findOne(user.userName).roles.size(), 2);
        //clean up
        repository.delete("testUserName");
    }

}
