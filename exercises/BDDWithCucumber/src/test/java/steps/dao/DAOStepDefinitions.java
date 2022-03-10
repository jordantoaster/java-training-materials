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

        Then("^there are (\\d+) employees present$", (Integer numEmployees) -> {
            assertEquals(numEmployees, dao.size());
        });
    }
}
