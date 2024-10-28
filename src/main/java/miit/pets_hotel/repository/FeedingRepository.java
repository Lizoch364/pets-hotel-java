package miit.pets_hotel.repository;

import java.util.List;

import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;
import miit.pets_hotel.Hibernate;
import miit.pets_hotel.models.Feeding;

@Repository
public class FeedingRepository {
  public Feeding getById(int id) {
    Session session = Hibernate.getSessionFactory().openSession();
    var value = session.get(Feeding.class, id);
    session.close();

    return value;
  }

  public List<Feeding> getAll() {
    Session session = Hibernate.getSessionFactory().openSession();
    CriteriaBuilder feedingBuilder = session.getCriteriaBuilder();
    CriteriaQuery<Feeding> feedingQuery = feedingBuilder.createQuery(Feeding.class);
    Root<Feeding> feedingRoot = feedingQuery.from(Feeding.class);
    feedingQuery.orderBy(feedingBuilder.asc(feedingRoot.get("id")));

    feedingQuery.select(feedingRoot);

    var value = session.createQuery(feedingQuery).getResultList();
    session.close();

    return value;
  }

    public Feeding create(Feeding feeding) {
      Hibernate.getSessionFactory().inTransaction(session -> {
        session.persist(feeding);
      });

      return feeding;
    }

    public boolean update(Feeding feeding) {
      Session session = Hibernate.getSessionFactory().openSession();
      session.beginTransaction();

      Feeding feedingFromDB = session.get(Feeding.class, feeding.getId());
      feedingFromDB.setPet(feeding.getPet());
      feedingFromDB.setFeed(feeding.getFeed());
      feedingFromDB.setDiet(feeding.getDiet());

      session.persist(feedingFromDB);
      session.getTransaction().commit();

      return true;
    }

    public void delete(int id) {
      Hibernate.getSessionFactory().inTransaction(session -> {
        Feeding feeding = session.get(Feeding.class, id);
        session.remove(feeding);
      });
    }
}
