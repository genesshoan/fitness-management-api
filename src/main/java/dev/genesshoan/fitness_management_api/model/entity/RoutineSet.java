package dev.genesshoan.fitness_management_api.model.entity;

import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.MapsId;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "routine_sets")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class RoutineSet {
  @EmbeddedId
  private RoutineSetId routineSetId;

  @ManyToOne(fetch = FetchType.LAZY)
  @MapsId("routineId")
  private Routine routine;

  @ManyToOne(fetch = FetchType.LAZY)
  @MapsId("exerciseId")
  private Exercise exercise;

  @Column(nullable = false)
  private double targetWeight;

  @Column(nullable = false)
  private int targetReps;

  @Column(nullable = false)
  private int restMinutes;

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
    RoutineSet other = (RoutineSet) obj;
    if (routineSetId == null) {
      if (other.routineSetId != null)
        return false;
    } else if (!routineSetId.equals(other.routineSetId))
      return false;
    return true;
  }
}
