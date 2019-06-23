package algorithm.function.impl;

import org.springframework.stereotype.Service;

import java.util.List;

import algorithm.function.FunctionCalculator;
import algorithm.function.FunctionDescription;

@Service
public class ConstantFunction implements FunctionCalculator, FunctionDescription {
  private static final String NAME = "constant";
  private static final long CONSTANT = 1;

  @Override
  public long calculate(List<Integer> params) {
    return params.stream()
        .map(param -> apply())
        .mapToLong(x -> x)
        .sum();
  }

  public long apply() {
    return CONSTANT;
  }

  @Override
  public String getName() {
    return NAME;
  }
}
