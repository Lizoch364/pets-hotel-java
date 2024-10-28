package miit.pets_hotel.service;

import java.util.List;

import miit.pets_hotel.models.Payment;

public interface IPaymentService {
  List<Payment> getAll();
  Payment getById(int id);
  Payment create (Payment payment);
  Boolean update (Payment payment);
  void delete (int id);

}
