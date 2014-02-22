package tw.com.chanping;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Types;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;

public class DBF4Odbc {
	DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");

	public DBF4Odbc() {
		Connection connection = null;
		Statement statement = null;
		ResultSet resultSet = null;
		String tableName = "ctm";
		try {
			Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");

			String connString = "jdbc:odbc:CHANPING";
			
			Properties prop = new java.util.Properties();
			prop.put("charSet", "Big5");
			connection = DriverManager.getConnection(connString, prop);
			Statement stmt = connection.createStatement();
			resultSet = stmt.executeQuery("SELECT * FROM " + tableName +" where ctmno='A-001'");
			ResultSetMetaData rsmd = resultSet.getMetaData();

			while (resultSet.next()) {

				for (int i = 1; i <= rsmd.getColumnCount(); i++) {
					String columnName = rsmd.getColumnName(i);
					System.out.print(resultSet.getString(columnName)+" ");					
				}
				System.out.println();

			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if (resultSet != null)
				try {
					resultSet.close();
				} catch (SQLException logOrIgnore) {
				}
			if (statement != null)
				try {
					statement.close();
				} catch (SQLException logOrIgnore) {
				}
			if (connection != null)
				try {
					connection.close();
				} catch (SQLException logOrIgnore) {
				}
		}

	}

	public void getDBF() {
	}

	public static void main(String[] args) {
		DBF4Odbc d = new DBF4Odbc();
	}

	/*
	 * public List<DomainBase> list(String tableName) throws SQLException {
	 * Connection connection = null; Statement statement = null; ResultSet
	 * resultSet = null; List<DomainBase> list = new ArrayList<DomainBase>();
	 * 
	 * try { Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
	 * 
	 * String connString = "jdbc:odbc:CHINGPING"; Properties prop = new
	 * java.util.Properties(); prop.put("charSet", "Big5"); connection =
	 * DriverManager.getConnection(connString, prop); Statement stmt =
	 * connection.createStatement(); resultSet =
	 * stmt.executeQuery("SELECT * FROM " + tableName); ResultSetMetaData rsmd =
	 * resultSet.getMetaData(); Class<?> cls =
	 * Class.forName("tw.com.chingping.domain." + tableName.substring(0,
	 * 1).toUpperCase() + tableName.substring(1)); while (resultSet.next()) {
	 * Object obj = cls.newInstance(); for (int i = 1; i <=
	 * rsmd.getColumnCount(); i++) { String columnName = rsmd.getColumnName(i);
	 * int type = rsmd.getColumnType(i); // System.out.println(columnName + ","
	 * + type + "," // + rsmd.getPrecision(i) + "," + rsmd.getScale(i)); Method
	 * method = cls.getDeclaredMethod("set" + columnName.substring(0,
	 * 1).toUpperCase() + columnName.substring(1), getType(type)); Object o =
	 * getValue(type, resultSet, columnName); if (o == null) { continue; }
	 * method.invoke(obj, o); } list.add((DomainBase) obj); if (list.size() >
	 * 1000) { break; } } } catch (ClassNotFoundException e) { // TODO
	 * Auto-generated catch block e.printStackTrace(); } catch
	 * (IllegalAccessException e) { // TODO Auto-generated catch block
	 * e.printStackTrace(); } catch (IllegalArgumentException e) { // TODO
	 * Auto-generated catch block e.printStackTrace(); } catch
	 * (InvocationTargetException e) { // TODO Auto-generated catch block
	 * e.printStackTrace(); } catch (NoSuchMethodException e) { // TODO
	 * Auto-generated catch block e.printStackTrace(); } catch
	 * (SecurityException e) { // TODO Auto-generated catch block
	 * e.printStackTrace(); } catch (InstantiationException e) { // TODO
	 * Auto-generated catch block e.printStackTrace(); } finally { if (resultSet
	 * != null) try { resultSet.close(); } catch (SQLException logOrIgnore) { }
	 * if (statement != null) try { statement.close(); } catch (SQLException
	 * logOrIgnore) { } if (connection != null) try { connection.close(); }
	 * catch (SQLException logOrIgnore) { } } return list; }
	 * 
	 * Class<?>[] getType(int type) { switch (type) { case Types.DECIMAL: case
	 * Types.NUMERIC: case Types.INTEGER: return new Class[] { BigDecimal.class
	 * }; case Types.DATE: case Types.TIMESTAMP: return new Class[] { Date.class
	 * }; default: return new Class[] { String.class }; } }
	 */

	Object getValue(int type, ResultSet resultSet, String columnName)
			throws SQLException {
		switch (type) {
		case Types.DECIMAL:
		case Types.NUMERIC:
		case Types.INTEGER:
			return resultSet.getBigDecimal(columnName);
		case Types.DATE:
			Object str_date = trimObject(resultSet.getString(columnName));
			if (str_date == null || "1899-12-30".equals(str_date)) {
				return null;
			}
			Date date = null;
			try {
				date = (Date) formatter.parse((String) str_date);
			} catch (ParseException e) {
				e.printStackTrace();
			}
			return date;
		case Types.TIMESTAMP:
			return resultSet.getTimestamp(columnName);
		default:
			return trimObject(resultSet.getString(columnName));
		}
	}

	Object trimObject(Object o) {
		if (o != null && o instanceof String) {
			o = ((String) o).trim();
			return "".equals(o) ? null : o;
		}
		return o;
	}
}
