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
     * ���ַ�Ϊ��λ��ȡ�ļ��������ڶ��ı������ֵ����͵��ļ�
     */
    public static String readFileByChars(String fileName) {
        File file = new File(fileName);
        Reader reader = null;
        StringBuffer fileString = new StringBuffer();
        try {
        	System.out.println("����ǰ�ļ���-------------------");
            //System.out.println("���ַ�Ϊ��λ��ȡ�ļ����ݣ�һ�ζ�һ���ֽڣ�");
            reader = new InputStreamReader(new FileInputStream(file));
            int tempchar;
            while ((tempchar = reader.read()) != -1) {
                // ����windows�£�\r\n�������ַ���һ��ʱ����ʾһ�����С�
                // ������������ַ��ֿ���ʾʱ���ỻ�����С�
                // ��ˣ����ε�\r����������\n�����򣬽������ܶ���С�
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
       System.out.println("���ܺ��ļ���-------------");
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
    	   //�����ķ���destest.txt�ļ���
    		
    		desToFile.desStrToFile(desFileStr,"src/destest.txt");
    		System.out.println("���ܺ��ļ�------------");
    		//�ѽ��ܺ��ļ�����decodetest.txt�ļ���
    		desToFile.desStrToFile(desUtil.decrypt(desFileStr, "huangjiabo!&#$%"),"src/decodetest.txt");
    		System.out.println(desUtil.decrypt(desFileStr, "huangjiabo!&#$%"));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
