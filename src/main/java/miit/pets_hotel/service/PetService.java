package miit.pets_hotel.service;

import java.util.List;

import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;
import miit.pets_hotel.models.Pet;
import miit.pets_hotel.repository.PetRepository;

@Service
@AllArgsConstructor
public class PetService implements IPetService {
  private final PetRepository repository;
  @Override
  public List<Pet> getAll() {
    return repository.getAll();
  }

  @Override
  public Pet getById(int id) {
    return repository.getById(id);
  }

  @Override
  public Pet create(Pet pet) {
    return repository.create(pet);
  }

  @Override
  public boolean update(Pet pet) {
    return repository.update(pet);
  }

  @Override
  public void delete(int id) {
    repository.delete(id);
  }
}
