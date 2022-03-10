package roman.numerals;

public enum Numeral {
    C(100),
    XC(90),
    L(50),
    XL(40),
    X(10),
    IX(9),
    V(5),
    IV(4),
    I(1);

    private int decimalValue;

    Numeral(int decimalValue) {
        this.decimalValue = decimalValue;
    }

    private int apply(int number, StringBuffer buffer) {
        int times = number / decimalValue;
        if (times > 0) {
            for (int i = 0; i < times; i++) {
                buffer.append(this.toString());
            }
            return number % decimalValue;
        } else {
            return number;
        }
    }

    public static String convert(int val) {
        StringBuffer result = new StringBuffer();
        for (Numeral numeral : values()) {
            val = numeral.apply(val, result);
        }
        return result.toString();
    }
}
