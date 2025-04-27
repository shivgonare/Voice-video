package com.example.demo.service.impl;

import com.example.demo.dto.UserDTO;
import com.example.demo.model.User;
import com.example.demo.repository.UserRepository;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {
    
    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDTO createUser(UserDTO userDTO) {
        User user = new User();
        user.setUsername(userDTO.username);
        user.setEmail(userDTO.email);
        User saved = userRepository.save(user);
        userDTO.id = saved.getId();
        return userDTO;
    }

    @Override
    public List<UserDTO> getAllUsers() {
        return userRepository.findAll().stream().map(user -> {
            UserDTO dto = new UserDTO();
            dto.id = user.getId();
            dto.username = user.getUsername();
            dto.email = user.getEmail();
            return dto;
        }).collect(Collectors.toList());
    }

    @Override
    public UserDTO updateUser(Long id, UserDTO userDTO) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("User not found with id " + id));

        // Update the fields
        user.setUsername(userDTO.username);
        user.setEmail(userDTO.email);

        // Save the updated user
        User updatedUser = userRepository.save(user);

        // Map updated data back to DTO
        userDTO.id = updatedUser.getId();
        return userDTO;
    }
    
    
    
    @Override
    public void deleteUser(Long id) {
        userRepository.deleteById(id); // simple delete
    }
}
