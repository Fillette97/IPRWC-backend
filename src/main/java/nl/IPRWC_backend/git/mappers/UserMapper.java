package nl.IPRWC_backend.git.mappers;

import nl.IPRWC_backend.git.models.UserModel;
import org.skife.jdbi.v2.StatementContext;
import org.skife.jdbi.v2.tweak.ResultSetMapper;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * With the mapper the resultset of the database can be converted into an object
 *
 * @author Ali Rezaa Ghariebiyan
 * @version 08-11-2019
 */

public class UserMapper implements ResultSetMapper<UserModel> {

    @Override
    public UserModel map(int i, ResultSet r, StatementContext statementContext) throws SQLException {
        return new UserModel(
                r.getInt("user_id"),
                r.getString("username"),
                r.getString("password")
        );
    }
}
