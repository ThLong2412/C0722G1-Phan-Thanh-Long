package exersice.mvc.ss1_haiTT.service;

import java.io.IOException;

public interface IStudentService {
    void addStudent();

    void displayAllStudent();

    void removeStudent();

    void findStudent();

    void sortStudent();

    void readStudent() throws IOException;

    void writeStudent() throws IOException;
}
