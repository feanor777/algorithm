package algorithm.function.impl;

import org.springframework.stereotype.Service;

import java.util.List;

import algorithm.function.FunctionCalculator;
import algorithm.function.FunctionDescription;

@Service
public class LogarithmicFunction implements FunctionCalculator, FunctionDescription {
  private static final String NAME = "logarithmic";
  private static final int BASE_2 = 2;

  @Override
  public long calculate(List<Integer> params) {
    return params.stream()
        .map(this::apply)
        .mapToLong(x -> x)
        .sum();
  }

  public long apply(int param) {
    if (param == 0) {
      return 0;
    }
    return Math.round((Math.log(param) / Math.log(BASE_2)));
  }

  @Override
  public String getName() {
    return NAME;
  }
}