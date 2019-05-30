package com.pawana.employee.helper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pawana.employee.service.EmployeeService;
import com.pawana.employee.util.APIResponse;
import com.pawana.employee.util.Status;
import com.pawana.employee.vo.Employee;

@Service
public class EmployeeHelper {
	
	@Autowired
	private EmployeeService employeeService;
	
	public APIResponse<Employee> getEmployee(Integer id) {
		APIResponse<Employee> apiResponse = new APIResponse<>();
		Employee employee =  employeeService.getEmployee(id);
		if(employee == null)
			throw new EmployeeNotFoundException("employee id "+id+" not found");
		apiResponse.setPayLoad(employee);
		apiResponse.setStatus(new Status());
		return apiResponse;
	}

}
