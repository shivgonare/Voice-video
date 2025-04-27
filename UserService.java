package com.example.demo.service;

import com.example.demo.dto.UserDTO;
import java.util.List;

public interface UserService {
    UserDTO createUser(UserDTO user);
    List<UserDTO> getAllUsers();
    UserDTO updateUser(Long id, UserDTO userDTO);
	void deleteUser(Long id); 
}
