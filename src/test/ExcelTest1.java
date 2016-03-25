package test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

import java.util.Map;

import net.sf.json.JSON;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import test.entity.Student;
import util.ExcelTest;

public class ExcelTest1 {
	public static void main(String[] args) {
		ExcelTest et = new ExcelTest();
		String targetfile = "c:/test4.xls";

		String worksheet = "test";

		String[] title = { "姓名", "年龄", "性别" };

		Student t = new Student();
		t.setName("黄佳博");
		t.setAge(8);
		t.setSex("男");
		Student t2 = new Student();
		t2.setName("李进");
		t2.setAge(1);
		t2.setSex("女");

		List<Student> list = new ArrayList<Student>();
		list.add(t);
		list.add(t2);

		List<String> list2 = new ArrayList<String>();
		list2.add("name");
		list2.add("age");
		list2.add("sex");

		// 把数据放入map
		Map<Integer, JSONObject> map = new HashMap<Integer, JSONObject>();
		JSONArray jsonArray = new JSONArray();
		if (list.size() > 0) {
			for (int i = 0; i < list.size(); i++) {
				jsonArray = JSONArray.fromObject(list.get(i));
				map.put(i, JSONObject.fromObject(jsonArray.get(0)));
			}
		}
		// 遍历map
		/*
		 * JSONObject jo = new JSONObject(); if(map.size()>0){ for(int b =
		 * 0;b<map.size();b++){ jo = map.get(b); for (Iterator iter = jo.keys();
		 * iter.hasNext();) { //先遍历整个 people 对象 String key =
		 * (String)iter.next(); System.out.println(jo.getString(key)); } } }
		 */

		et.exportExcel(targetfile, worksheet, title, map, list2);
	}
}
