package nl.IPRWC_backend.git.resources;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.sql.SQLException;

@Path("/product")
public class ProductResource {

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public int checkNumber(){
        System.out.println("OKKKKKKKKKKKKKKKKKK");
        int answer = 5;
        return answer;
    }

}
