package com.afraz.bo;

import java.util.List;

import com.afraz.dao.EmployeeDao;
import com.afraz.model.Employee;

public class EmployeeBo {
	EmployeeDao emp_dao=new EmployeeDao();
	
	public boolean insert(Employee emp_bean) {
		return emp_dao.insert(emp_bean);
	}

	public List<Employee> getAllEmps() {
		
		return emp_dao.getAllEmp();
	}

	public boolean deleteEmp(int idValue) {
		// TODO Auto-generated method stub
		return emp_dao.deleteEmp(idValue);
	}

	public Employee getEmp(int idval) {
		
		return emp_dao.getEmp(idval);
	}

	public boolean updateEmp(Employee emp_bean) {
		
		return emp_dao.updateEmp(emp_bean);
	}

}
