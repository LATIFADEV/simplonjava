package com.managercours.services;

import java.util.List;

import com.managercours.dao.CourseDAO;
import com.managercours.entities.Courses;

public class CoursesDaoImp {
	private static CourseDAO courseDao;

	public CoursesDaoImp() {
		courseDao = new CourseDAO();
	}

	public void persist(Courses entity) {
		courseDao.persist(entity);
	}

	public void update(Courses entity) {
		courseDao.update(entity);
	}

	public Courses findById(int id) {
		Courses course = courseDao.findById(id);
		return course;
	}

	public void delete(int id) {
			courseDao.delete(id);
	}

	public List<Courses> findAll() {
		List<Courses> courses = courseDao.findAll();
		return courses;
	}
}
