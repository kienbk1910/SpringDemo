package gst.fsoft.com.vn.model;

import sun.net.ftp.FtpDirEntry;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
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

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "user")
    public Collection<UserRole> roles;
}
