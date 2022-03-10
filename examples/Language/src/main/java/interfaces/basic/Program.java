package interfaces.basic;

public class Program {
	public static void main(String[] args) {
		System.out.println("----- Oracle Transaction -----");
		Transaction t1 = Factory.buildTransaction("oracle:some_server:TestDB");
		t1.start();
		t1.add(new Resource());
		t1.add(new Resource());
		t1.commit();
		
		System.out.println("----- SQL Server Transaction -----");
		Transaction t2 = Factory.buildTransaction("sqlserver:some_server:TestDB");
		t2.start();
		t2.add(new Resource());
		t2.add(new Resource());
		t2.rollback();

	}
}
