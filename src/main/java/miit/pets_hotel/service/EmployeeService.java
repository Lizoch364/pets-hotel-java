package miit.pets_hotel.service;

import java.util.List;

import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;
import miit.pets_hotel.models.Employee;
import miit.pets_hotel.repository.EmployeeRepository;

@Service
@AllArgsConstructor
public class EmployeeService implements IEmployeeService{
  private final EmployeeRepository repository;

  public List<Employee> getAll() {
    return repository.getAll();
  }

  @Override
  public Employee getById(int id) {
    return repository.getById(id);
  }

  @Override
  public Employee create(Employee employee) {
    return  repository.create(employee);
  }

  @Override
  public Boolean update(Employee employee) {
    return repository.update(employee);
  }

  @Override
  public void delete(int id) {
    repository.delete(id);
  }
}
