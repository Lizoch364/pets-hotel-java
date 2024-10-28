package miit.pets_hotel.service;

import java.util.List;

import miit.pets_hotel.models.Employee;

public interface IEmployeeService {
  List<Employee> getAll();
  Employee getById(int id);
  Employee create (Employee employee);
  Boolean update (Employee employee);
  void delete (int id);


}
