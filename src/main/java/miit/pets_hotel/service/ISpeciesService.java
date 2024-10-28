package miit.pets_hotel.service;

import java.util.List;

import miit.pets_hotel.models.Species;

public interface ISpeciesService {
  List<Species> getAll();
  Species getById(int id);
}
