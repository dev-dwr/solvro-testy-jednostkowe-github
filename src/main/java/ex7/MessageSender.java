package ex7;



import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MessageSender { //Testowanie klasy jako jednostki
    private final List<String> existingUsers = Arrays.asList("red", "black", "grey");
    private final Map<String, String> toSend = new HashMap<>();

    public Statistics send() {
        Statistics statistic = new Statistics();

        for (Map.Entry<String, String> entry : toSend.entrySet()) {
            boolean send = sendMessage(entry.getKey(), entry.getValue());
            statistic.collect(send);
        }
        return statistic;
    }


    public void addMessage(String user, String msg) {
        toSend.put(user, msg);
    }

    private boolean sendMessage(String user, String msg) {
        if (existingUsers.contains(user)) {
            System.out.println("Send msg to " + user + " message: " + msg);
            return true;
        }
        return false;
    }
}
