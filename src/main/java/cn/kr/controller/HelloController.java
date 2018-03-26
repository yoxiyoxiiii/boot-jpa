package cn.kr.controller;

import cn.kr.domain.Department;
import cn.kr.domain.Employee;
import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.persistence.EntityManager;
import java.util.List;

@Transactional
@RestController
public class HelloController {


    @Autowired
    private EntityManager entityManager;


    @GetMapping("/department")
    public Department department() {
        Department department1 = entityManager.find(Department.class, 1L);
        //Department 为懒加载
//        List<Employee> employees = department1.getEmployees();
        List<Employee> employees = department1.getEmployees();
        System.out.println(employees.get(0).getUsername());
        return department1;
    }


    @GetMapping("/employee")
    public Employee employee() {
        Employee employee = entityManager.find(Employee.class, 1L);
        //Department 为懒加载
//        List<Employee> employees = department1.getEmployees();
        Department department = employee.getDepartment();
        System.out.println(department);
        return employee;
    }
}
