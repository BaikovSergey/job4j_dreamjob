package ru.job4j;

import java.util.Collection;
import java.util.Map;

public interface Store {
    Collection<Post> findAllPosts();

    Collection<Candidate> findAllCandidates();

    Collection<User> findAllUsers();

    Map<Integer, String> findAllCandidatePhoto();

    void savePost(Post post);

    void saveCandidate(Candidate candidate);

    void saveUser(User user);

    void saveCandidatePhoto(CandidatePhoto photo, String candidateId);

    Post findPostById(int id);

    Candidate findCandidateById(int id);

    User findUserById(int id);

    User findUserByEmail(String email);

    CandidatePhoto getPhotoByCandidateId(int id);
}
