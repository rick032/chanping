import grails.util.Environment;
import tw.com.chanping.DbfDatasource;

// Place your Spring DSL code here
beans = {
	dataSource(DbfDatasource) {
		//url = "jdbc:odbc:CHANPING"
		url = Environment.PRODUCTION==Environment.current?"jdbc:odbc:Driver={Microsoft Visual FoxPro Driver};SourceType=DBF;SourceDB=D:/dpsys/dperp_st/DATA;Exclusive=No;":"jdbc:odbc:CHANPING";
		driverClassName = "sun.jdbc.odbc.JdbcOdbcDriver"
		charSet = "big5"
	}
}
