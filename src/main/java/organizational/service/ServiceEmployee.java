package organizational.service;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import organizational.model.Employee;
import organizational.model.exception.DataFormatException;
import organizational.service.exception.CorrectDataException;
import organizational.service.exception.NullColumnException;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class ServiceEmployee{

    @Autowired
    private Factory factory;

    //todo я не понял что значит ОКЛАД должен быть валидным, я незнаю какие зарплаты у программистов да и вообще я студент 3го курса :)
    public int insert(Employee employee) throws CorrectDataException {
        int id = -1;
        SqlSession session = factory.getFactory().openSession();
        try {
            Employee headEmployee = session.selectOne("Employee.headEmployeeInDepartment",employee.getIdDepartment());
            if ((!employee.isHead() && (headEmployee == null || headEmployee.getSalary() > employee.getSalary())) ||
                    employee.isHead() && (headEmployee == null && employee.getSalary() > maxSalaryEmployees(employee.getIdDepartment())))
                id = session.insert("Employee.insert",employee);
            else throw new CorrectDataException();
        } catch (NullPointerException ex) {
            throw new NullColumnException();
        } finally {
            session.commit();
            session.close();
        }
        return id;
    }

    private float maxSalaryEmployees(int idDepartment) {
        Float maxSalary = 0f;
        SqlSession session = factory.getFactory().openSession();
        try {
            maxSalary = session.selectOne("Employee.maxSalaryInDepartment",idDepartment);
        } finally {
            session.close();
        }
        return maxSalary;
    }

    private void deleteEmployee(int id) {
        SqlSession session = factory.getFactory().openSession();
        try {
            session.delete("Employee.delete", id);
        } finally {
            session.commit();
            session.close();
        }
    }

    public void update(Employee employee) {
        SqlSession session = factory.getFactory().openSession();
        try {
            Employee employeeUpdate = findEmployeeById(employee.getId());
            Employee headEmployee = getHeadEmployeeByEmployee(employee.getId());
            employeeUpdate.updateEmployee(employee);
            if (headEmployee == null ||
                    (headEmployee != null && headEmployee.getId() == employeeUpdate.getId() && employeeUpdate.isHead() &&
                    employeeUpdate.getSalary() > maxSalaryEmployees(employeeUpdate.getIdDepartment())) ||
                    headEmployee != null && headEmployee.getId() == employeeUpdate.getId() && !employee.isHead())
                session.update("Employee.update",employee);
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
