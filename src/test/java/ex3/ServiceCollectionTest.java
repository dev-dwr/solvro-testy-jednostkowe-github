package ex3;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class ServiceCollectionTest {

    private final ServiceCollection serviceCollection = new ServiceCollection();

    @Test
    void shouldGetAllUsers() {
        // when
        List<User> allUsers = serviceCollection.getAllUsers();
        //then
        assertNotNull(allUsers);

        assertEquals(5, allUsers.size());
        assertThat(allUsers).hasSize(5);
        assertThat(allUsers)
                .isNotNull()
                .hasSize(5);
    }

    @Test
    void shouldGetAllActiveUsers() {
        //when
        List<User> allActiveUsers = serviceCollection.getAllActiveUsers();

        //then
        assertNotNull(allActiveUsers);
        assertThat(allActiveUsers).isNotNull();

        //OK
        allActiveUsers.forEach(user -> assertTrue(user.isActive()));

        //Better with AssertJ
        //metoda extracting - pozwala nam wyekstrahowac konkretne pole z jakiegos obiektu
        assertThat(allActiveUsers).extracting("active").containsOnly(true);

        assertThat(allActiveUsers).hasSize(3);
    }

    @Test
    void shouldGetAllInactiveUsers() {
        // when
        List<User> allInActiveUsers = serviceCollection.getAllInActiveUsers();

        //then
        assertThat(allInActiveUsers).isNotNull();
        assertThat(allInActiveUsers).extracting("active").containsOnly(false);
        assertThat(allInActiveUsers).hasSize(2);
    }

    @Test
    void shouldContainsSpecificInActiveUsersInOrder() {
        // when
        List<User> allInActiveUsers = serviceCollection.getAllInActiveUsers();

        //then
        assertThat(allInActiveUsers).isNotNull();
        assertThat(allInActiveUsers).extracting("active").containsOnly(false);

        //containsExactly sprawdza czy w zwroconej liscie sa takie same jak te wartosci, ktore podamy jako parametr
        assertThat(allInActiveUsers).extracting("name")
                .containsExactly("grey", "black");

        assertThat(allInActiveUsers).hasSize(2);
    }

}