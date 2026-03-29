package dev.genesshoan.fitness_management_api.common.domain;

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
public class SetMetrics {
  private Double weight;
  private Integer reps;

  private Integer durationSec;
  private Double distanceMeters;

  private Double additionalWeight;

  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((weight == null) ? 0 : weight.hashCode());
    result = prime * result + ((reps == null) ? 0 : reps.hashCode());
    result = prime * result + ((durationSec == null) ? 0 : durationSec.hashCode());
    result = prime * result + ((distanceMeters == null) ? 0 : distanceMeters.hashCode());
    result = prime * result + ((additionalWeight == null) ? 0 : additionalWeight.hashCode());
    return result;
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj)
      return true;
    if (obj == null)
      return false;
    if (getClass() != obj.getClass())
      return false;
    SetMetrics other = (SetMetrics) obj;
    if (weight == null) {
      if (other.weight != null)
        return false;
    } else if (!weight.equals(other.weight))
      return false;
    if (reps == null) {
      if (other.reps != null)
        return false;
    } else if (!reps.equals(other.reps))
      return false;
    if (durationSec == null) {
      if (other.durationSec != null)
        return false;
    } else if (!durationSec.equals(other.durationSec))
      return false;
    if (distanceMeters == null) {
      if (other.distanceMeters != null)
        return false;
    } else if (!distanceMeters.equals(other.distanceMeters))
      return false;
    if (additionalWeight == null) {
      if (other.additionalWeight != null)
        return false;
    } else if (!additionalWeight.equals(other.additionalWeight))
      return false;
    return true;
  }
}
