package tw.com.chanping;

import org.apache.commons.dbcp.BasicDataSource;

public class DbfDatasource extends BasicDataSource {
	private String charSet;

	public String getCharSet() {
		return charSet;
	}

	public void setCharSet(String charSet) {
		this.charSet = charSet;
		this.addConnectionProperty("charSet", charSet);
	}
}
