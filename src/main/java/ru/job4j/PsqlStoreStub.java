package ru.job4j;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class PsqlStoreStub implements Store {

    private final Map<Integer, Candidate> candidates = new HashMap<>();

    private final Map<Integer, Post> posts = new HashMap<>();

    private final Map<Integer, User> users = new HashMap<>();

    private int candidateId = 0;

    private int postId = 0;

    private int userId = 0;

    @Override
    public Collection<Post> findAllPosts() {
        return new ArrayList<Post>(this.posts.values());
    }

    @Override
    public Collection<Candidate> findAllCandidates() {
        return new ArrayList<Candidate>(this.candidates.values());
    }

    @Override
    public Collection<User> findAllUsers() {
        return new ArrayList<User>(this.users.values());
    }

    @Override
    public Map<Integer, String> findAllCandidatePhoto() {
        return null;
    }

    @Override
    public Map<Integer, String> findAllCities() {
        return null;
    }

    @Override
    public void savePost(Post post) {
        post.setId(this.postId++);
        this.posts.put(post.getId(), post);
    }

    @Override
    public void saveCandidate(Candidate candidate) {
        candidate.setId(this.candidateId++);
        this.candidates.put(candidate.getId(), candidate);
    }

    @Override
    public void saveUser(User user) {
        user.setId(this.userId++);
        this.users.put(user.getId(), user);
    }

    @Override
    public void saveCandidatePhoto(CandidatePhoto photo, String candidateId) {

    }

    @Override
    public Post findPostById(int id) {
        return null;
    }

    @Override
    public Candidate findCandidateById(int id) {
        return null;
    }

    @Override
    public User findUserById(int id) {
        return null;
    }

    @Override
    public User findUserByEmail(String email) {
        return null;
    }

    @Override
    public CandidatePhoto getPhotoByCandidateId(int id) {
        return null;
    }
}
