package test;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.jar.*;

import util.DesUtil;
public class FileToDes {
	 /**
     * 以字符为单位读取文件，常用于读文本，数字等类型的文件
     */
    public static String readFileByChars(String fileName) {
        File file = new File(fileName);
        Reader reader = null;
        StringBuffer fileString = new StringBuffer();
        try {
        	System.out.println("加密前文件：-------------------");
            //System.out.println("以字符为单位读取文件内容，一次读一个字节：");
            reader = new InputStreamReader(new FileInputStream(file));
            int tempchar;
            while ((tempchar = reader.read()) != -1) {
                // 对于windows下，\r\n这两个字符在一起时，表示一个换行。
                // 但如果这两个字符分开显示时，会换两次行。
                // 因此，屏蔽掉\r，或者屏蔽\n。否则，将会多出很多空行。
                if (((char) tempchar) != '\r') {
                    System.out.print((char) tempchar);
                    fileString.append((char) tempchar);
                }
            }
            reader.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
       finally {
            if (reader != null) {
                try {
                    reader.close();
                } catch (IOException e1) {
                }
            }
        }
       System.out.println("加密后文件：-------------");
        return fileString.toString();
    }
    public static void main(String[] args) {
    	DesUtil desUtil = new DesUtil();
    	DesToFile desToFile = new DesToFile();
    	readFileByChars("src/test.txt");
    	String desFileStr ="";
    	try {
    		desFileStr = desUtil.encrypt(readFileByChars("src/test.txt"),"huangjiabo!&#$%");
    		System.out.println(desFileStr);
    	   //把密文放入destest.txt文件中
    		
    		desToFile.desStrToFile(desFileStr,"src/destest.txt");
    		System.out.println("解密后文件------------");
    		//把解密后文件放入decodetest.txt文件中
    		desToFile.desStrToFile(desUtil.decrypt(desFileStr, "huangjiabo!&#$%"),"src/decodetest.txt");
    		System.out.println(desUtil.decrypt(desFileStr, "huangjiabo!&#$%"));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
