package dev.genesshoan.fitness_management_api.training.domain;

import dev.genesshoan.fitness_management_api.common.domain.BaseSet;
import dev.genesshoan.fitness_management_api.common.domain.DatabaseConstraints;
import jakarta.persistence.CheckConstraint;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;

import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "training_sets", 
  uniqueConstraints = @UniqueConstraint(name = "uk_training_exercise_block_number", columnNames = {
    "training_id", "exercise_id", "block_id", "number" }),
  check = {
    @CheckConstraint(name = "ck_training_set_number_positive", constraint = DatabaseConstraints.CK_SET_NUMBER_POSITIVE),
    @CheckConstraint(name = "ck_training_set_weight_positive", constraint = DatabaseConstraints.CK_WEIGHT_POSITIVE),
    @CheckConstraint(name = "ck_training_set_reps_positive", constraint = DatabaseConstraints.CK_REPS_POSITIVE),
    @CheckConstraint(name = "ck_training_set_duration_positive", constraint = DatabaseConstraints.CK_DURATION_POSITIVE),
    @CheckConstraint(name = "ck_training_set_distance_positive", constraint = DatabaseConstraints.CK_DISTANCE_POSITIVE),
    @CheckConstraint(name = "ck_training_set_additional_weight_non_negative", constraint = DatabaseConstraints.CK_ADDITIONAL_WEIGHT_NON_NEGATIVE)
  }
)
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class TrainingSet extends BaseSet {
  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "block_id", nullable = false)
  private TrainingBlock block;
}
