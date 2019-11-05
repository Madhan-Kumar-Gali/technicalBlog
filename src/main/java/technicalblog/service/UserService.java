package technicalblog.service;

import org.springframework.stereotype.Service;
import technicalblog.model.User;
import technicalblog.repository.PostRepository;

@Service
public class UserService {

    private PostRepository postRepository;

    public UserService(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    public User login(User user) {
        User existingUser = postRepository.checkUser(user.getUsername(), user.getPassword());
        if (existingUser != null) {
            return existingUser;
        } else {
            return null;
        }
    }

    @SuppressWarnings("unused")
    public void registerUser(User newUser) {
        postRepository.registerUser(newUser);
    }
}
