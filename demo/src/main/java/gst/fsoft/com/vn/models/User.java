package gst.fsoft.com.vn.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

/**
 * @author Kienpd2
 *
 */
@Entity
@Table(name = "users")
public class User {
	 @Id
	 @GeneratedValue(strategy = GenerationType.AUTO)
	 private Integer id;
	 @NotNull
	 private String user;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getUser() {
		return user;
	}
	public void setUser(String user) {
		this.user = user;
	}
	public User(String user) {
		this.user = user;
	}
	public User() {
		// TODO Auto-generated constructor stub
	}
	
	 
}
