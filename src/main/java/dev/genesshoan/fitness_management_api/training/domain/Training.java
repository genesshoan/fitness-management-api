package dev.genesshoan.fitness_management_api.training.domain;

import java.time.LocalDateTime;
import java.util.List;

import dev.genesshoan.fitness_management_api.user.domain.User;
import dev.genesshoan.fitness_management_api.routine.domain.Routine;
import dev.genesshoan.fitness_management_api.common.domain.DatabaseConstraints;

import jakarta.persistence.CheckConstraint;
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
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "training",
  check = {
    @CheckConstraint(name = "ck_training_duration_positive", constraint = DatabaseConstraints.CK_DURATION_MINUTES_POSITIVE)
  }
)
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Training {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(nullable = false, updatable = false)
  private LocalDateTime dateTime;

  @Column(nullable = false)
  private int durationMinutes;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "user_id", nullable = false)
  private User user;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "routine_id", nullable = true)
  private Routine routine;

  @OneToMany(mappedBy = "training", fetch = FetchType.LAZY, orphanRemoval = true)
  private List<TrainingSet> trainingSets;

  @OneToMany(mappedBy = "training", fetch = FetchType.LAZY, orphanRemoval = true)
  private List<TrainingComment> trainingComments;

  @PrePersist
  protected void onCreate() {
    this.dateTime = LocalDateTime.now();
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
    Training other = (Training) obj;
    if (id == null) {
      if (other.id != null)
        return false;
    } else if (!id.equals(other.id))
      return false;
    return true;
  }
}
