package ex8;

import ex8.model.Statistics;
import ex8.model.User;
import ex8.service.MessageService;
import ex8.service.UserService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentMatchers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.HashMap;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class MessageSenderModifiedTest {
    //mockito domyslnie z zewnetrzynch servicow zwraca dla obiektow null lub false w przypadku prymitywu
    //dla int 0
    //dla String null
    //dla kolekcji jest pusta kolekcja
    @InjectMocks
    private MessageSenderModified messageSenderModified;

    @Mock
    private MessageService messageService;

    @Mock
    private UserService userService;

    private Map<String, String> toSend;

    @BeforeEach
    void setUp() {
       toSend = new HashMap<>();
       toSend.put("grey", "hi grey");
       toSend.put("green", "hi green");
       toSend.put("red", "hi red");
    }

    @Test
    void shouldSendMessageToAllUsers() {
        // when
//        Mockito.when(userService
//                .existsByUserName(ArgumentMatchers.anyString()))
//                .thenReturn(true); // w tym miejsu pusisc test aby pokazac nullpointer
//
//        Mockito.when(userService.getUserByName("grey"))
//                .thenReturn(new User("grey","grey@gmail.com"));
//        Mockito.when(userService.getUserByName("red"))
//                .thenReturn(new User("red","red@gmail.com"));
//        Mockito.when(userService.getUserByName("green"))
//                .thenReturn(new User("green","green@gmail.com"));

        mockUserServiceExistsByUserNameTrue();

        mockUserServiceGetByUserName("grey", "grey@gmail.com");
        mockUserServiceGetByUserName("red", "red@gmail");
        mockUserServiceGetByUserName("green", "green@gmail");

//        Mockito.when(messageService.sendMessage(ArgumentMatchers.anyString(), ArgumentMatchers.anyString()))
//                .thenReturn(true);
        mockMessageServiceSendMessageTrue();

        Statistics statistics = messageSenderModified.send(toSend);
        //then
        assertThat(statistics.getSuccess()).isEqualTo(3);
        assertThat(statistics.getFailure()).isEqualTo(0);
    }

    @Test
    void shouldNotSendMessagesToAnyUser() {
        // when
//        Mockito.when(userService.existsByUserName(ArgumentMatchers.anyString()))
//                .thenReturn(false);
        mockUserServiceExistsByUserNameFalse();

        Statistics statistics = messageSenderModified.send(toSend);
        //then
        assertThat(statistics.getSuccess()).isEqualTo(0);
        assertThat(statistics.getFailure()).isEqualTo(3);
    }

    @Test
    void shouldNotSendMessagesToAnyUserWhenMessageServiceFailure() {
        // when
//        Mockito.when(userService.existsByUserName(ArgumentMatchers.anyString()))
//                .thenReturn(true);
//
//        Mockito.when(userService.getUserByName("grey"))
//                .thenReturn(new User("grey","grey@gmail.com"));
//        Mockito.when(userService.getUserByName("red"))
//                .thenReturn(new User("red","red@gmail.com"));
//        Mockito.when(userService.getUserByName("green"))
//                .thenReturn(new User("green","green@gmail.com"));

        mockUserServiceExistsByUserNameTrue();

        mockUserServiceGetByUserName("grey", "grey@gmail.com");
        mockUserServiceGetByUserName("red", "red@gmail");
        mockUserServiceGetByUserName("green", "green@gmail");


//        Mockito.when(messageService.sendMessage(ArgumentMatchers.anyString(), ArgumentMatchers.anyString()))
//                .thenReturn(false);

        mockMessageServiceSendMessageFalse();

        Statistics statistics = messageSenderModified.send(toSend);
        //then
        assertThat(statistics.getSuccess()).isEqualTo(0);
        assertThat(statistics.getFailure()).isEqualTo(3);
    }

    private void mockUserServiceGetByUserName(String userName, String email){
        Mockito.when(userService.getUserByName(userName))
                .thenReturn(new User(userName, email));
    }


    private void mockUserServiceExistsByUserNameTrue(){
        Mockito.when(userService.existsByUserName(ArgumentMatchers.anyString()))
                .thenReturn(true);
    }
    private void mockUserServiceExistsByUserNameFalse(){
        Mockito.when(userService.existsByUserName(ArgumentMatchers.anyString()))
                .thenReturn(false);
    }

    private void mockMessageServiceSendMessageFalse(){
        Mockito.when(messageService.sendMessage(ArgumentMatchers.anyString(), ArgumentMatchers.anyString()))
                .thenReturn(false);
    }

    private void mockMessageServiceSendMessageTrue(){
        Mockito.when(messageService.sendMessage(ArgumentMatchers.anyString(), ArgumentMatchers.anyString()))
                .thenReturn(true);
    }
}