package miit.pets_hotel;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import miit.pets_hotel.models.Employee;
import miit.pets_hotel.models.Feed;
import miit.pets_hotel.models.Feeding;
import miit.pets_hotel.models.Owner;
import miit.pets_hotel.models.Payment;
import miit.pets_hotel.models.Pet;
import miit.pets_hotel.models.Species;
import miit.pets_hotel.models.TypeFeed;

public class Hibernate {
  private static SessionFactory sessionFactory;

  public static SessionFactory getSessionFactory() {
    if (sessionFactory == null) {
      sessionFactory = buildSessionFactory();
    }

    return sessionFactory;
  }

  private static SessionFactory buildSessionFactory() {
    return new Configuration()
      .addAnnotatedClass(Species.class)
      .addAnnotatedClass(Employee.class)
      .addAnnotatedClass(Feed.class)
      .addAnnotatedClass(Feeding.class)
      .addAnnotatedClass(Owner.class)
      .addAnnotatedClass(Payment.class)
      .addAnnotatedClass(Pet.class)
      .addAnnotatedClass(TypeFeed.class)
      .buildSessionFactory();
  }
}
