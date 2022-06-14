package ex8;

import ex8.model.Statistics;
import ex8.model.User;
import ex8.service.MessageService;
import ex8.service.UserService;

import java.util.HashMap;
import java.util.Map;

//nie ma roznicy tutaj czy metody sa zaimplmentowane czy tez nie, mockowanie metod dziala tak samo
public class MessageSenderModified {

    private final Map<String, String> toSend = new HashMap<>();
    private final UserService userService;
    private final MessageService messageService;

    public MessageSenderModified(UserService userService, MessageService messageService) {
        this.userService = userService;
        this.messageService = messageService;
    }

    public Statistics send(Map<String, String> toSend) {
        Statistics statistic = new Statistics();

        for (Map.Entry<String, String> entry : toSend.entrySet()) {
            boolean send = sendMessage(entry.getKey(), entry.getValue());
            statistic.collect(send);
        }
        return statistic;
    }

    private boolean sendMessage(String username, String msg) {
        if (userService.existsByUserName(username)) {
            User user = userService.getUserByName(username);
            return messageService.sendMessage(user.getEmail(), msg);
        }
        return false;
    }
}
