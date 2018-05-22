package organizational.dao.employee;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;
import organizational.dao.Factory;
import organizational.dao.exception.CorrectDataException;
import organizational.dao.exception.NullColumnException;
import organizational.model.Employee;
import organizational.model.exception.DataFormatException;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Primary
@Repository
public class DAOEmployeeImpl implements DAOEmployee {
    @Autowired
    private Factory factory;

    //todo я не понял что значит ОКЛАД должен быть валидным, толи зарплата не может быть 10^10 или 1000000р типо, но у меня значение
    //todo только лишь числом, так что я не понял, но а первый вариант я же незнаю про какой департамент идет речь и какая у них зарплата
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
        Float maxSalary;
        SqlSession session = factory.getFactory().openSession();
        try {
            maxSalary = session.selectOne("Employee.maxSalaryInDepartment",idDepartment);
        } finally {
            session.close();
        }
        if (maxSalary == null) return 0f;
        else return maxSalary;
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

    public void update(int id, Employee employee) throws CorrectDataException {
        employee.setId(id);
        SqlSession session = factory.getFactory().openSession();
        try {
            Employee employeeUpdate = findEmployeeById(employee.getId());
            Employee headEmployee = getHeadEmployeeByEmployee(employee.getId());
            employeeUpdate.updateEmployee(employee);
            if (headEmployee == null ||
                    (headEmployee.getId() == employeeUpdate.getId() && employeeUpdate.isHead() &&
                            employeeUpdate.getSalary() > maxSalaryEmployees(employeeUpdate.getIdDepartment())) ||
                    (headEmployee.getId() == employeeUpdate.getId() && !employeeUpdate.isHead() &&
                            employeeUpdate.getSalary() < maxSalaryEmployees(employeeUpdate.getIdDepartment())) ||
                    (headEmployee.getId() != employeeUpdate.getId() && !employeeUpdate.isHead() &&
                            employeeUpdate.getSalary() < headEmployee.getSalary()))
                session.update("Employee.update",employeeUpdate);
            else throw new CorrectDataException();
        } catch (NullPointerException ex) {
            session.rollback();
            session.close();
            throw new NullPointerException("Не найден сотрудник");
        }
        finally {
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

    //При перемещении сотрудники теряют статус руководителя, и его можно изменить лишь через update
    public void moveEmployeeInDepartment(int id, int idDepartment) {
        SqlSession session = factory.getFactory().openSession();
        Employee employee = new Employee();
        employee.setId(id);
        employee.setIdDepartment(idDepartment);
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
}
