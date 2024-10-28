package miit.pets_hotel.Api;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.AllArgsConstructor;
import miit.pets_hotel.models.TypeFeed;
import miit.pets_hotel.service.TypeFeedService;

@RestController
@AllArgsConstructor
@RequestMapping("/api/v1/hotels/type-feed")
@CrossOrigin(origins = "http://localhost:5173")
public class TypeFeedController {
  private final TypeFeedService service;

  @GetMapping
  public List<TypeFeed> getAll() {
   return service.getAll();
  }
  @GetMapping("/{id}")
  public TypeFeed getById (@PathVariable int id) {
    return service.getById(id);
  }
}
