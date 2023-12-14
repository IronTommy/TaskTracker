package service;

import model.User;
import payload.SignUpRequest;

public interface UserService {
    User registerUser(User user);

    void changePassword(Long userId, String newPassword);

    boolean existsByEmail(String email);

    void createUser(SignUpRequest signUpRequest);
}
