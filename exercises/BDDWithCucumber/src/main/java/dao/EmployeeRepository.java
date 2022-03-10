package dao;

import java.io.IOException;


public interface EmployeeRepository {

    int STARTING_ID = 123;

    Employee create(String name, int age, double salary) throws IOException;

    int size();

    Employee find(int id) throws IOException;

    void delete(Employee emp) throws IOException;

    void update(Employee emp) throws IOException;

    void close() throws IOException;
}
