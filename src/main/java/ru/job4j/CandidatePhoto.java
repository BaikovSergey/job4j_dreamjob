package ru.job4j;

public class CandidatePhoto {

    private int id;
    private String name;
    private int candidateId;

    public CandidatePhoto(String name) {
        this.name = name;
    }

    public CandidatePhoto(int id, String name, int candidateId) {
        this.id = id;
        this.name = name;
        this.candidateId = candidateId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCandidateId() {
        return candidateId;
    }

    public void setCandidateId(int candidateId) {
        this.candidateId = candidateId;
    }
}
