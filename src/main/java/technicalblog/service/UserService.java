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

    public boolean login(User user) {
        return user.getUsername().equals("validUser");
    }

    @SuppressWarnings("unused")
    public void registerUser(User newUser) {
        postRepository.registerUser(newUser);
    }
}
