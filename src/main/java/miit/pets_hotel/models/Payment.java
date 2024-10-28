package miit.pets_hotel.models;

import java.time.LocalDate;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "paument", schema = "public")
public class Payment {
  @Id
  @Column(insertable = false, name = "id")
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private int id;

  @ManyToOne
  @JoinColumn(name = "id_pet")
  private Pet pet;

  @Column(name = "cost_per_day")
  private double costPerDay;

  @Column(name = "arrival_date")
  private LocalDate arrivalDate;

  @Column(name = "departure_date")
  private LocalDate departureDate;
}
