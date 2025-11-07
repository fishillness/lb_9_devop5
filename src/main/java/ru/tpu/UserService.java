package ru.tpu;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User getUser(int id){
        return userRepository.findById(id)
                .orElseThrow(() -> new UserNotFoundException("User not found: " + id));
    }

    public int createUser(String name) {
        User user = new User();
        user.setName(name);
        return userRepository.saveAndFlush(user).getId();
    }

    public void updateUser(User user){
        if (!userRepository.existsById(user.getId())){
            throw new UserNotFoundException("User not found: " + user.getId());
        }
        userRepository.save(user);
    }

    public void deleteUser(int id){
        if (!userRepository.existsById(id)) {
            throw new UserNotFoundException("User not found: " + id);
        }
        userRepository.deleteById(id);
    }
}
