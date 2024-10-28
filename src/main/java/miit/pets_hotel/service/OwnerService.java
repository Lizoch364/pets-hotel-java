package miit.pets_hotel.service;

import java.util.List;

import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;
import miit.pets_hotel.models.Owner;
import miit.pets_hotel.repository.OwnerRepository;

@Service
@AllArgsConstructor
public class OwnerService implements IOwnerService{

  private final OwnerRepository repository;

  @Override
  public List<Owner> getAll() {
    return repository.getAllOwners();
 }

  @Override
  public Owner getById(int id) {
    return repository.getById(id);
  }

  @Override
  public Owner create(Owner owner) {
    return repository.createOwner(owner);
  }

  @Override
  public Owner update(Owner owner) {
    return repository.updateOwner(owner);
  }

  @Override
  public void delete(int id) {
    repository.deleteOwner(id);
  }
}
