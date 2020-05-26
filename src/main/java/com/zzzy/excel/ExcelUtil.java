package com.zzzy.excel;



import java.io.File;
import java.util.HashMap;
import java.util.List;
import jxl.Workbook;
import jxl.write.Label;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;

public class ExcelUtil {
	/**
	 * ����excel
	 * @param list
	 * @param path
	 * @throws Exception
	 * @throws Exception
	 */
	public static void exporData(List<HashMap<String,Object>> list,String path) throws Exception{
		Label label = null;
		Label labelNext = null;
		String[] title ={"ID","�˺�","����"};
		File file = new  File(path);

		WritableWorkbook wb = Workbook.createWorkbook(file);
		//����������
		WritableSheet sheet = wb.createSheet("�콨��", 0);

		//������ͷ
		for(int i =0;i<title.length;i++){
			label = new Label(i,0,title[i]);
			sheet.addCell(label);
		}

		HashMap<String, Object> map =null;
		//׷������
		for(int i=0;i<list.size();i++){

			map=list.get(i);

			labelNext = new Label(0,i+1,String.valueOf(map.get("id")));
			sheet.addCell(labelNext);

			labelNext = new Label(1,i+1,String.valueOf(map.get("username")));
			sheet.addCell(labelNext);

			labelNext = new Label(2,i+1,String.valueOf(map.get("password")));
			sheet.addCell(labelNext);	
		}
		wb.write();
		wb.close();
	}
}