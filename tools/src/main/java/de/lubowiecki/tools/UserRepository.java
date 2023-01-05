package de.lubowiecki.tools;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

public class UserRepository {

	private List<User> users = new ArrayList<>();
	
	public UserRepository() {
		users.add(new User(1, "Peter", "Parker"));
		users.add(new User(2, "Carol", "Danvers"));
		users.add(new User(3, "Bruce", "Banner"));
	}
	
	public List<User> findAll() {
		return Collections.unmodifiableList(users);
	}
	
	public Optional<User> findById(int id) {
		User u = users.get(id - 1);
		
		if(u == null)
			return Optional.empty();
		
		return Optional.of(u);
	}
}
