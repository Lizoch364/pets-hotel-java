package miit.pets_hotel.repository;

import java.util.List;

import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;
import miit.pets_hotel.Hibernate;
import miit.pets_hotel.models.TypeFeed;

@Repository
public class TypeFeedRepository {
  public TypeFeed getById(int id) {
    Session session = Hibernate.getSessionFactory().openSession();
    var value = session.get(TypeFeed.class, id);
    session.close();

    return value;
  }

  public List<TypeFeed> getAll() {
    Session session = Hibernate.getSessionFactory().openSession();
    CriteriaBuilder typeFeedBuilder = session.getCriteriaBuilder();
    CriteriaQuery<TypeFeed> typeFeedQuery = typeFeedBuilder.createQuery(TypeFeed.class);
    Root<TypeFeed> typeFeedRoot = typeFeedQuery.from(TypeFeed.class);
    typeFeedQuery.select(typeFeedRoot);

    var value = session.createQuery(typeFeedQuery).getResultList();
    session.close();

    return value;
  }
}
