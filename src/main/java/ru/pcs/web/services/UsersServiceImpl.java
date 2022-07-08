package ru.pcs.web.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.pcs.web.models.User;
import ru.pcs.web.repositories.UsersRepository;

import java.util.List;

@Service
public class UsersServiceImpl implements UsersService {

    private final UsersRepository usersRepository;

    @Autowired
    public UsersServiceImpl(UsersRepository usersRepository) {
        this.usersRepository = usersRepository;
    }

    @Override
    public void save(User user) {
        usersRepository.save(user);
    }

    @Override
    public List<User> getAllUsers() {
        return usersRepository.findAll();
    }

    @Override
    public void update(User user) {
        usersRepository.save(user);
    }

    @Override
    public void removeUserById(Long id) {
        usersRepository.delete(usersRepository.getReferenceById(id));
    }

    @Override
    public User getUserById(Long id) {
        return usersRepository.getReferenceById(id);
    }
}
