package com.mvc.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.mvc.entity.Student;
import com.sun.org.apache.regexp.internal.recompile;

/**
 * ���ݷ��ʲ�
 * 
 * @author 10852
 *
 */
public class StudentDao {

	private static String url = "jdbc:mysql://localhost:3306/web1";
	private static String user = "root";
	private static String password = "123456";

	/*
	 * ����ѧ��
	 */
	public boolean addStudent(Student student) {
    	Connection connection = null;
    	PreparedStatement ps= null;
    	
    	
    	try {
			Class.forName("com.mysql.jdbc.Driver") ;
			
			connection = DriverManager.getConnection(url, user, password) ;
			String sql ="insert into student(id,name,age,gender) values(?,?,?,?)";
			 ps = connection.prepareStatement(sql) ;
			 ps.setInt(1, student.getId());
			 ps.setString(2, student.getName());
			 ps.setString(3, student.getAge());
			 ps.setString(4, student.getGender());
			 
			 int count = ps.executeUpdate();
			
			 if (count >0 ) {
				return true ; // ���ӳɹ�
			}else {
				return false; // ����ʧ��
			}	 
			 
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return false;
		}finally {
			if(ps !=null) {
				try {
					ps.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if(connection !=null) {
				try {
					connection.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}
	/*
	 * 根据学号修改
	 */

	public boolean updateStudentById(int id, Student student) {

		Connection connection = null;
    	PreparedStatement ps= null;
    	
    	
    	try {
			Class.forName("com.mysql.jdbc.Driver") ;
			
			connection = DriverManager.getConnection(url, user, password) ;
			String sql ="update  student set name=?,age= ?,gender=? where id= ?";
			
			 ps = connection.prepareStatement(sql) ;
			 // 修改后的内
			 ps.setString(1, student.getName());
			 ps.setString(2, student.getAge());
			 ps.setString(3, student.getGender());
			 
			 // 被修改的人
			 ps.setInt(4, id);
			 
			 int count = ps.executeUpdate();
			
			 if (count >0 ) {
				return true ; // ���ӳɹ�
			}else {
				return false; // ����ʧ��
			}	 
			 
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return false;
		}finally {
			if(ps !=null) {
				try {
					ps.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if(connection !=null) {
				try {
					connection.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}
	/*
	 * ɾ��
	 */

	/*
	 *   根据 id 删除学生
	 */
	public boolean deleteStudentById(int id) {
		
		Connection connection = null;
    	PreparedStatement ps= null;
    	
    	
    	try {
			Class.forName("com.mysql.jdbc.Driver") ;
			
			connection = DriverManager.getConnection(url, user, password) ;
			String sql ="delete from student where id= ?";
			 ps = connection.prepareStatement(sql) ;
			 ps.setInt(1, id);
			 int count = ps.executeUpdate();
			
			 if (count >0 ) {
				return true ; // ���ӳɹ�
			}else {
				return false; // ����ʧ��
			}	 
			 
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return false;
		}finally {
			if(ps !=null) {
				try {
					ps.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if(connection !=null) {
				try {
					connection.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}

	}

	/*
	 * ��ѯѧ��ǰ ���жϴ��ڷ�
	 */
	public boolean isExist(int id) {
		return queryStudentById(id) == null ? false : true;
	}

	/*
	 * ����id ��ѯ
	 */

	public Student queryStudentById(int id) {

		Student student = null;
		Connection connection = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");

			connection = DriverManager.getConnection(url, user, password);
			String sql = "select * from student where id =?";
			ps = connection.prepareStatement(sql);

			ps.setInt(1, id);
			rs = ps.executeQuery();
			if (rs.next()) {
				int sid = rs.getInt("id");
				String name = rs.getString("name");
				String age = rs.getString("age");
				String gender = rs.getString("gender");
//				 System.out.println(id+"--"+name+"--"+age+"--"+gender);
				student = new Student(sid, name, age, gender);
			}

			return student;
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			// û������� �򷵻� ��
			return null;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return null;
		} finally {
			if (rs != null) {
				try {
					rs.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if (ps != null) {
				try {
					ps.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if (connection != null) {
				try {
					connection.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}

	}
	
	public List<Student> queryAllStudent() {
		List<Student> students = new ArrayList<Student>() ;
		
		Student student = null;
		Connection connection = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");

			connection = DriverManager.getConnection(url, user, password);
			String sql = "select * from student";
			ps = connection.prepareStatement(sql);
			
			rs = ps.executeQuery();
		    while (rs.next()) {
				int sid = rs.getInt("id");
				String name = rs.getString("name");
				String age = rs.getString("age");
				String gender = rs.getString("gender");
//				 System.out.println(id+"--"+name+"--"+age+"--"+gender);
				student = new Student(sid, name, age, gender);
				students.add(student);
			}

		    // 返回学生集合
			return students;
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			// û������� �򷵻� ��
			return null;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return null;
		} finally {
			if (rs != null) {
				try {
					rs.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if (ps != null) {
				try {
					ps.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if (connection != null) {
				try {
					connection.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}

	}
}
