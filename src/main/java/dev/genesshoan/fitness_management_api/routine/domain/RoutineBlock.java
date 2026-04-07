package dev.genesshoan.fitness_management_api.routine.domain;

import java.util.ArrayList;
import java.util.List;

import dev.genesshoan.fitness_management_api.common.domain.BaseBlock;
import dev.genesshoan.fitness_management_api.common.domain.DatabaseConstraints;
import dev.genesshoan.fitness_management_api.exercise.domain.Exercise;
import dev.genesshoan.fitness_management_api.common.domain.BaseSet;
import jakarta.persistence.CheckConstraint;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "routine_blocks", check = {
    @CheckConstraint(name = "ck_routine_block_number_positive", constraint = DatabaseConstraints.CK_BLOCK_NUMBER_POSITIVE),
    @CheckConstraint(name = "ck_routine_block_rest_seconds_non_negative", constraint = DatabaseConstraints.CK_REST_SECONDS_NON_NEGATIVE)
})
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Setter
public class RoutineBlock extends BaseBlock {
  @ManyToOne(fetch = FetchType.LAZY, optional = false)
  @JoinColumn(name = "routine_id")
  private Routine routine;

  @OneToMany(mappedBy = "block", fetch = FetchType.LAZY)
  private List<RoutineSet> sets = new ArrayList<>();

  public RoutineBlock(Integer number, Integer restSeconds, Exercise exercise, Routine routine) {
    super(number, restSeconds, exercise);
    this.routine = routine;
  }

  public void addSet(RoutineSet set) {
    set.setBlock(this);
    this.sets.add(set);
  }

  public void removeSet(RoutineSet set) {
    set.setBlock(null);
    this.sets.remove(set);
  }
}
