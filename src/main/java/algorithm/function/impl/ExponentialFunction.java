package algorithm.function.impl;

import org.springframework.stereotype.Service;

import java.util.List;

import algorithm.function.FunctionCalculator;
import algorithm.function.FunctionDescription;

@Service
public class ExponentialFunction implements FunctionCalculator, FunctionDescription {
  private static final String NAME = "exponential";

  @Override
  public long calculate(List<Integer> params) {
    return params.stream()
        .map(this::apply)
        .mapToLong(x -> x)
        .sum();
  }

  public long apply(int param) {
    return Math.round(Math.pow(2, param));
  }

  @Override
  public String getName() {
    return NAME;
  }
}
