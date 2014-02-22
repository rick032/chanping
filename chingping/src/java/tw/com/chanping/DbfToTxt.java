/**
 * 
 */
package tw.com.chanping;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.Charset;

import com.hexiong.jdbf.DBFReader;
import com.hexiong.jdbf.JDBField;

/**
 * @author Rick032
 * 
 */
public class DbfToTxt {
	String filePath = "F:\\WorkArea\\others\\Chingping\\DATA\\";
	String dbName = "ctm";
	String SIGN = "|";

	/**
	 * @param args
	 */
	public static void main(String args[]) {
		// DBFReader dbfreader = new DBFReader((new
		// URL("http://www.svcon.com/us48st.dbf")).openStream());
		// DBFReader dbfreader = new DBFReader("F:\\work\\book2.dbf");

		// DBFReader dbfreader = new DBFReader("E:\\hexiongshare\\test.dbf");

		try {
			DbfToTxt dbf = new DbfToTxt();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public DbfToTxt() throws Exception {
		DBFReader dbfreader = new DBFReader(filePath + dbName + ".dbf");
		StringBuffer sb = new StringBuffer();
		int i;
		for (i = 0; i < dbfreader.getFieldCount(); i++) {
			JDBField field = dbfreader.getField(i);
			sb.append(field.getName().toLowerCase()).append(",").append(field.getType())
					.append(",").append(field.getLength()).append(",")
					.append(field.getDecimalCount()).append(SIGN);
		}
		sb.append("\n");

		for (i = 0; dbfreader.hasNextRecord(); i++) {
			Object aobj[] = dbfreader.nextRecord(Charset.forName("CP950"));
			for (int j = 0; j < aobj.length; j++)
				sb.append(aobj[j]).append(SIGN);
			sb.append("\n");
		}
		writeFile(sb.toString());
		System.out.println("Total Count: " + i);
	}

	private void writeFile(String content) {
		try {

			File file = new File(filePath + dbName + ".txt");

			// if file doesnt exists, then create it
			if (!file.exists()) {
				file.createNewFile();
			}

			FileWriter fw = new FileWriter(file.getAbsoluteFile());
			BufferedWriter bw = new BufferedWriter(fw);
			bw.write(content);
			bw.close();

			System.out.println("Done");

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
