package ru.job4j.servlets;

public class CandidatePhoto {

    private int id;
    private String name;
    private int CandidateId;

    public CandidatePhoto(String name) {
        this.name = name;
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
        return CandidateId;
    }

    public void setCandidateId(int candidateId) {
        CandidateId = candidateId;
    }
}
