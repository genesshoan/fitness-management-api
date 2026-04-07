package dev.genesshoan.fitness_management_api.training.domain;

import java.util.ArrayList;
import java.util.List;

import dev.genesshoan.fitness_management_api.common.domain.BaseSet;
import dev.genesshoan.fitness_management_api.common.domain.DatabaseConstraints;
import dev.genesshoan.fitness_management_api.record.domain.PersonalRecord;
import dev.genesshoan.fitness_management_api.common.domain.SetMetrics;
import jakarta.persistence.CheckConstraint;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "training_sets", uniqueConstraints = @UniqueConstraint(name = "uk_training_exercise_block_number", columnNames = {
    "training_id", "exercise_id", "block_id", "number" }), check = {
        @CheckConstraint(name = "ck_training_set_number_positive", constraint = DatabaseConstraints.CK_SET_NUMBER_POSITIVE),
        @CheckConstraint(name = "ck_training_set_weight_positive", constraint = DatabaseConstraints.CK_WEIGHT_POSITIVE),
        @CheckConstraint(name = "ck_training_set_reps_positive", constraint = DatabaseConstraints.CK_REPS_POSITIVE),
        @CheckConstraint(name = "ck_training_set_duration_positive", constraint = DatabaseConstraints.CK_DURATION_POSITIVE),
        @CheckConstraint(name = "ck_training_set_distance_positive", constraint = DatabaseConstraints.CK_DISTANCE_POSITIVE),
        @CheckConstraint(name = "ck_training_set_additional_weight_non_negative", constraint = DatabaseConstraints.CK_ADDITIONAL_WEIGHT_NON_NEGATIVE)
    })
@NoArgsConstructor
@Getter
@Setter
public class TrainingSet extends BaseSet {
  @ManyToOne(fetch = FetchType.LAZY, optional = false)
  @JoinColumn(name = "block_id")
  private TrainingBlock block;

  @OneToMany(mappedBy = "trainingSet", fetch = FetchType.LAZY)
  private List<PersonalRecord> personalRecords = new ArrayList<>();

  public TrainingSet(Integer number, SetMetrics setMetrics, TrainingBlock block) {
    super(number, setMetrics);
    this.block = block;
  }
}
