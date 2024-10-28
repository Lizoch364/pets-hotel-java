package miit.pets_hotel.Api;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import lombok.AllArgsConstructor;
import miit.pets_hotel.models.Owner;
import miit.pets_hotel.service.OwnerService;

@RestController
@AllArgsConstructor
@RequestMapping("/api/v1/hotels/owners")
@CrossOrigin(origins = "http://localhost:5173")

public class OwnerController {
  private final OwnerService service;

  @GetMapping
  public List<Owner> getAll() {
   return service.getAll();
  }

  @GetMapping("/{id}")
  public Owner getOwnerById (@PathVariable int id) {
    return service.getById(id);
  }

  @PostMapping("")
  @ResponseStatus(HttpStatus.CREATED)
  public Owner createOwner(@RequestBody Owner owner) {
    return service.create(owner);
  }

  @PutMapping("")
  public Owner updateOwner (@RequestBody Owner owner){
    return service.update(owner);
  }

  @DeleteMapping("/{id}")
  public void deleteOwner(@PathVariable int id) {
    service.delete(id);
  }
}
