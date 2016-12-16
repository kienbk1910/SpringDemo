package gst.fsoft.com.vn.model;




import com.google.gson.annotations.Expose;

import javax.persistence.*;

import java.io.Serializable;
import java.util.Collection;


/**
 * Created by chikien276 on 21/10/2016.
 */
@Entity
public class ApplicationUser implements Serializable {
    public ApplicationUser() {
    }

    @Id
    @Expose
    public String userName;

    public String password;

    @Expose
    public boolean enabled;

    @Expose
    @OneToMany(fetch = FetchType.EAGER, mappedBy = "user", cascade = CascadeType.ALL)
    public Collection<UserRole> roles;
}
