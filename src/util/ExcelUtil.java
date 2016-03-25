package util;

import jxl.*;
import jxl.write.*;
import java.io.*;
import java.io.File.*;
import java.util.*;

public class ExcelUtil {
    public static void main(String[] args) {

        String targetfile = "c:/out.xls";// 输出的excel文件名
        String worksheet = "List";// 输出的excel文件工作表名
        String[] title = { "Id", "NAME", "DESCRIB" };// excel工作表的标题

        WritableWorkbook workbook;
        try {
            // 创建可写入的Excel工作薄,运行生成的文件在tomcat/bin下
            // workbook = Workbook.createWorkbook(new File("output.xls"));
            System.out.println("begin");

            OutputStream os = new FileOutputStream(targetfile);
            workbook = Workbook.createWorkbook(os);

            WritableSheet sheet = workbook.createSheet(worksheet, 0); // 添加第一个工作表
            // WritableSheet sheet1 = workbook.createSheet("MySheet1", 1);
            // //可添加第二个工作
            /*
             * jxl.write.Label label = new jxl.write.Label(0, 2,
             * "A label record"); //put a label in cell A3, Label(column,row)
             * sheet.addCell(label);
             */

            jxl.write.Label label;
            for (int i = 0; i < title.length; i++) {
                // Label(列号,行号 ,内容 )
                label = new jxl.write.Label(i, 0, title[i]); // put the title in
                                                                // row1
                sheet.addCell(label);
            }

            // 下列添加的对字体等的设置均调试通过，可作参考用

            // 添加数字
            jxl.write.Number number = new jxl.write.Number(3, 4, 3.14159); // put
                                                                            // the
                                                                            // number
                                                                            // 3.14159
                                                                            // in
                                                                            // cell
                                                                            // D5
            sheet.addCell(number);

            // 添加带有字型Formatting的对象
            jxl.write.WritableFont wf = new jxl.write.WritableFont(
                    WritableFont.TIMES, 10, WritableFont.BOLD, true);
            jxl.write.WritableCellFormat wcfF = new jxl.write.WritableCellFormat(
                    wf);
            jxl.write.Label labelCF = new jxl.write.Label(4, 4, "文本", wcfF);
            sheet.addCell(labelCF);

            // 添加带有字体颜色,带背景颜色 Formatting的对象
            jxl.write.WritableFont wfc = new jxl.write.WritableFont(
                    WritableFont.ARIAL, 10, WritableFont.BOLD, false,
                    jxl.format.UnderlineStyle.NO_UNDERLINE,
                    jxl.format.Colour.RED);
            jxl.write.WritableCellFormat wcfFC = new jxl.write.WritableCellFormat(
                    wfc);
            wcfFC.setBackground(jxl.format.Colour.BLUE);
            jxl.write.Label labelCFC = new jxl.write.Label(1, 5, "带颜色", wcfFC);
            sheet.addCell(labelCFC);

            // 添加带有formatting的Number对象
            jxl.write.NumberFormat nf = new jxl.write.NumberFormat("#.##");
            jxl.write.WritableCellFormat wcfN = new jxl.write.WritableCellFormat(
                    nf);
            jxl.write.Number labelNF = new jxl.write.Number(1, 1, 3.1415926,
                    wcfN);
            sheet.addCell(labelNF);

            // 3.添加Boolean对象
            jxl.write.Boolean labelB = new jxl.write.Boolean(0, 2, false);
            sheet.addCell(labelB);

            // 4.添加DateTime对象
            jxl.write.DateTime labelDT = new jxl.write.DateTime(0, 3,
                    new java.util.Date());
            sheet.addCell(labelDT);

            // 添加带有formatting的DateFormat对象
            jxl.write.DateFormat df = new jxl.write.DateFormat(
                    "ddMMyyyyhh:mm:ss");
            jxl.write.WritableCellFormat wcfDF = new jxl.write.WritableCellFormat(
                    df);
            jxl.write.DateTime labelDTF = new jxl.write.DateTime(1, 3,
                    new java.util.Date(), wcfDF);
            sheet.addCell(labelDTF);

            // 和宾单元格
            // sheet.mergeCells(int col1,int row1,int col2,int row2);//左上角到右下角
            sheet.mergeCells(4, 5, 8, 10);// 左上角到右下角
            wfc = new jxl.write.WritableFont(WritableFont.ARIAL, 40,
                    WritableFont.BOLD, false,
                    jxl.format.UnderlineStyle.NO_UNDERLINE,
                    jxl.format.Colour.GREEN);
            jxl.write.WritableCellFormat wchB = new jxl.write.WritableCellFormat(
                    wfc);
            wchB.setAlignment(jxl.format.Alignment.CENTRE);
            labelCFC = new jxl.write.Label(4, 5, "单元合并", wchB);
            sheet.addCell(labelCFC); //

            // 设置边框
            jxl.write.WritableCellFormat wcsB = new jxl.write.WritableCellFormat();
            wcsB.setBorder(jxl.format.Border.ALL,
                    jxl.format.BorderLineStyle.THICK);
            labelCFC = new jxl.write.Label(0, 6, "边框设置", wcsB);
            sheet.addCell(labelCFC);
            workbook.write();
            workbook.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("end");
        Runtime r = Runtime.getRuntime();
        Process p = null;
        // String cmd[]={"notepad","exec.java"};
        String cmd[] = {
                "C:\\Program Files\\Microsoft Office\\Office\\EXCEL.EXE",
                "out.xls" };
        try {
            p = r.exec(cmd);
        } catch (Exception e) {
            System.out.println("error executing: " + cmd[0]);
        }

    }
}
