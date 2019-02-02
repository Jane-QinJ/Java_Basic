package com.util.db;



import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;

/*
 * ��װ���������һ������Ĺ��̣����ǿ��԰����ڴ����зǳ����õĴ����ȡ�������γ�һ�������ࡣ

��һ�������󹫹��Ĵ��뵽�����ࡣ
�ڶ�����Ϊ��߿������Ӳ�ͬ���ݿ�����������������ݿ��URL���û������������Ϣ��д��һ�������ļ���jdbc.properties���У������Ժ�����޸ġ�
 */
/**
 * ���ݿ����������
 * @author �ؼ�
 *
 */
public class DBUtils {
	//���ݿ����ӵ�ַ
	public static String URL;
	//�û���
	public static String USERNAME;
	//����
	public static String PASSWORD;
	//mysql��������
	public static String DRIVER;
	//�����Կ��Կ����������ǽ��������ݿ��URL���û������������Ϣ��д��һ�������ļ���jdbc.properties���У��Ժ�����������������ļ�
	private static ResourceBundle rb = ResourceBundle.getBundle("db-config");
	
	//��Ȼ�ǹ����࣬һ�㲻Ҫʵ��������ʱ���Բ��õ������ģʽ�����߽����췽��˽�л�
	private DBUtils() {}
	//Ϊ�����ظ����룬ʹ�þ�̬����飺ֻ��������ص�ʱ��ִ��һ�Ρ�
		//ʹ�þ�̬�������������
		static {
			URL = rb.getString("jdbc.url");
			USERNAME = rb.getString("jdbc.username");
			PASSWORD = rb.getString("jdbc.password");
			DRIVER = rb.getString("jdbc.driver");
			try {
				Class.forName(DRIVER);
			}catch(ClassNotFoundException e) {
				e.printStackTrace();
			}
		}
		
		//����һ����ȡ���ݿ����ӵķ���
		public static Connection getConnection() {
			Connection conn = null;
			try {
				conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
				
			}catch(SQLException e) {
				e.printStackTrace();
				System.out.println("��ȡ����ʧ��");
			}
			return conn;
		}
		/**
		 * �ر����ݿ�����
		 * @param rs
		 * @param stat
		 * @param conn
		 */
		public static void close(ResultSet rs, Statement stat,Connection conn) {
			try {
				if(rs!=null) rs.close();
				if(stat!=null) stat.close();
				if(conn!=null) conn.close();
				
			}catch(SQLException e) {
				e.printStackTrace();
			}
		}
	
	}
	

