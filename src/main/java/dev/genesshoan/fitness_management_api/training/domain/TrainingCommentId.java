package dev.genesshoan.fitness_management_api.training.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Embeddable
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
public class TrainingCommentId implements Serializable {

  @Column(name = "training_id")
  private Long trainingId;

  @Column(name = "exercise_id")
  private Long exerciseId;

  @Column(name = "block")
  private Integer block;

}
