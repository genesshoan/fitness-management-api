package dev.genesshoan.fitness_management_api.common.domain;

/**
 * Shared database constraint definitions to avoid duplication across entities.
 * Use these constants in @CheckConstraint annotations.
 */
public interface DatabaseConstraints {

  // BaseSet constraints
  String CK_SET_NUMBER_POSITIVE = "number > 0";

  // BaseBlock constraints
  String CK_BLOCK_NUMBER_POSITIVE = "number > 0";
  String CK_REST_SECONDS_NON_NEGATIVE = "rest_seconds >= 0";

  // SetMetrics constraints (embedded in sets)
  String CK_WEIGHT_POSITIVE = "weight IS NULL OR weight > 0";
  String CK_REPS_POSITIVE = "reps IS NULL OR reps > 0";
  String CK_DURATION_POSITIVE = "duration_sec IS NULL OR duration_sec > 0";
  String CK_DISTANCE_POSITIVE = "distance_meters IS NULL OR distance_meters > 0";
  String CK_ADDITIONAL_WEIGHT_NON_NEGATIVE = "additional_weight IS NULL OR additional_weight >= 0";

  // Training constraints
  String CK_DURATION_MINUTES_POSITIVE = "duration_minutes > 0";

  // UserProgressHistory constraints
  String CK_HEIGHT_POSITIVE = "height IS NULL OR height > 0";
  String CK_USER_WEIGHT_POSITIVE = "weight IS NULL OR weight > 0";
}
