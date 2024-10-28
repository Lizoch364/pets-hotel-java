package miit.pets_hotel.service;

import java.util.List;

import miit.pets_hotel.models.TypeFeed;

public interface ITypeFeedService {
  List<TypeFeed> getAll();
  TypeFeed getById(int id);
}
