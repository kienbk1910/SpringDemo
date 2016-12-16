package gst.fsoft.com.vn.model;




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
    public String userName;
    public String password;
    public boolean enabled;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "user", cascade = CascadeType.ALL)
    public Collection<UserRole> roles;
}
