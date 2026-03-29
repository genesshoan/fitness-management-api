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
@Table(name = "training_sets")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class TrainingSet {
  @EmbeddedId
  private TrainingSetId trainingSetId;

  @ManyToOne(fetch = FetchType.LAZY)
  @MapsId("trainingId")
  private Training training;

  @ManyToOne(fetch = FetchType.LAZY)
  @MapsId("exerciseId")
  private Exercise exercise;

  @Column(nullable = false)
  private double weight;

  @Column(nullable = false)
  private int reps;

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
    TrainingSet other = (TrainingSet) obj;
    if (trainingSetId == null) {
      if (other.trainingSetId != null)
        return false;
    } else if (!trainingSetId.equals(other.trainingSetId))
      return false;
    return true;
  }
}
