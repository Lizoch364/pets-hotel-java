package miit.pets_hotel.service;

import java.util.List;

import miit.pets_hotel.models.Pet;

public interface IPetService {
  List<Pet> getAll();
  Pet getById(int id);
  Pet create (Pet pet);
  boolean update (Pet pet);
  void delete (int id);

}
