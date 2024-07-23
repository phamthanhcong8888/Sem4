package congpt.code.appemployee.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import congpt.code.appemployee.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
    List<Employee> findAllByOrderByNameAsc();
    List<Employee> findByNameContainingIgnoreCase(String name);
}

