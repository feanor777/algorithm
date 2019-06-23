package algorithm

import algorithm.function.FunctionCalculator
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import spock.lang.Specification

import java.util.stream.Collectors
import java.util.stream.IntStream

@SpringBootTest
class AppTest extends Specification {
    @Autowired
    private List<FunctionCalculator> functionCalculators

    def "function complexity should be according to the list"() {
        given:
        def params = IntStream.range(1, 50).collect()

        when:
        def functionToValue = functionCalculators.stream()
                .collect(Collectors.toMap(
                        { k -> k.getName() },
                        { v -> v.calculate(params) }
                ))

        then:
        println functionToValue.sort{ entry1, entry2 -> entry1.value <=> entry2.value }
        functionToValue.sort{ entry1, entry2 -> entry1.value <=> entry2.value }*.key == ['constant', 'logarithmic', 'linear', 'linear logarithmic', 'quadratic', 'cubic', 'exponential']

    }

}
