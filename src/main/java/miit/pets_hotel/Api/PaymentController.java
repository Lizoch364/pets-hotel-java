package miit.pets_hotel.Api;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import lombok.AllArgsConstructor;
import miit.pets_hotel.models.Payment;
import miit.pets_hotel.service.PaymentService;

@RestController
@AllArgsConstructor
@RequestMapping("/api/v1/hotels/payments")
@CrossOrigin(origins = "http://localhost:5173")
public class PaymentController {
  private final PaymentService service;

  @GetMapping
  public List<Payment> getAll() {
   return service.getAll();
  }

  @GetMapping("/{id}")
  public Payment getOwnerById (@PathVariable int id) {
    return service.getById(id);
  }

  @PostMapping("")
  @ResponseStatus(HttpStatus.CREATED)
  public Payment createOwner(@RequestBody Payment payment) {
    return service.create(payment);
  }

  @PutMapping("")
  public boolean updateOwner (@RequestBody Payment payment){
    return service.update(payment);
  }

  @DeleteMapping("/{id}")
  public void deleteOwner(@PathVariable int id) {
    service.delete(id);
  }
}
