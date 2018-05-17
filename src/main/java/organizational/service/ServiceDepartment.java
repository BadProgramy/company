package organizational.service;

import org.apache.ibatis.session.SqlSession;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import organizational.model.Department;
import organizational.model.Employee;
import organizational.service.exception.DeleteDepartmentException;
import organizational.service.exception.UniqueException;

import java.util.ArrayList;
import java.util.List;

@Service
public class ServiceDepartment {

    @Autowired
    private Factory factory;

    @Autowired
    private ServiceEmployee serviceEmployee;

    public List<Department> getAllDepartment(){
        List<Department> departments;
        SqlSession session = factory.getFactory().openSession();
        try {
            departments = session.selectList("Department.selectAll");
        } finally {
            session.close();
        }
        return departments;
    }

    public int insert(Department department) throws UniqueException {
        int id = -1;
        SqlSession session = factory.getFactory().openSession();
        try {
            if (uniqueDepartment(department)) {
                if (department.getIdParentDepartment() != 0)
                    id = session.insert("Department.insert", department);
                else id = session.insert("Department.insertHead", department);
            }
            else throw new UniqueException();
        } finally {
            session.commit();
            session.close();
        }
        return id;
    }

    public void updateName(Department department) throws UniqueException {
        SqlSession session = factory.getFactory().openSession();
        try {
            if (uniqueDepartment(department))
                session.update("Department.updateName", department);
            else throw new UniqueException();
        } finally {
            session.commit();
            session.close();
        }
    }

    public void delete(int id) throws DeleteDepartmentException {
        SqlSession session = factory.getFactory().openSession();
        try {
            if (findDepartmentById(id).sizeEmployees() == 0)
                session.delete("Department.delete",id);
            else throw new DeleteDepartmentException();
        } finally {
            session.commit();
            session.close();
        }
    }

    public Department findDepartmentById(int id) {
        Department department;
        SqlSession session = factory.getFactory().openSession();
        try {
            department = session.selectOne("Department.selectById",id);
        } finally {
            session.close();
        }
        return department;
    }

    public String getInfoByDepartment(int id){
        JSONObject info = new JSONObject();
        Department department = findDepartmentById(id);
        info.put("Наименование", department.getName());
        info.put("Дата создания", department.getDateCreation());
        Employee headEmployee = headEmployeeByIdDepartment(id);
        info.put("Руководитель", headEmployee.getFirstName().concat(" ")
                .concat(headEmployee.getSecondName()).concat(" "));
        info.put("Количество сотрудников",department.sizeEmployees());
        return info.toString();
    }

    public List<Employee> getEmployeesByIdDepartment(int id){
        List<Employee> employees = new ArrayList<>();
        for (Integer idEmployee: findDepartmentById(id).getEmployees()) {
            employees.add(serviceEmployee.findEmployeeById(idEmployee));
        }
        return employees;
    }

    public Employee headEmployeeByIdDepartment(int id){
        for (Employee employee: getEmployeesByIdDepartment(id)) {
            if (employee.isHead()) return employee;
        }
        return null;
    }

    private boolean uniqueDepartment(Department department){
        for (Department depart: getAllDepartment()) {
            if (depart.getName().equals(department.getName())) return false;
        }
        return true;
    }
}
