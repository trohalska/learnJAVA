package collections.mapExeptions;

import java.util.*;

public class UserRepository {
    private Set<User> users = new HashSet<>();

    void addUser(User user) {
        users.add(user);
    }

    void validateUser(User user) {
        if (!user.isValid()) users.remove(user);
    }

    void validateAll() {
        for (User user : users) {
            validateUser(user);
            System.out.println(user.get());
        }
    }

}

/** создаем итератор и по нему идем,
 * но удаляем элемент не через итератор, а через методы коллекции,
 * поэтому на следующем после удаления шаге мы получим Exception*/
