package ru.itis.antonov.images.site.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import ru.itis.antonov.images.site.models.User;

public interface UserRepository extends JpaRepository<User, Long> {
}
