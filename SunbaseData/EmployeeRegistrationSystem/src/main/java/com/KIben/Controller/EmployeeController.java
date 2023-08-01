package com.KIben.Controller;

import com.KIben.Bean.Employee;
import com.KIben.Exception.EmployeeException;
import com.KIben.Service.EmployeeService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class EmployeeController {

    @Autowired
    private EmployeeService ad;

    @PostMapping("/RegEmployee")
    public ResponseEntity<Employee> RegisterEmployee( @RequestBody Employee adms)throws EmployeeException{
        Employee add = ad.RegisterEmployee(adms);

        return new ResponseEntity<Employee>(add, HttpStatus.ACCEPTED);
    }



    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Employee> deleteEmployee( @PathVariable("id") int adms)throws EmployeeException {

        Employee del = ad.DeleteAdmin(adms);

        return new ResponseEntity<Employee>(del, HttpStatus.ACCEPTED);

    }

    @GetMapping("/viewallAdmin")
    public ResponseEntity<List<Employee>> viewAllEmployee()throws EmployeeException {

        List<Employee> vie = ad.ViewAllAdmin();

        return new ResponseEntity<List<Employee>>(vie, HttpStatus.ACCEPTED);


    }


    @GetMapping("/viwadbyid/{id}")
    public ResponseEntity<Employee> viewbyid(@PathVariable("id") int adms)throws EmployeeException{

        Employee byid = ad.SearchAdminByID(adms);

        return new ResponseEntity<Employee>(byid,HttpStatus.ACCEPTED);

    }


    @PutMapping("/update")
    public ResponseEntity<Employee> updateAdmin(@RequestBody Employee adms)throws EmployeeException{

        Employee up = ad.UpdateAdminDetails(adms);

        return new ResponseEntity<Employee>(up,HttpStatus.ACCEPTED);


    }


    }
