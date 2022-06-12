package ex5;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static ex5.Exceptions.DEFAULT_NUMBER;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

class ExceptionsTest {

    private Exceptions exceptions;

    @BeforeEach
    void setUp(){
        exceptions = new Exceptions();
    }

    @Test
    void shouldReturnStringFromNumberIfLessThanDefault() {
        // given
        int number = 3;
        // when
        String result = exceptions.justAFunction(number);
        //then
        assertThat(result).isNotNull();
        assertThat(result).isEqualTo("3");
    }

    @Test// brzegowy warunek
    void shouldReturnStringFromNumberIfEqualDefault() {
        // when
        String result = exceptions.justAFunction(DEFAULT_NUMBER);
        //then
        assertThat(result).isNotNull();
        assertThat(result).isEqualTo(String.valueOf(DEFAULT_NUMBER));
    }
    @Test
    void shouldThrowExceptionIfNumberIsBiggerThanDefault() {
        // given
        int number = 10;

        //will throw exception
//        try {
//            exceptions.justAFunction(number);
//            fail();//jesli spodziewamy sie wyjatku a nie zostanie on wyrzucony test nie przejdzie
//        }catch (IllegalArgumentException e){
//            assertThat(e)
//                    .isInstanceOf(IllegalArgumentException.class)
//                    .hasMessage("given number is bigger than default_number");
//
//        }

        //JUNIT 5
        assertThrows(IllegalArgumentException.class,
                () -> exceptions.justAFunction(number),
                "given number is bigger than default_number");

        //AssertJ
        assertThatThrownBy(() -> exceptions.justAFunction(number))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("given number is bigger than default_number");
    }
}