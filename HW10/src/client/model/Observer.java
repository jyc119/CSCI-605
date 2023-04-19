package client.model;

public interface Observer<Subject1, Subject2> {

    void update(Subject1 subject1, Subject2 subject2);
}
