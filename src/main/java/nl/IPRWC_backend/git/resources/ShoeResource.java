package nl.IPRWC_backend.git.resources;

import io.dropwizard.auth.AuthenticationException;
import nl.IPRWC_backend.git.models.ShoeModel;
import nl.IPRWC_backend.git.services.ShoeService;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.sql.SQLException;
import java.util.List;

@Path("/shoes")
public class ShoeResource {

    private ShoeService shoeService;

    public ShoeResource() throws SQLException {
        this.shoeService = new ShoeService();
    }

    /**
     * @throws AuthenticationException
     */
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public List<ShoeModel> getAllShoes(@HeaderParam("Token") String TokenHeaderParam) throws SQLException, AuthenticationException {
        System.out.println("TESSTTT shoes");
        return shoeService.fetchAllShoes(TokenHeaderParam);
    }

    /**s
     * @throws AuthenticationException
     */
    @Path("/test")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public List<ShoeModel> getAllShoess() throws SQLException{
        System.out.println("TESSTTT shoes");
        return shoeService.fetchAllShoess();
    }

    /**
     * @throws AuthenticationException
     */
    @Path("/shoe/add")
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public boolean postTripByUser(ShoeModel shoe, @HeaderParam("Token") String TokenHeaderParam) throws SQLException, AuthenticationException {

        shoeService.addShoe(shoe, TokenHeaderParam);

        return true;
    }



    }
