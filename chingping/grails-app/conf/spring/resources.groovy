import tw.com.chanping.DbfDatasource;

// Place your Spring DSL code here
beans = {
	dataSource(DbfDatasource) {
		//url = "jdbc:odbc:CHANPING"
		url = "jdbc:odbc:Driver={Microsoft Visual FoxPro Driver};SourceType=DBF;SourceDB=F:/WorkArea/others/Chingping/DATA2;Exclusive=No;";
		driverClassName = "sun.jdbc.odbc.JdbcOdbcDriver"
		charSet = "big5"
	}
}
