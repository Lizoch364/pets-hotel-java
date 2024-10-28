package miit.pets_hotel.service;

import java.util.List;

import miit.pets_hotel.models.Owner;

public interface IOwnerService {
  List<Owner> getAll();
  Owner getById(int id);
  Owner create (Owner owner);
  Owner update (Owner owner);
  void delete (int id);
}
