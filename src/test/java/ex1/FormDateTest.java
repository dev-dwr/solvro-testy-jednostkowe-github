package ex1;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;


//alt insert
//ctrl + alt + t
//option + command + t
class FormDateTest {

    @Test
    void shouldFormatDateToYearMonthDayString(){
        // given
        LocalDate date = LocalDate.of(2016, 1, 22);
        // when
        String result = FormDate.formDateToString(date);
        //then
        assertEquals("2016-01", result);
    }

}