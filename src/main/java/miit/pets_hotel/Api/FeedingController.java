package miit.pets_hotel.Api;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import lombok.AllArgsConstructor;
import miit.pets_hotel.models.Feeding;
import miit.pets_hotel.service.FeedingService;

@RestController
@AllArgsConstructor
@RequestMapping("/api/v1/hotels/feeding")
@CrossOrigin(origins = "http://localhost:5173")
public class FeedingController {
  private final FeedingService service;

  @GetMapping("")
  public List<Feeding> getAll() {
      return service.getAll();
  }

  @GetMapping("/{id}")
  public Feeding getById(@PathVariable int id) {
      return service.getById(id);
  }

  @PostMapping("")
  @ResponseStatus(HttpStatus.CREATED)
  public Feeding create(@RequestBody Feeding feeding) {
      return service.create(feeding);
  }

  @PutMapping("")
  public boolean update(@RequestBody Feeding feeding) {
      return service.update(feeding);
  }

  @DeleteMapping("/{id}")
  public void delete(@PathVariable int id){
    service.delete(id);
  }
}
