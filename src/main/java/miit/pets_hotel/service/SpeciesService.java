package miit.pets_hotel.service;

import java.util.List;

import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;
import miit.pets_hotel.models.Species;
import miit.pets_hotel.repository.SpeciesRepository;

@Service
@AllArgsConstructor
public class SpeciesService implements ISpeciesService{
  private final SpeciesRepository repository;

  @Override
  public List<Species> getAll() {
    return repository.getAll();
  }

  @Override
  public Species getById(int id) {
    return repository.getById(id);
  }
}
