package gst.fsoft.com.vn.dto;

/**
 * Created by chikien276 on 22/10/2016.
 */
public class CreateUser {
    public CreateUser() {
    }

    public String userName;
    public String password;
    public String retypePassword;


    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRetypePassword() {
        return retypePassword;
    }

    public void setRetypePassword(String retypePassword) {
        this.retypePassword = retypePassword;
    }
}
