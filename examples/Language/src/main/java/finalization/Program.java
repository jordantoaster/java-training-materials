package finalization;

public class Program {
    public static void main(String[] args) throws Exception {
		for(int x=1;x<=100;x++) {
			System.out.println("------------ Iteration " + x + " -------------");
			Sample[] testArray = new Sample[10000];
			for(int i=0; i<testArray.length; i++) {
				testArray[i] = new Sample(x,i);
			}
			Thread.sleep(100);
		}
	}
}
