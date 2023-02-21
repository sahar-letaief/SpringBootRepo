package com.esprit.Dependency.tpDependencyInjection.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.esprit.Dependency.tpDependencyInjection.dao.IToDoDao;


@Service
public class ToDoService {
	@Autowired
	private IToDoDao toDoDao;

	public List<String> getCoursesList() {
		return toDoDao.getCoursesList();
	}
}
