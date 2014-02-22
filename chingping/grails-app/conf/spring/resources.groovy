import tw.com.chanping.DbfDatasource;

// Place your Spring DSL code here
beans = {
	dataSource(DbfDatasource) {
		url = "jdbc:odbc:chanping"
		driverClassName = "sun.jdbc.odbc.JdbcOdbcDriver"
		charSet = "big5"
	}
}
