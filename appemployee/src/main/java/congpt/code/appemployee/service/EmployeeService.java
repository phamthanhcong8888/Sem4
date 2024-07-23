package congpt.code.appemployee.service;

import java.util.List;

import congpt.code.appemployee.entity.Employee;

public interface EmployeeService {
    public List<Employee> findAll();
    public Employee findById(int theId);
    public void save(Employee theEmployee);
    public void deleteById(int theId);
    public List<Employee> searchByName(String name);
}
