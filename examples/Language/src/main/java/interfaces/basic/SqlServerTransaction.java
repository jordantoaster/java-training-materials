package interfaces.basic;

public class SqlServerTransaction implements Transaction {
    public void add(Resource r) {
        System.out.println("\tSqlServerTransaction.add");
    }

    public void commit() {
        System.out.println("\tSqlServerTransaction.commit");
    }

    public void rollback() {
        System.out.println("\tSqlServerTransaction.rollback");
    }

    public void start() {
        System.out.println("\tSqlServerTransaction.start");
    }
}
