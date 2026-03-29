package dev.genesshoan.fitness_management_api.model.entity;

import java.io.Serializable;

import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Embeddable
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class ExerciseMuscleId implements Serializable {
  private Long exerciseId;
  private Long muscleId;

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
    ExerciseMuscleId other = (ExerciseMuscleId) obj;
    if (exerciseId == null) {
      if (other.exerciseId != null)
        return false;
    } else if (!exerciseId.equals(other.exerciseId))
      return false;
    if (muscleId == null) {
      if (other.muscleId != null)
        return false;
    } else if (!muscleId.equals(other.muscleId))
      return false;
    return true;
  }

}
