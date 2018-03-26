package cn.kr;

import cn.kr.domain.Department;
import cn.kr.domain.Employee;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import java.util.List;


@Transactional
@SpringBootTest
@RunWith(SpringRunner.class)
public class AppTest {

    @Autowired
    private EntityManager entityManager;

    @Test
    public void testHello() {

        Employee employee = entityManager.find(Employee.class, 1L);
        //Department 为懒加载
        Department department = employee.getDepartment();
        System.out.println(department);

    }

    @Test
    public void test2() {

        Department department1 = entityManager.find(Department.class, 1L);
        //Department 为懒加载
        List<Employee> employees = department1.getEmployees();

        System.out.println(employees);
    }


    @Test
    public void testToJson() {

        Department department1 = entityManager.find(Department.class, 1L);
        //Department 为懒加载
//        List<Employee> employees = department1.getEmployees();
        Object toJSON = JSONObject.toJSON(department1);

    }


}
