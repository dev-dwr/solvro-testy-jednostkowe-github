package ex4;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

//bardziej zyciowy scenariusz testow
class ServiceCollectionModifiedTest {


    private static final boolean ACTIVE = true;
    private static final boolean INACTIVE = false;

    private ServiceCollectionModified serviceCollection;

    @BeforeEach
    void setUp() {
        List<User> users = new ArrayList<>();
        users.add(new User("orange", ACTIVE));
        users.add(new User("red", ACTIVE));
        users.add(new User("grey", INACTIVE));
        users.add(new User("black", INACTIVE));
        users.add(new User("white", ACTIVE));
        //lub
        //List<User> users2 = Arrays.asList(new User("a", false),
        //new User("b", true));

        serviceCollection = new ServiceCollectionModified(users);
    }

    @Test
    void shouldGetAllUsers() {
        // when
        List<User> allUsers = serviceCollection.getUsers();
        //then
        assertThat(allUsers)
                .isNotNull()
                .hasSize(5);
    }
}