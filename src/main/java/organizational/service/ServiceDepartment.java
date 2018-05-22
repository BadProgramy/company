package organizational.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import organizational.dao.department.DAODepartment;
import organizational.dao.exception.DeleteDepartmentException;
import organizational.dao.exception.UniqueException;
import organizational.model.Department;
import organizational.model.Event;
import organizational.model.exception.DataFormatException;

import java.util.List;
import java.util.Map;

@Service
public class ServiceDepartment {

    @Autowired
    private DAODepartment daoDepartment;

    @Transactional
    public List<Department> getAllDepartment() {
        return daoDepartment.getAllDepartment();
    }

    @Transactional
    public int insert(Department department) throws UniqueException {
        return daoDepartment.insert(department);
    }

    @Transactional
    public void updateName(int id, String name) throws UniqueException {
        daoDepartment.updateName(id, name);
    }

    @Transactional
    public void delete(int id) throws DeleteDepartmentException {
        daoDepartment.delete(id);
    }

    @Transactional
    public Department findDepartmentById(int id) {
        return daoDepartment.findDepartmentById(id);
    }

    @Transactional
    public Department findDepartmentByName(String name) {
        return daoDepartment.findDepartmentByName(name);
    }

    @Transactional
    public List<Department> getSubordinatedDepartments(int id) {
        return daoDepartment.getSubordinatedDepartments(id);
    }

    @Transactional
    public void moveDepartment(int id, int idParentDepartment) {
        daoDepartment.moveDepartment(id, idParentDepartment);
    }

    @Transactional
    public List<Department> getAllSubordinatedDepartments(int id) {
        return daoDepartment.getAllSubordinatedDepartments(id);
    }

    @Transactional
    public List<Department> getByIdAboveStandingDepartments(int id) {
        return daoDepartment.getByIdAboveStandingDepartments(id);
    }

    @Transactional
    public float getSalaryAllEmployeesByDepartment(int id) {
        return daoDepartment.getSalaryAllEmployeesByDepartment(id);
    }

    @Transactional
    public void saveFundSalaryDepartment() {
        daoDepartment.saveFundSalaryDepartment();
    }

    @Transactional
    public Map<String, Object> getInfoByDepartment(int id) throws DataFormatException {
        return daoDepartment.getInfoByDepartment(id);
    }

    @Transactional
    public List<Event> getAllEvents() {
        return daoDepartment.getAllEvents();
    }
}
