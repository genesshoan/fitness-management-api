package dev.genesshoan.fitness_management_api.routine.domain;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import dev.genesshoan.fitness_management_api.user.domain.User;
import dev.genesshoan.fitness_management_api.training.domain.Training;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import jakarta.persistence.Table;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "routines")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Setter
public class Routine {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(nullable = false, length = 50)
  private String name;

  @Column(nullable = false, updatable = false, insertable = false)
  private LocalDate createdAt;

  @Column(nullable = false, insertable = false)
  private LocalDate updatedAt;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "user_id", nullable = false)
  private User user;

  @OneToMany(mappedBy = "routine", fetch = FetchType.LAZY)
  private List<Training> trainings = new ArrayList<>();

  @OneToMany(mappedBy = "routine", fetch = FetchType.LAZY)
  private List<RoutineBlock> blocks = new ArrayList<>();

  public Routine(String name, User user) {
    this.name = name;
    this.user = user;
  }

  @PrePersist
  protected void onCreate() {
    this.createdAt = LocalDate.now();
    this.updatedAt = createdAt;
  }

  @PreUpdate
  protected void onUpdate() {
    this.updatedAt = LocalDate.now();
  }

  @Override
  public int hashCode() {
    return getClass().hashCode();
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj)
      return true;
    if (obj == null)
      return false;
    if (getClass() != obj.getClass())
      return false;
    Routine other = (Routine) obj;
    if (id == null) {
      if (other.id != null)
        return false;
    } else if (!id.equals(other.id))
      return false;
    return true;
  }
}
