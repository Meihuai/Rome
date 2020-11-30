package com.example.registration.utils;

import com.example.registration.domain.NodeServer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.beans.XMLDecoder;
import java.beans.XMLEncoder;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;

/**
 * Title: XmlUtil
 * Description:  持久化工具类
 * @author meihua
 */
public class XmlUtil {

	private static final Logger logger = LoggerFactory.getLogger(XmlUtil.class);
	
	/**
	   *   读取xml中的持久化了的对象
	 * @param filepath 文件路径
	 * @return 任意类型的java对象
	 */
	public static Object read(String filepath) {
		InputStream in;
		try {
			in = new FileInputStream(filepath);
			XMLDecoder d = new XMLDecoder(in);
			Object obj =  d.readObject();
			in.close();
			d.close();
			return obj;
		} catch (Exception e) {
			logger.error("read file error filepath:{}",filepath);
			return null;
		}
	}
	
	/**
	 * 将java对象写入xml
	 * @param obj 需要持久化的java对象
	 * @param filepath xml文件路径
	 */
	public static void write(Object obj,String filepath) {
		FileOutputStream out=null;
		try {
			out = new FileOutputStream(filepath);
			XMLEncoder encoder = new XMLEncoder(out);
			encoder.writeObject(obj);
			encoder.close();
		} catch (Exception e) {
			logger.error("write file ：{} error filepath:{}",obj,e);
		}
	}

	public static void main(String[] args) {
		String property = System.getProperty("user.dir")+"\\node.xml";

		write(new NodeServer("127.0.0.1",80,true),"D:\\test\\node.xml");
		NodeServer read = (NodeServer)read("D:\\test\\node.xml");
		System.out.println(read);
	}
}