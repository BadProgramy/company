package organizational.controller;

import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import organizational.model.Department;
import organizational.model.Event;
import organizational.model.exception.DataFormatException;
import organizational.service.ServiceDepartment;
import organizational.dao.exception.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("organization/departments")
public class RestControllerDepartment {

    @Autowired
    private ServiceDepartment serviceDepartment;


    @RequestMapping(value = "allDepartments",method = RequestMethod.POST)//++
    @ApiOperation("Get all departments")
    public List<Department> getAllEmployee() {
        return serviceDepartment.getAllDepartment();
    }

    @RequestMapping(value = "addDepartment",method = RequestMethod.GET)//++
    @ApiOperation("To add the department")
    public int addEmployee(Department department) throws UniqueException {
        return serviceDepartment.insert(department);
    }

    @RequestMapping(value = "updateNameDepartment",method = RequestMethod.GET)//++
    @ApiOperation("To edit the department only Name. In parameters it is possible to enter only id, name")
    public void updateName(int id, String name) throws UniqueException {
        serviceDepartment.updateName(id, name);
    }

    @RequestMapping(value = "delete", method = RequestMethod.DELETE)//++
    @ApiOperation("Remove department by id")
    public void deleteDepartment(int id) throws DeleteDepartmentException {
        serviceDepartment.delete(id);
    }

    @RequestMapping(value = "info",method = RequestMethod.GET)//++
    @ApiOperation("To receive information on department")
    public Map<String,Object> infoDepartment(int id) throws DataFormatException {
        return serviceDepartment.getInfoByDepartment(id);
    }

    @RequestMapping(value = "subordinatedDepartments",method = RequestMethod.GET)//++
    @ApiOperation("The departments which are under direct supervision of this department (one level lower)")
    public List<Department> getSubordinatedDepartments(int id){
        return serviceDepartment.getSubordinatedDepartments(id);
    }

    @RequestMapping(value = "allSubordinatedDepartments",method = RequestMethod.GET)//++
    @ApiOperation("The departments which are under supervision of this department (all subordinated departments)")
    public List<Department> getAllSubordinatedDepartments(int id) {
        return serviceDepartment.getAllSubordinatedDepartments(id);
    }

    @RequestMapping(value = "standingDepartment",method = RequestMethod.GET)//++
    @ApiOperation("Obtaining information on all higher departments of this department.")
    public List<Department> getByIdAboveStandingDepartment(int id) {
        return serviceDepartment.getByIdAboveStandingDepartments(id);
    }

    @RequestMapping(value = "moveDepartment",method = RequestMethod.GET)//++
    @ApiOperation("Transfer of department. A task of other department where this department will enter.")
    public void updateIdParentDepartmentById(int id, int idParentDepartment) {
        serviceDepartment.moveDepartment(id, idParentDepartment);
    }

    @RequestMapping(value = "findDepartmentById", method = RequestMethod.GET)
    @ApiOperation("Search of department in the identifier")
    public Department findDepartmentById(int id) {return serviceDepartment.findDepartmentById(id);}

    @RequestMapping(value = "findDepartmentByName",method = RequestMethod.GET)//++
    @ApiOperation("Search of department in the name.")
    public Department findDepartmentByName(String name) {
        return serviceDepartment.findDepartmentByName(name);
    }

    @RequestMapping(value = "salaryAllEmployeesByDepartment",method = RequestMethod.GET)//++
    @ApiOperation("Sum of salaries of all staff of department")
    public float getSalaryAllEmployeesByDepartment(int id) {
        return serviceDepartment.getSalaryAllEmployeesByDepartment(id);
    }

    @RequestMapping(value = "events",method = RequestMethod.GET)//++
    @ApiOperation("The taken place events (Creation, renaming, movement)")
    public List<Event> getEvents() {
        return serviceDepartment.getAllEvents();
    }
}
