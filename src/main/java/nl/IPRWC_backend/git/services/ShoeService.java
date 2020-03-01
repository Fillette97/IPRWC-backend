package nl.IPRWC_backend.git.services;

import io.dropwizard.auth.AuthenticationException;
import nl.IPRWC_backend.git.models.ShoeModel;
import nl.IPRWC_backend.git.persistences.ShoePersistence;
import nl.IPRWC_backend.git.util.DbConnector;
import org.skife.jdbi.v2.DBI;

import java.sql.SQLException;
import java.util.List;

public class ShoeService {
    private DBI dbi;
    private ShoePersistence shoeDAO;
    private AuthenticationService authenticationService;

    /**
     * @author Oussama Fahchouch
     * @throws SQLException
     */
    public ShoeService() throws SQLException {
        DbConnector.getInstance();
        dbi = DbConnector.getDBI();
        this.authenticationService = new AuthenticationService();
    }

    /**
     * @throws SQLException
     * @return List<ShoeModel> fetchedShoes
     * @throws AuthenticationException
     */
    public List<ShoeModel> fetchAllShoes(String tokenHeaderParam) throws SQLException, AuthenticationException {
        if (this.authenticationService.authenticate(tokenHeaderParam).isPresent()) {
            shoeDAO = dbi.open(ShoePersistence.class);
            List<ShoeModel> fetchedShoes = shoeDAO.findAllShoes();
            shoeDAO.close();

            return fetchedShoes;
        } else {
            return null;
        }
    }

    /**
     * @throws SQLException
     * @return List<ShoeModel> fetchedShoes

     */
    public List<ShoeModel> fetchAllShoess() throws SQLException{

            shoeDAO = dbi.open(ShoePersistence.class);
            List<ShoeModel> fetchedShoes = shoeDAO.findAllShoes();
            shoeDAO.close();

            return fetchedShoes;

        }



    /**
     * @throws SQLException
     * @throws AuthenticationException
     */
    public boolean addShoe(ShoeModel shoe, String tokenHeaderParam) throws SQLException, AuthenticationException {
        if (this.authenticationService.authenticate(tokenHeaderParam).isPresent()) {
            shoeDAO = dbi.open(ShoePersistence.class);
            shoeDAO.createShoe(shoe.getShoeId(),shoe.getName(),shoe.getDescription(),shoe.getPrice(),shoe.getStock(),shoe.getImageUrl());
            shoeDAO.close();

            return true;
        } else {
            return false;
        }
    }
}
