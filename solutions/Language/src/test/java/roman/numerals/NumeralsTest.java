package roman.numerals;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class NumeralsTest {
	@Test
	public void conversions() {
		assertEquals("I",Numeral.convert(1));
		assertEquals("III",Numeral.convert(3));
		assertEquals("IV",Numeral.convert(4));
		assertEquals("V",Numeral.convert(5));
		assertEquals("VI",Numeral.convert(6));
		assertEquals("IX",Numeral.convert(9));
		assertEquals("X",Numeral.convert(10));
		assertEquals("XI",Numeral.convert(11));
		assertEquals("XL",Numeral.convert(40));
		assertEquals("XLI",Numeral.convert(41));
		assertEquals("L",Numeral.convert(50));
		assertEquals("LI",Numeral.convert(51));
		assertEquals("XC",Numeral.convert(90));
		assertEquals("XCI",Numeral.convert(91));
		assertEquals("C",Numeral.convert(100));
		assertEquals("CI",Numeral.convert(101));
	}
}
