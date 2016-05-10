package com.krutzcorp.sales;

import com.google.inject.Binder;
import com.google.inject.Module;
import org.skife.jdbi.v2.DBI;

//DB configuration (if set up)
public class SalesModule implements Module {
	private DBI jdbi;

	public void configure(Binder binder) {}

    public void setJdbi(DBI jdbi) {
        this.jdbi = jdbi;
    }
}