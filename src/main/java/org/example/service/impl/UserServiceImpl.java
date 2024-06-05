package org.example.service.impl;

import lombok.RequiredArgsConstructor;
import org.example.dto.User;
import org.example.entity.UserEntity;
import org.example.repository.UserRepository;
import org.example.service.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class UserServiceImpl implements UserService {
    final UserRepository repository;
    final ModelMapper mapper;
    @Override
    public void addUser(User user) {
        UserEntity entity = mapper.map(user,UserEntity.class);
        repository.save(entity);

    }

    @Override
    public List<UserEntity> getUsers() {
        return (List<UserEntity>) repository.findAll();
    }

    @Override
    public Boolean deleteUser(Long id) {
        if(repository.existsById(id)){
            repository.deleteById(id);
            return true;
        }else{
            return false;
        }
    }

    @Override
    public User getUserId(Long id) {
        Optional<UserEntity> byId = repository.findById(id);
        return mapper.map(byId, User.class);
    }
}
