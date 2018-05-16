package organizational.service;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import organizational.model.Employee;

import java.util.List;

@Service
public class ServiceEmployee implements EmployeeDAO{

    @Autowired
    private Factory factory;

    @Override
    public int insert(Employee employee) {
        int id = -1;
        SqlSession session = factory.getFactory().openSession();
        try {
            id = session.insert("Employee.insert",employee);
        } finally {
            session.commit();
            session.close();
        }
        System.out.println("insert("+employee+")-->"+employee.getId());
        return id;
    }

    @Override
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

    public Factory getFactory() {
        return factory;
    }

    public void setFactory(Factory factory) {
        this.factory = factory;
    }
}
