package com.mvc.service;

import java.util.List;

import com.mvc.dao.StudentDao;
import com.mvc.entity.Student;
import com.sun.org.apache.regexp.internal.recompile;

/**
 * ҵ��� �߼��Ե� ��ɾ�Ĳ�
 * 
 * @author 10852
 *
 */
public class StudentService {

	StudentDao studentDao = new StudentDao();
	/*
	 * 增加
	 */

	public boolean addStudent(Student student) {
		// ���ǰ���ж� �����Ƿ����

		// �����ھ����
		if (!studentDao.isExist(student.getId())) {
			studentDao.addStudent(student);
			return true;
		} else {
			System.out.println("�����Ѵ���");
			return false;
		}
	}

	public boolean delteStudentById(int id) {
		// 此人存在
		if (studentDao.isExist(id)) {
			return studentDao.deleteStudentById(id);
		} else {
			return false;
		}
	}

	/*
	 * 修改
	 */

	public boolean updateStudentById(int id, Student student) {
		if (studentDao.isExist(id)) {
			return studentDao.updateStudentById(id, student);
		} else {
			return false;
		}
	}

	/*
	 *  根据学号查询 一个人
	 */
	public Student queryStudentById(int id) {

		return studentDao.queryStudentById(id) ;
		
	}
	
	/*
	 *  根据学号查询 一个人
	 */
	public List<Student> queryAllStudent() {

		return studentDao.queryAllStudent();
		
	}
}
