package organizational.service;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import organizational.model.Employee;
import organizational.model.exception.DataFormatException;

import java.sql.Date;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class ServiceEmployee{

    @Autowired
    private Factory factory;

    public int insert(Employee employee) {
        int id;
        SqlSession session = factory.getFactory().openSession();
        try {
             session.insert("Employee.insert",employee);
             id = employee.getId();
        } finally {
            session.commit();
            session.close();
        }
        return id;
    }

    public void update(Employee employee) {
        Employee employeeUpdate = findEmployeeById(employee.getId());
        employeeUpdate.updateEmployee(employee);
        SqlSession session = factory.getFactory().openSession();
        try {
            session.update("Employee.update",employeeUpdate);
        } finally {
            session.commit();
            session.close();
        }
    }

    public List<Employee> getAllEmployee(){
        List<Employee> employees;
        SqlSession session = factory.getFactory().openSession();
        try {
            employees = session.selectList("Employee.selectAll");
        } finally {
            session.close();
        }
        return employees;
    }

    public List<Employee> getEmployeesByIdDepartment(int idDepartment) {
        List<Employee> employees;
        SqlSession session = factory.getFactory().openSession();
        try {
            employees = session.selectList("Employee.employeesByIdDepartment", idDepartment);
        } finally {
            session.close();
        }
        return employees;
    }
    public void layoffEmployee(int id, String dateLayoff) throws DataFormatException {
        SqlSession session = factory.getFactory().openSession();
        Employee employee = findEmployeeById(id);
        employee.setLayoff(dateLayoff);
        try {
            session.update("Employee.layoff",employee);
        } finally {
            session.commit();
            session.close();
        }
    }

    public Employee findEmployeeById(int id) {
        SqlSession session = factory.getFactory().openSession();
        Employee employee;
        try {
            employee = session.selectOne("Employee.selectById",id);
        } finally {
            session.close();
        }
        return employee;
    }

    public void moveEmployeeInDepartment(Employee employee) { //достаточно обычного запроса с таким параметром
        //не вижу смысла делать два параметра
        SqlSession session = factory.getFactory().openSession();
        try {
            session.update("Employee.updateDepartmentByIdEmployee", employee);
        } finally {
            session.commit();
            session.close();
        }
    }

    public void moveAllEmployeesInDepartment(int idCurrentDepartment, int idNextDepartment) {
        SqlSession session = factory.getFactory().openSession();
        Map<String,Integer> id = new HashMap<>();
        id.put("idCurrentDepartment",idCurrentDepartment);
        id.put("idNextDepartment",idNextDepartment);
        try {
            session.update("Employee.updateDepartmentAllEmployees", id);
        } finally {
            session.commit();
            session.close();
        }
    }

    public Employee getHeadEmployeeByEmployee(int id) {
        Employee employee;
        SqlSession session = factory.getFactory().openSession();
        try {
            employee = findEmployeeById(id);
            employee = session.selectOne("Employee.headEmployeeInDepartment", employee.getIdDepartment());
        } finally {
            session.close();
        }
        return employee;

    }

    public Employee findEmployee(String firstName, String secondName) {
        Employee employee;
        Map<String,String> name = new HashMap<>();
        name.put("firstName",firstName);
        name.put("secondName",secondName);
        SqlSession session = factory.getFactory().openSession();
        try {
            employee = session.selectOne("Employee.findEmployeeByName",name);
        } finally {
            session.close();
        }
        return employee;
    }

    public Factory getFactory() {
        return factory;
    }

    public void setFactory(Factory factory) {
        this.factory = factory;
    }
}
