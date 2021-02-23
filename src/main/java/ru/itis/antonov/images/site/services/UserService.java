package ru.itis.antonov.images.site.services;

import ru.itis.antonov.images.site.models.User;

public interface UserService {
    User findById(long id);
}
