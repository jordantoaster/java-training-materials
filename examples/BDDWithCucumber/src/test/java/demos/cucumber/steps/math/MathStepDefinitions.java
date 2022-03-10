package demos.cucumber.steps.math;

import demos.cucumber.math.SimpleMath;
import io.cucumber.datatable.DataTable;
import io.cucumber.java8.En;

import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MathStepDefinitions implements En {
    private SimpleMath math;

    public MathStepDefinitions() {
        Given("^a math object created with (\\d+) and (\\d+)$",(Integer first, Integer second) -> {
            math = new SimpleMath(first,second);
        });
        Then("^addition produces (\\d+)$",(Integer expectedResult) -> {
            assertEquals(expectedResult.intValue(),math.add());
        });
        Then("^(subtraction|multiplication) produces ([-]?\\d+)$", (String operation, Integer expectedResult) -> {
            int actualResult;
            switch(operation) {
                case("subtraction"):
                    actualResult = math.subtract();
                    break;
                case("multiplication"):
                    actualResult = math.multiply();
                    break;
                default:
                    throw new RuntimeException("Unknown operation");
            }
            assertEquals(expectedResult.intValue(),actualResult);
        });
        Then("these are the totals produced", (DataTable table) -> {
            Map<String, Integer> data = table.asMap(String.class, Integer.class);
            for(Map.Entry<String, Integer> row : data.entrySet()) {
                switch(row.getKey()) {
                    case("addition"):
                        assertEquals(row.getValue().intValue(),math.add());
                        break;
                    case("subtraction"):
                        assertEquals(row.getValue().intValue(),math.subtract());
                        break;
                    case("multiplication"):
                        assertEquals(row.getValue().intValue(),math.multiply());
                        break;
                    default:
                        throw new RuntimeException("Unknown operation");
                }
            }
        });
        Then("these are the results produced",(DataTable table) -> {
            List<String> titleCells = table.cells().get(0);
            List<String> bodyCells = table.cells().get(1);
            for(int index=0;index<titleCells.size();index++) {
                int expectedResult = Integer.parseInt(bodyCells.get(index));
                switch(titleCells.get(index)) {
                    case("addition"):
                        assertEquals(expectedResult,math.add());
                        break;
                    case("subtraction"):
                        assertEquals(expectedResult,math.subtract());
                        break;
                    case("multiplication"):
                        assertEquals(expectedResult,math.multiply());
                        break;
                    default:
                        throw new RuntimeException("Unknown operation");
                }
            }
        });
    }
}
