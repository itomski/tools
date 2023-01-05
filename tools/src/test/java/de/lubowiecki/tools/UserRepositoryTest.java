package de.lubowiecki.tools;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

class UserRepositoryTest {

	public static UserRepository repo;
	
	@BeforeAll
	static void setUpBeforeClass() {
		repo = new UserRepository();
	}

	@Test
    void has_items_in_List() {
        // Hamcrest bietet zusätzlich Assert-Methoden für komplexere Tests
        assertThat(repo.findAll(), hasItems(new User(1, "Peter", "Parker")));
    }

    @Test
    void size_of_List() {
        // Hamcrest bietet zusätzlich Assert-Methoden für komplexere Tests
        assertThat(repo.findAll(), hasSize(3));
    }
    
    @Test
    void item_instanceof_User() {
        assertThat(repo.findById(1), instanceOf(User.class));
    }
    
    @Test
    void item_has_property() {
        assertThat(repo.findById(1), hasProperty("firstname", equalTo("Peter")));
    }
}
