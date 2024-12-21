package mk.ukim.finki.wp.lab.repository.inmemory;

import mk.ukim.finki.wp.lab.bootstrap.DataInit;
import mk.ukim.finki.wp.lab.model.User;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public class InMemoryUserRepository {
    public Optional<User> findByUsername(String username) {
        return DataInit.users.stream()
                .filter(user -> user.getUsername().equals(username))
                .findFirst();
    }

    public Optional<User> findByUsernameAndPassword(String username, String password) {
        return DataInit.users.stream()
                .filter(user -> user.getUsername().equals(username) && user.getPassword().equals(password))
                .findFirst();
    }

    public User saveOrUpdate(User user) {
        DataInit.users.removeIf(existingUser -> existingUser.getUsername().equals(user.getUsername()));
        DataInit.users.add(user);
        return user;
    }

    public void deleteByUsername(String username) {
        DataInit.users.removeIf(user -> user.getUsername().equals(username));
    }
}
