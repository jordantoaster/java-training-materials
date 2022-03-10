package dao;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.HashMap;

public class FileBasedEmployeeRepository implements EmployeeRepository {
    private HashMap<Integer,Long> locations;
    private RandomAccessFile file;
    private int nextId;

    public FileBasedEmployeeRepository(String filePath) throws IOException {
        super();
        locations = new HashMap<Integer,Long>();
        file = new RandomAccessFile(filePath,"rw");
        nextId = STARTING_ID;
        if(file.length() > 0) {
            findLocationsOfExistingRecords();
        }
    }
    private void findLocationsOfExistingRecords() throws IOException {
        while(file.getFilePointer() < file.length()) {
            int tmpId = file.readInt();
            //An id of -1 signifies a deleted employee
            if(tmpId > 0) {
                locations.put(tmpId, file.getFilePointer() - 4);
                if(tmpId > nextId) {
                    nextId = tmpId;
                }
            }
            //Skip the rest of the record
            file.readUTF();
            file.readInt();
            file.readDouble();
        }
        nextId++;
    }
    public Employee create(String name, int age, double salary) throws IOException {
        Employee tmp =  new Employee(nextId++,name,age,salary);
        locations.put(tmp.getId(),file.length());
        writeRecordToFile(tmp);
        return tmp;
    }

    @Override
    public int size() {
        return locations.size();
    }

    public Employee find(int id) throws IOException {
        if(!locations.containsKey(id)) {
            return null;
        } else {
            long location = locations.get(id);
            return readRecordFromFile(location);
        }
    }
    private void writeRecordToFile(Employee tmp) throws IOException {
        file.seek(file.length());
        file.writeInt(tmp.getId());
        file.writeUTF(tmp.getName());
        file.writeInt(tmp.getAge());
        file.writeDouble(tmp.getSalary());
    }
    private Employee readRecordFromFile(long location) throws IOException {
        file.seek(location);
        int tmpId = file.readInt();
        String tmpName = file.readUTF();
        int tmpAge = file.readInt();
        double tmpSalary = file.readDouble();
        return new Employee(tmpId,tmpName,tmpAge,tmpSalary);
    }
    public void delete(Employee emp) throws IOException {
        long location = locations.get(emp.getId());
        file.seek(location);
        file.writeInt(-1);
        locations.remove(emp.getId());
    }
    public void update(Employee emp) throws IOException {
        delete(emp);
        writeRecordToFile(emp);
    }
    public void close() throws IOException {
        file.close();
    }
}
