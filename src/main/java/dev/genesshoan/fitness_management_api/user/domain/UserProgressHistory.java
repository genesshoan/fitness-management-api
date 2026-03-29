package dev.genesshoan.fitness_management_api.user.domain;

import java.time.LocalDate;

import dev.genesshoan.fitness_management_api.common.domain.DatabaseConstraints;
import jakarta.persistence.CheckConstraint;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.PrePersist;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "user_progress_history",
  check = {
    @CheckConstraint(name = "ck_user_progress_height_positive", constraint = DatabaseConstraints.CK_HEIGHT_POSITIVE),
    @CheckConstraint(name = "ck_user_progress_weight_positive", constraint = DatabaseConstraints.CK_USER_WEIGHT_POSITIVE)
  }
)
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class UserProgressHistory {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "user_id", nullable = false)
  private User user;

  private Integer height;
  private Integer weight;
  private LocalDate date;

  @PrePersist
  protected void createAt() {
    this.date = LocalDate.now();
  }

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
    UserProgressHistory other = (UserProgressHistory) obj;
    if (id == null) {
      if (other.id != null)
        return false;
    } else if (!id.equals(other.id))
      return false;
    return true;
  }
}
