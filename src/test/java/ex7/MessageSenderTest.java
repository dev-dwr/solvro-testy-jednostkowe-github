package ex7;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class MessageSenderTest {

    private MessageSender messageSender;

    @BeforeEach
    void setUp() {
        messageSender = new MessageSender();
    }

    @Test
    void shouldSendMessageToExistingUser() {
        // given
        messageSender.addMessage("red", "Hi red");
        messageSender.addMessage("black", "Hi black");
        messageSender.addMessage("grey", "Hi grey");
        // when
        Statistics result = messageSender.send();
        //then
        assertThat(result.getSuccess()).isEqualTo(3);
        assertThat(result.getFailure()).isEqualTo(0);
    }

    @Test
    void shouldNotSendMessageToNonExistingUser() {
        // given
        messageSender.addMessage("green", "Hi non existing green");
        messageSender.addMessage("purple", "Hi non existing purple");
        // when
        Statistics result = messageSender.send();
        //then
        assertThat(result.getFailure()).isEqualTo(2);
        assertThat(result.getSuccess()).isEqualTo(0);
    }

    @Test //warunek brzegowy
    void shouldNotSendMessageToAnyKindOfUser() {
        // given
        // when
        Statistics result = messageSender.send();
        //then
        assertThat(result.getFailure()).isEqualTo(0);
        assertThat(result.getSuccess()).isEqualTo(0);
    }
}