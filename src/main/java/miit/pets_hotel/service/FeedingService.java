package miit.pets_hotel.service;

import java.util.List;

import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;
import miit.pets_hotel.models.Feeding;
import miit.pets_hotel.repository.FeedingRepository;

@Service
@AllArgsConstructor
public class FeedingService implements IFeedingService{
  private final FeedingRepository repository;

  @Override
  public List<Feeding> getAll() {
    return repository.getAll();
  }

  @Override
  public Feeding getById(int id) {
    return repository.getById(id);
  }

  @Override
  public Feeding create(Feeding feeding) {
    return repository.create(feeding);
  }

  @Override
  public Boolean update(Feeding feeding) {
    return repository.update(feeding);
  }

  @Override
  public void delete(int id) {
    repository.delete(id);
  }
}
