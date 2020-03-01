package nl.IPRWC_backend.git.util;

import java.sql.SQLException;
import org.postgresql.ds.PGSimpleDataSource;
import org.skife.jdbi.v2.DBI;

/**
 * @author Oussama Fahchouch
 */
public class DbConnector {
	private final static String url = "packy.db.elephantsql.com";
	private final static int port = 5432;
	private final static String dbName = "tqpudede";
	private final static String username = "tqpudede";
	private final static String password = "CiRAVJqVMu13dczAEbnImOSKIJ3h6Y4L";
	private static DbConnector singleInstance = null;
	private static PGSimpleDataSource source = null;

	/**
	 * @author Oussama Fahchouch
	 * @return DbConnector singleInstance
	 */
    public static DbConnector getInstance() 
    { 
        if (singleInstance == null) {
        	singleInstance = new DbConnector();
        	source = new PGSimpleDataSource();
        	source.setServerName(url);
    		source.setPortNumber(port);
            source.setDatabaseName(dbName);
            source.setUser(username);
            source.setPassword(password);
        }

        return singleInstance; 
    }

    /**
     * @author Oussama Fahchouch
     * @return DBI
     * @throws SQLException 
     */
	public static DBI getDBI() throws SQLException {
		return new DBI(source);
	}
}
