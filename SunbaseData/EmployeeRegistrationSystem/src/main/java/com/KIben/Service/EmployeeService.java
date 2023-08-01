package com.KIben.Service;

import com.KIben.Bean.Employee;
import com.KIben.Exception.EmployeeException;

import java.util.List;

public interface EmployeeService {
    public Employee RegisterEmployee(Employee add) throws EmployeeException;
    public Employee DeleteAdmin(int id)throws EmployeeException;
    public Employee UpdateAdminDetails(Employee up)throws EmployeeException;
    public Employee SearchAdminByID(int id)throws EmployeeException;
    public List<Employee> ViewAllAdmin()throws EmployeeException;
}
