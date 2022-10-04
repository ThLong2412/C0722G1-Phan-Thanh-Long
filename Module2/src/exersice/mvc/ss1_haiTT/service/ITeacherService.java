package exersice.mvc.ss1_haiTT.service;

import java.io.IOException;

public interface ITeacherService {
    void addTeacher() throws IOException;

    void displayAllTeacher() throws IOException;

    void removeTeacher() throws IOException;

    void findTeacher() throws IOException;

    void sortTeacher() throws IOException;

    void readTeacher() throws IOException;

    void writeTeacher() throws  IOException;
}
