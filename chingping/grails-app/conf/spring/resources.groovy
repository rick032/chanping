import tw.com.chanping.DbfDatasource;

// Place your Spring DSL code here
beans = {
	dataSource(DbfDatasource) {
		url = "jdbc:odbc:CHANPING"
		driverClassName = "sun.jdbc.odbc.JdbcOdbcDriver"
		charSet = "big5"
	}
}
