package miit.pets_hotel.Api;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import lombok.AllArgsConstructor;
import miit.pets_hotel.models.Pet;
import miit.pets_hotel.service.PetService;

@RestController
@AllArgsConstructor
@RequestMapping("/api/v1/hotels/pets")
@CrossOrigin(origins = "http://localhost:5173")
public class PetController {
  private final PetService service;

  @GetMapping
  public List<Pet> getAll() {
   return service.getAll();
  }
  @GetMapping("/{id}")
  public Pet getById (@PathVariable int id) {
    return service.getById(id);
  }

  @PostMapping("")
  @ResponseStatus(HttpStatus.CREATED)
  public Pet create(@RequestBody Pet pet) {
    return service.create(pet);
  }

  @PutMapping("")
  public boolean update(@RequestBody Pet pet){
    return service.update(pet);
  }

  @DeleteMapping("/{id}")
  public void delete(@PathVariable int id) {
    service.delete(id);
  }
}
