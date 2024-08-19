package com.example.basiccrud.service.impl;

import com.example.basiccrud.config.ModelMapperConfig;
import com.example.basiccrud.dto.UserDto;
import com.example.basiccrud.entity.User;
import com.example.basiccrud.repository.UserRepository;
import com.example.basiccrud.service.UserService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service // Spring bu proje ayağa kalarken bu sınıftan bir instance oluşturarak IOC içerisinde tutuyor
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final ModelMapper modelMapper;

    @Override
    public UserDto createUser(UserDto userDto) {
        User user = modelMapper.map(userDto, User.class);
        user.setCreatedAt(new Date());
        user.setCreatedBy("Admin");
        return modelMapper.map(userRepository.save(user), UserDto.class);
    }

    @Override
    public List<UserDto> getUser() {
        List<User> users = userRepository.findAll();
        List<UserDto> dtos =users.stream().map(User -> modelMapper.map(User, UserDto.class)).collect(Collectors.toList());
        return dtos;
    }

    @Override
    public UserDto getUser(Long id) {
        Optional<User> user = userRepository.findById(id);

        if (user.isPresent()) { //eğer id si olan kayıt varsa
            return modelMapper.map(user.get(), UserDto.class);
        }
        return null;
    }

    @Override
    public UserDto updateUser(Long id, UserDto user) {
        Optional<User> resaultUser = userRepository.findById(id);
        if (resaultUser.isPresent()) { //eğer id si olan kayıt varsa
            resaultUser.get().setFirstName(user.getFirstName()); // parametre olrak gelen nesnemizi güncelle
            resaultUser.get().setLastName(user.getLastName());
            resaultUser.get().setUpdateAt(new Date());
            resaultUser.get().setUpdateBy("Admin");
            return modelMapper.map(userRepository.save(resaultUser.get()),UserDto.class); //göndereceğimiz nesnede id değeri olduğu için spring bunu güncelliyor
        }
        return null;
    }

    @Override
    public Boolean deleteUser(Long id) {
        Optional<User> user = userRepository.findById(id);

        if (user.isPresent()) { //eğer id si olan kayıt varsa
            userRepository.deleteById(id);
            return true;
        }
        return null;
    }
}
