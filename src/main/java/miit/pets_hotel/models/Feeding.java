package miit.pets_hotel.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "feeging", schema = "public")
public class Feeding {
  @Id
  @Column(insertable = false, name = "id")
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private int id;

  @OneToOne
  @JoinColumn(name = "id_pet")
  private Pet pet;

  @ManyToOne
  @JoinColumn(name = "id_feed")
  private Feed feed;

  @Column(name = "diet")
  private String diet;
}
