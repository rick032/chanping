/**
 * 
 */
package tw.com.chingping;

import java.nio.charset.Charset;

import com.hexiong.jdbf.DBFReader;

/**
 * @author Rick032
 * 
 */
public class Chingping {

	/**
	 * @param args
	 */
	public static void main(String args[]) throws Exception {
		// DBFReader dbfreader = new DBFReader((new
		// URL("http://www.svcon.com/us48st.dbf")).openStream());
		// DBFReader dbfreader = new DBFReader("F:\\work\\book2.dbf");
		DBFReader dbfreader = new DBFReader("F:\\WorkArea\\others\\Chingping\\DATA\\goods.dbf");
		// DBFReader dbfreader = new DBFReader("E:\\hexiongshare\\test.dbf");
		int i;
		for (i = 0; i < dbfreader.getFieldCount(); i++) {
			System.out.print(dbfreader.getField(i).getName() + "  ");
		}
		System.out.print("\n");
		for (i = 0; dbfreader.hasNextRecord(); i++) {
			Object aobj[] = dbfreader.nextRecord(Charset.forName("CP950"));
			for (int j = 0; j < aobj.length; j++)
				System.out.print(aobj[j] + "  |  ");
			System.out.print("\n");
		}

		System.out.println("Total Count: " + i);
	}

}
