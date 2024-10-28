package miit.pets_hotel.Api;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import lombok.AllArgsConstructor;
import miit.pets_hotel.models.Employee;
import miit.pets_hotel.service.EmployeeService;

@RestController
@AllArgsConstructor
@RequestMapping("/api/v1/hotels/employees")
@CrossOrigin(origins = "http://localhost:5173")
public class EmployeeController {
  private final EmployeeService service;

  @GetMapping
  public List<Employee> getAll() {
   return service.getAll();
  }
  @GetMapping("/{id}")
  public Employee getById (@PathVariable int id) {
    return service.getById(id);
  }

  @PostMapping("")
  @ResponseStatus(HttpStatus.CREATED)
  public Employee create(@RequestBody Employee employee) {
    return service.create(employee);
  }

  @PutMapping("")
  public boolean update(@RequestBody Employee employee){
    return service.update(employee);
  }

  @DeleteMapping("/{id}")
  public void delete(@PathVariable int id) {
    service.delete(id);
  }
}
