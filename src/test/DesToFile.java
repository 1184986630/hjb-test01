package test;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;

public class DesToFile {
	/**
	 *�Ѽ��ܺ���ַ���������ָ�����ļ��� 
	 * @param args
	 */
	 public static void desStrToFile(String desStr,String fileUrl){
	        byte[] bytexml = desStr.getBytes();  
	          
	        try {  
	            OutputStream os = new FileOutputStream(new File(fileUrl));  
	            os.write(bytexml);  
	            os.flush();  
	            os.close();  
	        } catch (FileNotFoundException e) {  
	            // TODO Auto-generated catch block  
	            e.printStackTrace();  
	        } catch (IOException e) {  
	            // TODO Auto-generated catch block  
	            e.printStackTrace();  
	        }  
	        System.out.println("�����ļ�д��ɹ���");
	 }
	 public static void main(String[] args) { 
		 
	        String xml = "55898";  
	        byte[] bytexml = xml.getBytes();  
	          
	        try {  
	            OutputStream os = new FileOutputStream(new File("src/destest.txt"));  
	            os.write(bytexml);  
	            os.flush();  
	            os.close();  
	        } catch (FileNotFoundException e) {  
	            // TODO Auto-generated catch block  
	            e.printStackTrace();  
	        } catch (IOException e) {  
	            // TODO Auto-generated catch block  
	            e.printStackTrace();  
	        }  
	    }  
	    public static void writeStrToFile(String xml){  
            try {    
                FileOutputStream fos = new FileOutputStream(new File(System.getProperty("user.dir")+"\\WebRoot\\xml_format_file.xml"));  
                Writer os = new OutputStreamWriter(fos, "GBK");  
                os.write(xml);  
                os.flush();  
                fos.close();  
            } catch (FileNotFoundException e) {    
                // TODO Auto-generated catch block     
                e.printStackTrace();    
            } catch (IOException e) {    
                // TODO Auto-generated catch block     
                e.printStackTrace();    
            }    
    }  
}
