package miit.pets_hotel.service;

import java.util.List;

import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;
import miit.pets_hotel.models.Payment;
import miit.pets_hotel.repository.PaymentRepository;

@Service
@AllArgsConstructor
public class PaymentService implements IPaymentService{
  private final PaymentRepository repository;

  @Override
  public List<Payment> getAll() {
    return repository.getAll();
  }

  @Override
  public Payment getById(int id) {
    return repository.getById(id);
  }

  @Override
  public Payment create(Payment payment) {
    return repository.create(payment);
  }

  @Override
  public Boolean update(Payment payment) {
    return repository.update(payment);
  }

  @Override
  public void delete(int id) {
    repository.delete(id);
  }
}
