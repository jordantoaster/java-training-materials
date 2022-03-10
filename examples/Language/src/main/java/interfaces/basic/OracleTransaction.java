package interfaces.basic;

public class OracleTransaction implements Transaction {
    public void add(Resource r) {
        System.out.println("\tOracleTransaction.add");
    }

    public void commit() {
        System.out.println("\tOracleTransaction.commit");
    }

    public void rollback() {
        System.out.println("\tOracleTransaction.rollback");
    }

    public void start() {
        System.out.println("\tOracleTransaction.start");
    }
}
