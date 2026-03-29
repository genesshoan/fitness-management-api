package dev.genesshoan.fitness_management_api.exercise.domain;

import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.MapsId;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "exercise_muscle")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class ExerciseMuscle {
  @EmbeddedId
  private ExerciseMuscleId id;

  @ManyToOne(fetch = FetchType.LAZY)
  @MapsId("exerciseId")
  private Exercise exercise;

  @ManyToOne(fetch = FetchType.LAZY)
  @MapsId("muscleId")
  private Muscle muscle;

  @Enumerated(EnumType.STRING)
  @Column(nullable = false)
  private MuscleImpact impact;

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
    ExerciseMuscle other = (ExerciseMuscle) obj;
    if (id == null) {
      if (other.id != null)
        return false;
    } else if (!id.equals(other.id))
      return false;
    return true;
  }

}
