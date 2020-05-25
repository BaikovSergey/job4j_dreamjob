package ru.job4j;

import java.util.Collection;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

public class MemStore {
    private static final MemStore INST = new MemStore();

    private Map<Integer, Post> posts = new ConcurrentHashMap<>();

    private Map<Integer, Candidate> candidates = new ConcurrentHashMap<>();

    private static AtomicInteger POST_ID = new AtomicInteger(4);

    private static AtomicInteger CANDIDATE_ID = new AtomicInteger(4);

    private MemStore() {
        posts.put(1, new Post(1, "Junior Java Job", ""));
        posts.put(2, new Post(2, "Middle Java Job", ""));
        posts.put(3, new Post(3, "Senior Java Job", ""));
        candidates.put(1, new Candidate(1, "Junior Java", "junior"));
        candidates.put(2, new Candidate(2, "Middle Java", "middle"));
        candidates.put(3, new Candidate(3, "Senior Java", "senior"));
    }


    public static MemStore instOf() {
        return INST;
    }

    public Collection<Post> findAllPosts() {
        return posts.values();
    }

    public Collection<Candidate> findAllCandidates() {
        return candidates.values();
    }

    public void savePost(Post post) {
        post.setId(POST_ID.incrementAndGet());
        posts.put(post.getId(), post);
    }

    public void saveCandidate(Candidate candidate) {
        candidate.setId(CANDIDATE_ID.incrementAndGet());
        candidates.put(candidate.getId(), candidate);
    }
}
