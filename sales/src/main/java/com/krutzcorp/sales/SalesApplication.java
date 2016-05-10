package com.krutzcorp.sales;

import com.hubspot.dropwizard.guice.GuiceBundle;
import com.hubspot.rosetta.jdbi.RosettaMapperFactory;
import io.dropwizard.Application;
import io.dropwizard.jdbi.DBIFactory;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;
import org.skife.jdbi.v2.DBI;
import com.krutzcorp.sales.resources.*;

/**
 * Dropwizard boilerplate
 * The webservice will start on port 8080.
 */
public class SalesApplication extends Application<SalesConfiguration> {

    private GuiceBundle guiceBundle;
    private SalesModule salesModule;

    public static void main(String[] args) throws Exception {
        new SalesApplication().run(args);
    }

    // Set up the module and get ready for injection with guice.
    @Override
    public void initialize(Bootstrap<SalesConfiguration> bootstrap) {
        salesModule = new SalesModule();
        guiceBundle = GuiceBundle.<SalesConfiguration>newBuilder()
                .addModule(salesModule)
                .setConfigClass(SalesConfiguration.class)
                .build();

        bootstrap.addBundle(guiceBundle);
    }

    // The run method needs to set up the database connection and register the resources.
    @Override
    public void run(SalesConfiguration salesConfiguration, Environment environment) throws Exception {
        final DBIFactory factory = new DBIFactory();
        final DBI jdbi = factory.build(environment, salesConfiguration.getDatabase(), "mysql");
        jdbi.registerMapper(new RosettaMapperFactory());

        salesModule.setJdbi(jdbi);

        registerResources(environment, CSResource.class, SalesResource.class);

    }

    // Just an easy way to register all the resources without having to write
    // the same super-long line of code.
    private void registerResources(Environment environment, Class... resourceClasses) {
        for (Class resourceClass : resourceClasses) {
            // Grabs an instance of the resource class from the guice bundle
            // and registers it.
            environment.jersey().register(guiceBundle.getInjector().getInstance(resourceClass));
        }
    }
}