package ru.pcs.web.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.pcs.web.models.User;

public interface UsersRepository extends JpaRepository<User, Long> {
}
