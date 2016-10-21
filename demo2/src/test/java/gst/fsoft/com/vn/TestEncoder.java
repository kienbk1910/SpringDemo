package gst.fsoft.com.vn;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

/**
 * Created by chikien276 on 21/10/2016.
 */
public class TestEncoder {
    public static void main(String[] args) {
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        System.out.println(encoder.encode("admin"));
    }
}
