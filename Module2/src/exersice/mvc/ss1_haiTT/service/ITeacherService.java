package exersice.mvc.ss1_haiTT.service;

import java.io.IOException;

public interface ITeacherService {
    void addTeacher();

    void displayAllTeacher();

    void removeTeacher();

    void findTeacher();

    void sortTeacher();

    void readTeacher() throws IOException;

    void writeTeacher() throws  IOException;
}
