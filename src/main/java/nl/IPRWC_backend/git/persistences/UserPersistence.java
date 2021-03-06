package nl.IPRWC_backend.git.persistences;

import nl.IPRWC_backend.git.models.UserModel;
import nl.IPRWC_backend.git.mappers.UserMapper;
import org.skife.jdbi.v2.sqlobject.Bind;
import org.skife.jdbi.v2.sqlobject.SqlQuery;
import org.skife.jdbi.v2.sqlobject.customizers.RegisterMapper;

/**
 * Here the query is executed to see if the user exists in the database
 *
 * @author Ali Rezaa Ghariebiyan
 * @version 08-11-2019
 */

@RegisterMapper(UserMapper.class)
public interface UserPersistence {
    @SqlQuery("SELECT * FROM df_user WHERE username = :username ")
    UserModel getUserByUsername(@Bind("username") String username);

    void close();
}
