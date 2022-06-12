package ex4;

import java.util.List;
import java.util.stream.Collectors;

public class ServiceCollectionModified {

    private final List<User> users;

    public ServiceCollectionModified(List<User> users) {
        this.users = users;
    }

    public List<User> getUsers() {
        return users;
    }

    public List<User> getAllActiveUsers(){
        return users.stream().filter(user -> user.isActive()).collect(Collectors.toList());
    }
    public List<User> getAllInActiveUsers(){
        return users.stream().filter(user -> !user.isActive()).collect(Collectors.toList());
    }
}
