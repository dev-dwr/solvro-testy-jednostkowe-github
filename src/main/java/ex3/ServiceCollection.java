package ex3;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class ServiceCollection {
    private static final List<User> users = new ArrayList<>();
    protected static final boolean ACTIVE = true;
    protected static final boolean INACTIVE = false;

    //static block is used to initialize static variables
    //the block of code is executed when the class is loaded in the memory
    //we can have multiple static blocks
    static{
        users.add(new User("orange", ACTIVE));
        users.add(new User("red", ACTIVE));
        users.add(new User("grey", INACTIVE));
        users.add(new User("black", INACTIVE));
        users.add(new User("white", ACTIVE));
    }

    public List<User> getAllUsers(){
        return users;
    }

    public List<User> getAllActiveUsers(){
        return users.stream().filter(user -> user.isActive()).collect(Collectors.toList());
    }
    public List<User> getAllInActiveUsers(){
        return users.stream().filter(user -> !user.isActive()).collect(Collectors.toList());
    }
}
