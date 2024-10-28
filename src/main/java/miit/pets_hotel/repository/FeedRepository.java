package miit.pets_hotel.repository;

import java.util.List;

import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import jakarta.persistence.criteria.*;
import miit.pets_hotel.Hibernate;
import miit.pets_hotel.models.Feed;

@Repository
public class FeedRepository {
  public Feed getById(int id) {
    Session session = Hibernate.getSessionFactory().openSession();
    var value = session.get(Feed.class, id);
    session.close();

    return value;
  }

  public List<Feed> getAll() {
    Session session = Hibernate.getSessionFactory().openSession();
    CriteriaBuilder feedBuilder = session.getCriteriaBuilder();
    CriteriaQuery<Feed> feedQuery = feedBuilder.createQuery(Feed.class);
    Root<Feed> feedRoot = feedQuery.from(Feed.class);
    feedQuery.orderBy(feedBuilder.asc(feedRoot.get("id")));

    feedQuery.select(feedRoot);

    var value = session.createQuery(feedQuery).getResultList();
    session.close();

    return value;
    }

    public Feed create(Feed feed) {
      Hibernate.getSessionFactory().inTransaction(session -> {
        session.persist(feed);
      });

      return feed;
    }

    public boolean update(Feed feed) {
      Session session = Hibernate.getSessionFactory().openSession();
      session.beginTransaction();

      Feed feedFromDB = session.get(Feed.class, feed.getId());
      feedFromDB.setTypeFeed(feed.getTypeFeed());
      feedFromDB.setPrice(feed.getPrice());
      feedFromDB.setName(feed.getName());

      session.persist(feedFromDB);
      session.getTransaction().commit();

      return true;
    }

    public void delete(int id) {
      Hibernate.getSessionFactory().inTransaction(session -> {
        Feed feed = session.get(Feed.class, id);
        session.remove(feed);
      });
    }
}
