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
import java.util.Map;

@Service
public class ServiceDepartment {

    @Autowired
    private Factory factory;

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
            if (sizeEmployeesInDepartment(id) == 0)
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

    public Department findDepartmentByName(String name) {
        Department department;
        SqlSession session = factory.getFactory().openSession();
        try {
            department = session.selectOne("Department.selectByName",name);
        } finally {
            session.close();
        }
        return department;
    }

    public List<Department> getSubordinatedDepartments(int id) {//метод Д5 из ТЗ
        List<Department> departments;
        SqlSession session = factory.getFactory().openSession();
        try{
            departments = session.selectList("Department.selectByIdParentDepartment",id);
        } finally {
            session.close();
        }
        return departments;
    }

    public void moveDepartment(Department department) { //метод Д7 из ТЗ
        SqlSession session = factory.getFactory().openSession();
        try{
            session.update("Department.updateIdParentDepartment",department);
        } finally {
            session.commit();
            session.close();
        }
    }

    public List<Department> getAllSubordinatedDepartments(int id) {//метод Д6 из ТЗ
        List<Department> departments;
        SqlSession session = factory.getFactory().openSession();
        try {
            departments = session.selectList("Department.selectByIdParentAllDepartment",id);
        } finally {
            session.close();
        }
        return departments;
    }

    public List<Department> getByIdAboveStandingDepartments(int id) { //метод Д8 из ТЗ
        List<Department> departments;
        SqlSession session = factory.getFactory().openSession();
        try {
            departments = session.selectList("Department.selectByIdAboveStandingDepartment",id);
        } finally {
            session.close();
        }
        return departments;
    }

    public float getSalaryAllEmployeesByDepartment(int id) {
        float sum;
        SqlSession session = factory.getFactory().openSession();
        try {
            sum = session.selectOne("Department.sumSalaryEmployeesByDepartment",id);
        } finally {
            session.close();
        }
        return sum;
    }

    public Map<String, Object> getInfoByDepartment(int id){
        JSONObject info = new JSONObject();
        Department department = findDepartmentById(id);
        info.put("Наименование", department.getName());
        info.put("Дата создания", department.getDateCreation());
        Employee headEmployee = headEmployeeInDepartment(id);
        if (headEmployee != null)
            info.put("Руководитель", headEmployee);
        else info.put("Руководитель", "не назначен");
        info.put("Количество сотрудников",sizeEmployeesInDepartment(id));
        return info.toMap();
    }

    private Employee headEmployeeInDepartment(int id) {
        Employee employee;
        SqlSession session = factory.getFactory().openSession();
        try {
            employee = session.selectOne("Employee.headEmployeeInDepartment",id);
        } finally {
            session.close();
        }
        return employee;
    }

    private int sizeEmployeesInDepartment(int id) {
        int size;
        SqlSession session = factory.getFactory().openSession();
        try {
            size = session.selectOne("Employee.countEmployeesInDepartment",id);
        } finally {
            session.close();
        }
        return size;
    }

    private boolean uniqueDepartment(Department department){
        for (Department depart: getAllDepartment()) {
            if (depart.getName().equals(department.getName())) return false;
        }
        return true;
    }
}
