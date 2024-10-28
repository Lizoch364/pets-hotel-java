package miit.pets_hotel.service;

import java.util.List;

import miit.pets_hotel.models.Feed;


public interface IFeedService {
  List<Feed> getAll();
  Feed getById(int id);
  Feed create (Feed feed);
  Boolean update (Feed feed);
  void delete (int id);

}
