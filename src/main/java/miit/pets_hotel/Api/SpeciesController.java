package miit.pets_hotel.Api;

import java.util.List;

import org.springframework.web.bind.annotation.*;

import lombok.AllArgsConstructor;
import miit.pets_hotel.models.Species;
import miit.pets_hotel.service.SpeciesService;

@RestController
@AllArgsConstructor
@RequestMapping("/api/v1/hotels/species")
@CrossOrigin(origins = "http://localhost:5173")
public class SpeciesController {
  private final SpeciesService service;

  @GetMapping
  public List<Species> getAll() {
   return service.getAll();
  }

  @GetMapping("/{id}")
  public Species getById (@PathVariable int id) {
    return service.getById(id);
  }
}
