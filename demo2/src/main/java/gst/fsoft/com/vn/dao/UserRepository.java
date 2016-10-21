package gst.fsoft.com.vn.dao;

import gst.fsoft.com.vn.model.ApplicationUser;
import org.springframework.data.repository.PagingAndSortingRepository;

/**
 * Created by chikien276 on 21/10/2016.
 */
public interface UserRepository extends PagingAndSortingRepository<ApplicationUser, String> {

}
