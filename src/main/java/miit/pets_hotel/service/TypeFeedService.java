package miit.pets_hotel.service;

import java.util.List;

import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;
import miit.pets_hotel.models.TypeFeed;
import miit.pets_hotel.repository.TypeFeedRepository;

@Service
@AllArgsConstructor
public class TypeFeedService implements ITypeFeedService{
  private final TypeFeedRepository repository;

  @Override
  public List<TypeFeed> getAll() {
    return repository.getAll();
  }

  @Override
  public TypeFeed getById(int id) {
    return repository.getById(id);
  }

}
