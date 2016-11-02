package gst.fsoft.com.vn.dao;

import gst.fsoft.com.vn.model.ApplicationUser;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

/**
 * Created by chikien276 on 21/10/2016.
 */
public interface UserRepository extends PagingAndSortingRepository<ApplicationUser, String> {

    @Query(value = "select * from application_user  where enabled= TRUE", nativeQuery = true)
    Iterable<ApplicationUser> findAllUserEnabled();

    Iterable<ApplicationUser> findByEnabled(boolean enabled);

}
