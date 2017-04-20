package cn.jon.hadoop.hdfs;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URI;
import java.net.URISyntaxException;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.IOUtils;
import org.junit.Before;
import org.junit.Test;

public class HDFSDemo {
	FileSystem fs = null;	
	@Before
	public void init(){
		try {
			//��ʼ���ļ�ϵͳ
			fs = FileSystem.get(new URI("hdfs://hadoopmaster:9000"), new Configuration(), "root");
		} catch (IOException e) {
			e.printStackTrace();
		} catch (InterruptedException e) {
			e.printStackTrace();
		} catch (URISyntaxException e) {
			e.printStackTrace();
		}
	}
	public static void main(String[] args) {
		
	}
	@Test
	/**
	 * �ļ��ϴ�
	 */
	public void testFileUpload(){
		try {
			OutputStream os = fs.create(new Path("/test.log"));
			FileInputStream fis = new FileInputStream("I://test.log");
			IOUtils.copyBytes(fis, os, 2048,true);
			//����ʹ��hadoop�ṩ�ļ򵥷�ʽ
			//fs.copyFromLocalFile(new Path("I://test.log"), new Path("/test.log"));
		} catch (IllegalArgumentException | IOException e) {
			e.printStackTrace();
		}
	}
	@Test	
	/**
	 * �ļ�����
	 */
	public void testFileDownload(){
		try {
			InputStream is = fs.open(new Path("/test.log"));
			FileOutputStream fos = new FileOutputStream("D://test.log");			
			IOUtils.copyBytes(is, fos, 2048);
			//����ʹ��hadoop�ṩ�ļ򵥷�ʽ
			//fs.copyToLocalFile(new Path("/test.log"), new Path("D://test.log"));
		} catch (IllegalArgumentException | IOException e) {
			e.printStackTrace();
		}
	}

}
