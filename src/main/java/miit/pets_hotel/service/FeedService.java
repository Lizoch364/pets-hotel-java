package miit.pets_hotel.service;

import java.util.List;

import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;
import miit.pets_hotel.models.Feed;
import miit.pets_hotel.repository.FeedRepository;

@Service
@AllArgsConstructor
public class FeedService implements IFeedService{
  private final FeedRepository repository;

  @Override
  public List<Feed> getAll() {
    return repository.getAll();
  }

  @Override
  public Feed getById(int id) {
    return repository.getById(id);
  }

  @Override
  public Feed create(Feed feed) {
    return repository.create(feed);
  }

  @Override
  public Boolean update(Feed feed) {
    return repository.update(feed);
  }

  @Override
  public void delete(int id) {
    repository.delete(id);
  }
}
