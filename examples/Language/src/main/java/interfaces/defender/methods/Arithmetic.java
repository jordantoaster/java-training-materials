package interfaces.defender.methods;

interface Arithmetic {
    default int add(int no1, int no2) {
        return no1 + no2;
    }

    default int subtract(int no1, int no2) {
        return no1 - no2;
    }

    default int multiply(int no1, int no2) {
        return no1 * no2;
    }

    double divide(int no1, int no2);
} 
