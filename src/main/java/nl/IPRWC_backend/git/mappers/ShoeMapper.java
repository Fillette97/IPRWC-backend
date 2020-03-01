package nl.IPRWC_backend.git.mappers;

import nl.IPRWC_backend.git.models.ShoeModel;
import org.skife.jdbi.v2.StatementContext;
import org.skife.jdbi.v2.tweak.ResultSetMapper;

import java.sql.ResultSet;
import java.sql.SQLException;


import org.skife.jdbi.v2.StatementContext;
import org.skife.jdbi.v2.tweak.ResultSetMapper;

public class ShoeMapper implements ResultSetMapper<ShoeModel> {

    @Override
    public ShoeModel map(int index, ResultSet r, StatementContext ctx) throws SQLException {
        System.out.println("ökkk");
        System.out.println(r);
        return new ShoeModel(
                r.getInt("shoeId"),
                r.getDouble("price"),
                r.getString("name"),
                r.getInt("size"),
                r.getString("description"),
                r.getString("imageUrl"),
                r.getInt("stock")
        );
    }
}
