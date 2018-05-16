package organizational.service;

import org.apache.ibatis.annotations.Mapper;
import organizational.model.Employee;

import java.util.List;

@Mapper
public interface EmployeeDAO {
    List<Employee> getAllEmployee() throws Exception;
    int insert(Employee employee) throws Exception;
}
