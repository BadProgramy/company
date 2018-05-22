package organizational.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import organizational.dao.employee.DAOEmployee;
import organizational.model.Employee;
import organizational.model.exception.DataFormatException;
import organizational.dao.exception.CorrectDataException;
import java.util.List;

@Service
public class ServiceEmployee{

    @Autowired
    private DAOEmployee daoEmployee;

    @Transactional
    public int insert(Employee employee) throws CorrectDataException {
        return daoEmployee.insert(employee);
    }

    @Transactional
    public void update(int id, Employee employee) throws CorrectDataException {
        daoEmployee.update(id,employee);
    }

    @Transactional
    public List<Employee> getAllEmployee() {
        return daoEmployee.getAllEmployee();
    }

    @Transactional
    public List<Employee> getEmployeesByIdDepartment(int idDepartment) {
        return daoEmployee.getEmployeesByIdDepartment(idDepartment);
    }

    @Transactional
    public void layoffEmployee(int id, String dateLayoff) throws DataFormatException {
        daoEmployee.layoffEmployee(id, dateLayoff);
    }

    @Transactional
    public Employee findEmployeeById(int id) {
        return daoEmployee.findEmployeeById(id);
    }

    @Transactional
    public void moveEmployeeInDepartment(int id, int idDepartment) {
        daoEmployee.moveEmployeeInDepartment(id, idDepartment);
    }

    @Transactional
    public void moveAllEmployeesInDepartment(int idCurrentDepartment, int idNextDepartment) {
        daoEmployee.moveAllEmployeesInDepartment(idCurrentDepartment, idNextDepartment);
    }

    @Transactional
    public Employee getHeadEmployeeByEmployee(int id) {
        return daoEmployee.getHeadEmployeeByEmployee(id);
    }

    @Transactional
    public Employee findEmployee(String firstName, String secondName) {
        return daoEmployee.findEmployee(firstName, secondName);
    }
}
