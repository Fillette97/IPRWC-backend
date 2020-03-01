package nl.IPRWC_backend.git.persistences;

import nl.IPRWC_backend.git.mappers.ShoeMapper;
import nl.IPRWC_backend.git.models.ShoeModel;
import nl.IPRWC_backend.git.models.UserModel;
import org.skife.jdbi.v2.sqlobject.Bind;
import org.skife.jdbi.v2.sqlobject.SqlQuery;
import org.skife.jdbi.v2.sqlobject.SqlUpdate;
import org.skife.jdbi.v2.sqlobject.customizers.RegisterMapper;

import java.util.List;

@RegisterMapper(ShoeMapper.class)
    public interface ShoePersistence {

        //fetches all the shoes
        @SqlQuery("SELECT * FROM shoes")
        List<ShoeModel> findAllShoes();

    /**
     * @author Oussama Fahchouch
     */
    @SqlUpdate("INSERT INTO shoes (shoeid, name, description, price, stock, imageurl)\n" + "VALUES (:shoeId, :name, :description, :price, :stock, :imageUrl);")
    void createShoe(
                    @Bind("shoeId") int shoeId, @Bind("name") String name,
                    @Bind("description") String description, @Bind("price") double price,
                    @Bind("stock") int stock, @Bind("imageUrl") String imageUrl);
    void close();
    }
