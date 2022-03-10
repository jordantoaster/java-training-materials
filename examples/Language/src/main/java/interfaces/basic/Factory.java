package interfaces.basic;

public class Factory {
    public static Transaction buildTransaction(String connectionString) {
        if (connectionString.startsWith("sqlserver")) {
            return new SqlServerTransaction();
        } else if (connectionString.startsWith("oracle")) {
            return new OracleTransaction();
        } else {
            return null;
        }
    }
}
