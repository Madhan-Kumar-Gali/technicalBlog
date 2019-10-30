package technicalblog.service;

import org.springframework.stereotype.Service;
import technicalblog.model.Post;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceUnit;
import javax.persistence.TypedQuery;

import java.util.List;

@Service
public class PostService {

    @PersistenceUnit(unitName = "techblog")
    private EntityManagerFactory emf;

    public PostService() {
        System.out.println("*** Post Service ***");
    }

    public List<Post> getAllPosts() {
        EntityManager em = emf.createEntityManager();
        TypedQuery<Post> query = em.createQuery("SELECT p from Post p", Post.class);
        return query.getResultList();
    }

    public List<Post> getOnePost() {

        EntityManager em = emf.createEntityManager();
        TypedQuery<Post> query = em.createQuery("SELECT p from Post p WHERE p.id = 4", Post.class);
        return query.getResultList();
    }

    public void createPost(Post newPost) {

    }

}
