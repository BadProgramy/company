package organizational.dao.department;

import org.apache.ibatis.annotations.Mapper;
import organizational.dao.exception.DeleteDepartmentException;
import organizational.dao.exception.UniqueException;
import organizational.model.Department;
import organizational.model.Event;
import organizational.model.exception.DataFormatException;

import java.util.List;
import java.util.Map;

@Mapper
public interface DAODepartment {
    List<Department> getAllDepartment();
    int insert(Department department) throws UniqueException;
    void updateName(int id, String name) throws UniqueException;
    void delete(int id) throws DeleteDepartmentException;
    Department findDepartmentById(int id);
    Department findDepartmentByName(String name);
    List<Department> getSubordinatedDepartments(int id);
    void moveDepartment(int id, int idParentDepartment);
    List<Department> getAllSubordinatedDepartments(int id);
    List<Department> getByIdAboveStandingDepartments(int id);
    float getSalaryAllEmployeesByDepartment(int id);
    void saveFundSalaryDepartment();//schedule
    Map<String, Object> getInfoByDepartment(int id) throws DataFormatException;
    List<Event> getAllEvents();
}
