package com.KIben.Service;

import com.KIben.Bean.Employee;
import com.KIben.Exception.EmployeeException;
import com.KIben.Repository.EmployeeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceIMPL implements EmployeeService{

    @Autowired
    private EmployeeRepo ad;

    @Override
    public Employee RegisterEmployee(Employee add) throws EmployeeException {

       Employee adr =  ad.save(add);

      return adr;

    }


    @Override
    public Employee DeleteAdmin(int id) throws EmployeeException {
        Optional<Employee>  del = ad.findById(id);

        if(del.isPresent()) {
            ad.deleteById(id);
        }

        else {
            throw new EmployeeException("Invalid ID for delete Admin");
        }
        return del.get();

    }

    @Override
    public Employee UpdateAdminDetails(Employee up) throws EmployeeException {
        Optional<Employee> upd = ad.findById(up.getEmployeID());

        if(upd.isEmpty()) {
            throw new EmployeeException("Id not found for update employee data");
        }else {
            ad.save(up);
        }
        return upd.get();
    }

    @Override
    public Employee SearchAdminByID(int id) throws EmployeeException {
        Optional<Employee> sid = ad.findById(id);

        if(sid.isEmpty()) {
            throw new EmployeeException("No Id Found");
        }else {
            return sid.get();
        }
    }


    @Override
    public List<Employee> ViewAllAdmin() throws EmployeeException {
        List<Employee> adm = ad.findAll();
        if(adm==null) {
            throw new EmployeeException("No Admin registered");
        }else {
            return adm;
        }
    }
}
