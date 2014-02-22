package tw.com.chanping;

import java.sql.Types;

import org.hibernate.cfg.Environment;
import org.hibernate.dialect.Dialect;

public class FoxProDialect extends Dialect {
	public FoxProDialect() {
		super();
		registerColumnType(Types.BIT, "B");
		registerColumnType(Types.BIGINT, "I");
		registerColumnType(Types.SMALLINT, "I");
		registerColumnType(Types.TINYINT, "I");
		registerColumnType(Types.INTEGER, "I");
		registerColumnType(Types.CHAR, "V(1)");
		registerColumnType(Types.VARCHAR, "V($l)");
		registerColumnType(Types.FLOAT, "B");
		registerColumnType(Types.DOUBLE, "B");
		registerColumnType(Types.DATE, "D");
		registerColumnType(Types.TIME, "T");
		registerColumnType(Types.TIMESTAMP, "D");
		registerColumnType(Types.VARBINARY, "Q($l)");		
		registerColumnType(Types.DECIMAL, "N(19,5)");
		registerColumnType(Types.NUMERIC, "I");		

		getDefaultProperties().setProperty(Environment.STATEMENT_BATCH_SIZE,
				"0");
		getDefaultProperties().setProperty("charSet",
				"Big5");
	}

	public String getIdentityColumnString() {
		// return " counter ";
		return "not null auto_number";
	}

	public String getIdentitySelectString() {
		return "select @@IDENTITY";
	}

}
