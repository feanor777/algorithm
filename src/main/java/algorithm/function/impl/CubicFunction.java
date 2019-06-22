package algorithm.function.impl;

import org.springframework.stereotype.Service;

import java.util.List;

import algorithm.function.FunctionCalculator;
import algorithm.function.FunctionDescription;

@Service
public class CubicFunction implements FunctionCalculator, FunctionDescription {
  private static final String NAME = "cubic";

  @Override
  public long calculate(List<Integer> params) {
    return params.stream()
        .map(this::apply)
        .mapToLong(x -> x)
        .sum();
  }

  public long apply(int param) {
    return (long)param * param * param;
  }

  @Override
  public String getName() {
    return NAME;
  }
}
