package dev.genesshoan.fitness_management_api.record.domain;

import java.time.LocalDateTime;

import dev.genesshoan.fitness_management_api.training.domain.TrainingSet;
import dev.genesshoan.fitness_management_api.user.domain.User;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.PrePersist;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "personal_records", uniqueConstraints = @UniqueConstraint(name = "uk_pr_training_set_id_type", columnNames = {
    "training_set_id", "type" }))
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class PersonalRecord {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "user_id", nullable = false)
  private User user;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "training_set_id", nullable = false)
  private TrainingSet trainingSet;

  @Enumerated(EnumType.STRING)
  @Column(nullable = false)
  private PRType type;

  @Column(nullable = false, updatable = false)
  private LocalDateTime achievedAt;

  @PrePersist
  protected void onCreate() {
    this.achievedAt = LocalDateTime.now();
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
    PersonalRecord other = (PersonalRecord) obj;
    if (id == null) {
      if (other.id != null)
        return false;
    } else if (!id.equals(other.id))
      return false;
    return true;
  }
}
