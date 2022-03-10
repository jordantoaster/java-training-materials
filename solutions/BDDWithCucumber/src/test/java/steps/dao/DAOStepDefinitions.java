package steps.dao;

import dao.Employee;
import dao.EmployeeRepository;
import dao.FileBasedEmployeeRepository;
import io.cucumber.java8.En;

import java.io.File;

import static org.junit.jupiter.api.Assertions.*;

public class DAOStepDefinitions implements En {
    private static final String FILE_NAME = "data" + File.separator + "records.data";

    private EmployeeRepository dao;

    public DAOStepDefinitions() {

        Given("^a new DAO$", () -> {
            File f = new File(FILE_NAME);
            if (f.exists()) {
                assertTrue(f.delete());
            }
            dao = new FileBasedEmployeeRepository(FILE_NAME);
        });

        When("^we add (\\w+) of age (\\d+) earning (\\d+)$", (String name, Integer age, Double salary) -> {
            dao.create(name, age, salary);
        });

        When("^we remove employee (\\d+)$", (Integer id) -> {
            Employee emp = dao.find(id);
            dao.delete(emp);
        });

        When("^we recreate the DAO$", () -> {
            dao.close();
            dao = new FileBasedEmployeeRepository(FILE_NAME);
        });

        Then("^there are (\\d+) employees present$", (Integer numEmployees) -> {
            assertEquals(numEmployees, dao.size());
        });

        Then("^(\\d+) is (\\w+) of age (\\d+) earning (\\d+)$$", (Integer id, String name, Integer age, Double salary) -> {
            Employee emp = dao.find(id);
            assertEquals(name, emp.getName());
            assertEquals(age, emp.getAge());
            assertEquals(salary, emp.getSalary());
        });

        Then("^(\\d+) cannot be found$", (Integer id) -> {
            assertNull(dao.find(id));
        });
    }
}
