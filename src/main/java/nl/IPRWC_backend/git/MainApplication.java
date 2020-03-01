package nl.IPRWC_backend.git;

import java.io.UnsupportedEncodingException;
import java.security.Principal;
import java.sql.SQLException;
import java.util.EnumSet;

import javax.servlet.DispatcherType;
import javax.servlet.FilterRegistration;

import io.dropwizard.auth.AuthenticationException;
import nl.IPRWC_backend.git.resources.ShoeResource;

import org.eclipse.jetty.servlets.CrossOriginFilter;
import org.glassfish.jersey.server.filter.RolesAllowedDynamicFeature;

import io.dropwizard.Application;
import io.dropwizard.auth.AuthDynamicFeature;
import io.dropwizard.auth.AuthValueFactoryProvider;
import io.dropwizard.auth.oauth.OAuthCredentialAuthFilter;
import io.dropwizard.db.DataSourceFactory;
import io.dropwizard.migrations.MigrationsBundle;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;
import nl.IPRWC_backend.git.models.UserModel;
import nl.IPRWC_backend.git.resources.AuthResource;
import nl.IPRWC_backend.git.services.AuthenticationService;


public class MainApplication extends Application<MainConfiguration> {


    public static void main(String[] args) throws Exception {
         new MainApplication().run(new String[] {"server", "config.yml"});
    }

    @Override
    public String getName() {
        return "digitaleFactuurBackEnd";
    }
    

    @Override
    public void initialize(final Bootstrap<MainConfiguration> bootstrap) {
    	bootstrap.addBundle(new MigrationsBundle<MainConfiguration>() {
            @Override
                public DataSourceFactory getDataSourceFactory(MainConfiguration configuration) {
                    return configuration.getDataSourceFactory();
                }
        });
    }

    @Override
    public void run(MainConfiguration configuration, Environment environment) throws UnsupportedEncodingException, SQLException, AuthenticationException {
    	final FilterRegistration.Dynamic cors = environment.servlets().addFilter("CORS", CrossOriginFilter.class);

	    // Configure CORS parameters
	    cors.setInitParameter("allowedOrigins", "*");
	    cors.setInitParameter("allowedHeaders", "*");
	    cors.setInitParameter("allowedMethods", "OPTIONS,GET,PUT,POST,DELETE,HEAD");

	    // Add URL mapping
	    cors.addMappingForUrlPatterns(EnumSet.allOf(DispatcherType.class), true, "/*");
	    

        final AuthResource authResource = new AuthResource();
        final ShoeResource s1 = new ShoeResource();
        s1.getAllShoess();



        environment.jersey().register(new AuthValueFactoryProvider.Binder<>(Principal.class));
        environment.jersey().register(RolesAllowedDynamicFeature.class);

	    environment.jersey().register(authResource);
        environment.jersey().register(s1);
	    
	    //toevoegen van de OAuth2 authenticator
	    environment.jersey().register(new AuthDynamicFeature(
	    		new OAuthCredentialAuthFilter.Builder<UserModel>()
	    		.setAuthenticator(new AuthenticationService())
	    		.buildAuthFilter()
		));


    }

}
