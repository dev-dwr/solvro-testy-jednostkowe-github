package ex6;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;


class EmptyStringTest {

    @ParameterizedTest(name = "Param: `{0}`")
    @ValueSource(strings = {"a", "   a", "   bcd", "   a   ", "  "})
    void shouldCheckIfStringIsNotEmpty(String candidates) {
        // given
        String string = "abc";
        // when
        boolean result = EmptyString.checkStringIfNotEmpty(candidates);
        //then
        assertThat(result).isTrue();
    }
}