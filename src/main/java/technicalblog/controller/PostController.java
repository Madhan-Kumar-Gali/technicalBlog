package technicalblog.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import technicalblog.model.Post;
import technicalblog.model.User;
import technicalblog.service.PostService;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class PostController {

    private PostService postService;

    @Autowired
    public PostController(PostService postService) {
        this.postService = postService;
    }

    @RequestMapping("posts")
    public String getUserPost(Model model) {
        List<Post> posts = postService.getAllPosts();
        model.addAttribute("posts", posts);
        return "posts";
    }

    @RequestMapping("/posts/newpost")
    public String newPost() {
        return "posts/create";
    }

    @RequestMapping(value = "/posts/create", method = RequestMethod.POST)
    public String createPost(Post newPost, HttpSession session) {
        User user = (User) session.getAttribute("loggedUser");
        newPost.setUser(user);
        postService.createPost(newPost);
        return "redirect:/posts";
    }

    @RequestMapping(value = "/editPost", method = RequestMethod.GET)
    public String editPost(@RequestParam(name="postId") Integer postId, Model model) {
        Post post = postService.getPost(postId);
        model.addAttribute("post",post);
        return "posts/edit";
    }

    @RequestMapping(method = RequestMethod.POST, value = "/editPost")
    public String editPostSubmit(@RequestParam(name="postId") Integer postId, Post updatedPost, HttpSession session) {
        updatedPost.setId(postId);
        User user = (User) session.getAttribute("loggedUser");
        updatedPost.setUser(user);
        postService.updatePost(updatedPost);
        return "redirect:/posts";
    }

    @RequestMapping(value = "/deletePost", method = RequestMethod.POST)
    public String deletePostSubmit(@RequestParam(name="postId") Integer postId) {
        postService.deletePost(postId);
        return "redirect:/posts";
    }
}
