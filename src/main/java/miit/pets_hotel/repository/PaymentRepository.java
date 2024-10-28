package miit.pets_hotel.repository;

import java.util.List;

import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;
import miit.pets_hotel.Hibernate;
import miit.pets_hotel.models.Payment;

@Repository
public class PaymentRepository {
  public Payment getById(int id) {
    Session session = Hibernate.getSessionFactory().openSession();
    var value = session.get(Payment.class, id);
    session.close();

    return value;
  }

  public List<Payment> getAll() {
    Session session = Hibernate.getSessionFactory().openSession();
    CriteriaBuilder paymentBuilder = session.getCriteriaBuilder();
    CriteriaQuery<Payment> paymentQuery = paymentBuilder.createQuery(Payment.class);
    Root<Payment> paymentRoot = paymentQuery.from(Payment.class);
    paymentQuery.orderBy(paymentBuilder.asc(paymentRoot.get("id")));

    paymentQuery.select(paymentRoot);

    var value = session.createQuery(paymentQuery).getResultList();
    session.close();

    return value;
  }

  public Payment create(Payment payment) {
    Hibernate.getSessionFactory().inTransaction(session -> {
      session.persist(payment);
    });

    return payment;
  }

  public boolean update(Payment payment) {
    Session session = Hibernate.getSessionFactory().openSession();
    session.beginTransaction();

    Payment paymentFromDB = session.get(Payment.class, payment.getId());
    paymentFromDB.setCostPerDay(payment.getCostPerDay());
    paymentFromDB.setDepartureDate(payment.getDepartureDate());
    paymentFromDB.setArrivalDate(payment.getArrivalDate());

    session.persist(paymentFromDB);
    session.getTransaction().commit();

    return true;
  }

  public void delete(int id) {
    Hibernate.getSessionFactory().inTransaction(session -> {
      Payment payment = session.get(Payment.class, id);
      session.remove(payment);
    });
  }
}
