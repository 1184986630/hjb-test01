package util;

import java.io.FileOutputStream;
import java.io.OutputStream;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import net.sf.json.JSONObject;
import jxl.Workbook;
import jxl.write.WritableFont;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;

public class ExcelTest {
	/**
	 * @param args
	 */
	public void exportExcel(String targetfile, String worksheet,
			String[] title, Map<Integer, JSONObject> map, List<String> list2) {

		// String targetfile = "c:/out.xls";// �����excel�ļ���
		// String worksheet = "List";// �����excel�ļ���������
		// String[] title = { "Id", "NAME", "DESCRIB" };// excel������ı���

		WritableWorkbook workbook;
		try {
			OutputStream os = new FileOutputStream(targetfile);
			workbook = Workbook.createWorkbook(os);
			WritableSheet sheet = workbook.createSheet(worksheet, 0); // ��ӵ�һ��������

			jxl.write.Label label;
			for (int i = 0; i < title.length; i++) {
				// Label(�к�,�к� ,���� )
				label = new jxl.write.Label(i, 0, title[i]); // put the title in
				sheet.addCell(label);
			}

			JSONObject jo = new JSONObject();
			if (map.size() > 0) {
				int r = 0;
				int c = 0;
				
				for (int b = 0; b < map.size(); b++) {
					r = 0;
					c++;
					jo = map.get(b);
					int n = 0;	
					for (Iterator iter = jo.keys(); iter.hasNext();) { // �ȱ�������
						String key = (String) iter.next();

						String value = jo.getString(list2.get(n));
						n++;
						jxl.write.Label labelCF = new jxl.write.Label(r++, c,
								value);
						sheet.addCell(labelCF);
					}
				}
			}
			workbook.write();
			workbook.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
