package miit.pets_hotel.service;

import java.util.List;

import miit.pets_hotel.models.Feeding;

public interface IFeedingService {
  List<Feeding> getAll();
  Feeding getById(int id);
  Feeding create (Feeding feeding);
  Boolean update (Feeding feeding);
  void delete (int id);



}
