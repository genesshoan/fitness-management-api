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
public class RoutineSetId implements Serializable {
  private Long routineId;
  private Long exerciseId;
  private Integer number;

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
    RoutineSetId other = (RoutineSetId) obj;
    if (routineId == null) {
      if (other.routineId != null)
        return false;
    } else if (!routineId.equals(other.routineId))
      return false;
    if (exerciseId == null) {
      if (other.exerciseId != null)
        return false;
    } else if (!exerciseId.equals(other.exerciseId))
      return false;
    if (number == null) {
      if (other.number != null)
        return false;
    } else if (!number.equals(other.number))
      return false;
    return true;
  }

}
