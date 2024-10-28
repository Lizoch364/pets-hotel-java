package miit.pets_hotel.Api;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import lombok.AllArgsConstructor;
import miit.pets_hotel.models.Feed;
import miit.pets_hotel.service.FeedService;

@RestController
@AllArgsConstructor
@RequestMapping("/api/v1/hotels/feeds")
@CrossOrigin(origins = "http://localhost:5173")
public class FeedController {
  private final FeedService service;

  @GetMapping
  public List<Feed> getAll() {
   return service.getAll();
  }
  @GetMapping("/{id}")
  public Feed getById (@PathVariable int id) {
    return service.getById(id);
  }

  @PostMapping("")
  @ResponseStatus(HttpStatus.CREATED)
  public Feed create(@RequestBody Feed feed) {
    return service.create(feed);
  }

  @PutMapping("")
  public boolean update(@RequestBody Feed feed){
    return service.update(feed);
  }

  @DeleteMapping("/{id}")
  public void delete(@PathVariable int id) {
    service.delete(id);
  }
}
