package ru.pcs.web.services;

import ru.pcs.web.models.User;

import java.util.List;

public interface UsersService {
    void save(User user);

    List<User> getAllUsers();

    void update(User user);

    void removeUserById(Long id);

    User getUserById(Long id);
}
