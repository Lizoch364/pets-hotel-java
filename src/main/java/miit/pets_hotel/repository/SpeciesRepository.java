package miit.pets_hotel.repository;

import java.util.List;

import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;
import miit.pets_hotel.Hibernate;
import miit.pets_hotel.models.Species;

@Repository
public class SpeciesRepository {
  public Species getById(int id) {
    Session session = Hibernate.getSessionFactory().openSession();
    var value = session.get(Species.class, id);
    session.close();

    return value;
  }

  public List<Species> getAll() {
    Session session = Hibernate.getSessionFactory().openSession();
    CriteriaBuilder speciesBuilder = session.getCriteriaBuilder();
    CriteriaQuery<Species> speciesQuery = speciesBuilder.createQuery(Species.class);
    Root<Species> speciesRoot = speciesQuery.from(Species.class);
    speciesQuery.select(speciesRoot);

    var value = session.createQuery(speciesQuery).getResultList();
    session.close();

    return value;
  }
}
