package com.exam.exam.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.exam.exam.dto.UserDTO;
import com.exam.exam.model.User;
import com.exam.exam.repository.UserRepository;

@Service
public class UserService {
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    // Create a new user
    public void createUser(UserDTO userDTO) {
        User user = new User();
        user.setName(userDTO.getName());
        user.setPhone(userDTO.getPhone());
        user.setEmail(userDTO.getEmail());
        userRepository.save(user);
    }

    // Get a user by ID
    public UserDTO getUserDTOById(Long id) {
        Optional<User> user = userRepository.findById(id);
        if (user.isPresent()) {
            UserDTO userDTO = new UserDTO();
            userDTO.setName(user.get().getName());
            userDTO.setPhone(user.get().getPhone());
            userDTO.setEmail(user.get().getEmail());
            return userDTO;
        }
        return null;
    }

    // Update an existing user
    public void updateUser(Long id, UserDTO userDTO) {
        Optional<User> userOptional = userRepository.findById(id);
        if (userOptional.isPresent()) {
            User user = userOptional.get();
            user.setName(userDTO.getName());
            user.setPhone(userDTO.getPhone());
            user.setEmail(userDTO.getEmail());
            userRepository.save(user);
        }
    }

    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }
}
