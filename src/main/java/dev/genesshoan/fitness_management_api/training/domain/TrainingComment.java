package dev.genesshoan.fitness_management_api.training.domain;

import dev.genesshoan.fitness_management_api.exercise.domain.Exercise;
import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.MapsId;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "training_comments")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class TrainingComment {
  @EmbeddedId
  private TrainingCommentId id;

  @ManyToOne(fetch = FetchType.LAZY)
  @MapsId("trainingId")
  @JoinColumn(name = "training_id", nullable = false)
  private Training training;

  @ManyToOne(fetch = FetchType.LAZY)
  @MapsId("exerciseId")
  @JoinColumn(name = "exercise_id", nullable = false)
  private Exercise exercise;

  @Column(nullable = false, columnDefinition = "TEXT")
  private String text;

  @Override
  public int hashCode() {
    return id != null ? id.hashCode() : 0;
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj)
      return true;
    if (obj == null || getClass() != obj.getClass())
      return false;
    TrainingComment other = (TrainingComment) obj;
    return id != null && id.equals(other.id);
  }

}
