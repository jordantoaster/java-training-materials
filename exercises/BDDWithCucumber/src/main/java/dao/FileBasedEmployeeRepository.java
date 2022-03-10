package dao;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.HashMap;

public class FileBasedEmployeeRepository implements EmployeeRepository {
    private HashMap<Integer, Long> locations;
    private RandomAccessFile file;
    private int nextId;

    public FileBasedEmployeeRepository(String filePath) throws IOException {
        super();
        locations = new HashMap<>();
        file = new RandomAccessFile(filePath, "rw");
        nextId = STARTING_ID;
        if (file.length() > 0) {
            findLocationsOfExistingRecords();
        }
    }

    private void findLocationsOfExistingRecords() throws IOException {
    }

    public Employee create(String name, int age, double salary) throws IOException {
        return null;
    }

    @Override
    public int size() {
        return locations.size();
    }

    public Employee find(int id) throws IOException {
        return null;
    }

    public void delete(Employee emp) throws IOException {
    }

    public void update(Employee emp) throws IOException {
    }

    public void close() throws IOException {
        file.close();
    }
}
