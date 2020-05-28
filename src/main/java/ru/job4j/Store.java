package ru.job4j;

import ru.job4j.servlets.CandidatePhoto;

import java.util.Collection;

public interface Store {
    Collection<Post> findAllPosts();

    Collection<Candidate> findAllCandidates();

    Collection<User> findAllUsers();

    void savePost(Post post);

    void saveCandidate(Candidate candidate);

    void saveUser(User user);

    void saveCandidatePhoto(CandidatePhoto photo);

    Post findPostById(int id);

    Candidate findCandidateById(int id);

    User findUserById(int id);

    User findUserByEmail(String email);

    String getPhotoNameById(int id);
}
