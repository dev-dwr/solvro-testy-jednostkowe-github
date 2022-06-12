package ex6;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;


class FibonacciIterativeTest {

    @ParameterizedTest
    @MethodSource("fibonacciParamsProvider")
    void shouldReturnFibonacciForGivenNumber(int inputFibonacciNumber, int outputFibonacciNumber) {
        // given
        //int number = 10;
        // when
        int result = FibonacciIterative.fibonacci(inputFibonacciNumber);
        //then
        assertThat(result).isEqualTo(outputFibonacciNumber);
    }

    @ParameterizedTest
    @CsvSource({
            "0, 0",
            "1, 1",
            "2, 1",
            "3, 2",
            "4, 3",
            "5, 5",
            "6, 8",
            "7, 13",
            "8, 21",
            "9, 34"
    })//jak mamy prymitywy to lepiej uzywac CSVSource
    void shouldReturnFibonacciForGivenNumberCSVSource(int inputFibonacciNumber, int outputFibonacciNumber) {
        // given
        //int number = 10;
        // when
        int result = FibonacciIterative.fibonacci(inputFibonacciNumber);
        //then
        assertThat(result).isEqualTo(outputFibonacciNumber);
    }

    //jesli jako paramery beda obiekty to lepiej jest uzyc tego sposobu
    static Stream<Arguments> fibonacciParamsProvider(){
        return Stream.of(
                Arguments.arguments(0,0),
                Arguments.arguments(1,1),
                Arguments.arguments(2,1),
                Arguments.arguments(3,2),
                Arguments.arguments(4,3),
                Arguments.arguments(5,5),
                Arguments.arguments(6,8),
                Arguments.arguments(7,13),
                Arguments.arguments(8,21),
                Arguments.arguments(9,34)
        );
    }
}