package com.swe206.group_two.backend.user;

import java.util.List;
import java.util.Optional;

public interface UserService {
    public abstract List<User> getAllUsers();

    public abstract Optional<User> getUserById(Integer id);

    public abstract Optional<User> getUserByEmail(String email);
}
