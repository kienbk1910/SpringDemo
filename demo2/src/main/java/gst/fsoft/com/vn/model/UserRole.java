package gst.fsoft.com.vn.model;

import com.google.gson.annotations.Expose;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by chikien276 on 21/10/2016.
 */
@Entity
public class UserRole implements Serializable {
    public UserRole() {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Expose
    public Long id;

    @Expose
    public String role;

    @ManyToOne()
    @JoinColumn(name = "user_name")
    public ApplicationUser user;

}
