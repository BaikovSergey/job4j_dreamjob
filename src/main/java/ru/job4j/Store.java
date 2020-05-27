package ru.job4j;

import java.util.Collection;

public interface Store {
    Collection<Post> findAllPosts();

    Collection<Candidate> findAllCandidates();

    Collection<User> findAllUsers();

    void savePost(Post post);

    void saveCandidate(Candidate candidate);

    void saveUser(User user);

    Post findPostById(int id);

    Candidate findCandidateById(int id);

    User findUserById(int id);

    User findUserByEmail(String email);

}
