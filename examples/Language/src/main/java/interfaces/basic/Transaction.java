package interfaces.basic;

public interface Transaction {
    void start();

    void add(Resource r);

    void commit();

    void rollback();
}
