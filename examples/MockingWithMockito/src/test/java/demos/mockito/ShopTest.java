package demos.mockito;

import java.util.SortedMap;
import java.util.TreeMap;

import org.junit.Rule;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;
import org.mockito.quality.Strictness;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.*;

public class ShopTest {
	@Rule
	public MockitoRule rule = MockitoJUnit.rule().strictness(Strictness.STRICT_STUBS);

	private @Mock PricingEngine pricingEngine;
	private @Mock PaymentEngine paymentEngine;
	private @Mock StockCheckEngine stockCheckEngine;

	@Test
	public void makePurchaseWorksForValidQuantity() {
		when(stockCheckEngine.check("AB12")).thenReturn(20);
		when(pricingEngine.price("AB12",19)).thenReturn(27.30);
		when(paymentEngine.authorize("010203XYZ",27.30)).thenReturn(true);
		
		Shop s = new Shop(pricingEngine,stockCheckEngine,paymentEngine);
		assertTrue(s.makePurchase("AB12", 19, "010203XYZ"));
		
		verify(stockCheckEngine).check("AB12");
		verify(pricingEngine).price("AB12",19);
		verify(paymentEngine).authorize("010203XYZ",27.30);
	}
	@Test
	public void makePurchaseWorksForInvalidQuantity() {
		when(stockCheckEngine.check("AB12")).thenReturn(20);

		Shop s = new Shop(pricingEngine,stockCheckEngine,paymentEngine);
		assertFalse(s.makePurchase("AB12", 21, "010203XYZ"));

		verify(stockCheckEngine).check("AB12");
	}
	@Test
	public void orderPossibleWhenItemsInStock() {
		SortedMap<String,Integer> items = new TreeMap<String,Integer>();
		items.put("AB12", 12);
		items.put("CD34", 34);
		items.put("EF56", 56);
		
		when(stockCheckEngine.check("AB12")).thenReturn(14);
		when(stockCheckEngine.check("CD34")).thenReturn(36);
		when(stockCheckEngine.check("EF56")).thenReturn(58);
		
		Shop shop = new Shop(pricingEngine,stockCheckEngine,paymentEngine);
		assertEquals(0,shop.checkIfOrderPossible(items).length);
		
		verify(stockCheckEngine,times(3)).check(anyString());
	}
	@Test
	public void orderNotPossibleWhenSomeItemsOutOfStock() {
		SortedMap<String,Integer> items = new TreeMap<String,Integer>();
		items.put("AB12", 12);
		items.put("CD34", 34);
		items.put("EF56", 56);
		
		when(stockCheckEngine.check("AB12")).thenReturn(14);
		when(stockCheckEngine.check("CD34")).thenReturn(32);
		when(stockCheckEngine.check("EF56")).thenReturn(54);
		
		Shop shop = new Shop(pricingEngine,stockCheckEngine,paymentEngine);
		String [] results = shop.checkIfOrderPossible(items);
		
		verify(stockCheckEngine,times(3)).check(anyString());
		verify(pricingEngine,never()).price(anyString(), anyInt());
		verify(paymentEngine,never()).authorize(anyString(), anyDouble());

		assertEquals(2,results.length);
		assertEquals("CD34",results[0]);
		assertEquals("EF56",results[1]);
	}
	@Test
	public void orderNotPossibleWhenAllItemsOutOfStock() {
		SortedMap<String,Integer> items = new TreeMap<String,Integer>();
		items.put("AB12", 12);
		items.put("CD34", 34);
		items.put("EF56", 56);

		when(stockCheckEngine.check(anyString())).then(invocation -> {
			String itemNo = invocation.getArgument(0);
			return items.get(itemNo) - 1;
		});
		
		Shop shop = new Shop(pricingEngine,stockCheckEngine,paymentEngine);
		String [] results = shop.checkIfOrderPossible(items);
		
		verify(stockCheckEngine,times(3)).check(anyString());
		verify(pricingEngine,never()).price(anyString(), anyInt());
		verify(paymentEngine,never()).authorize(anyString(), anyDouble());

		assertEquals(3,results.length);
		assertEquals("AB12",results[0]);
		assertEquals("CD34",results[1]);
		assertEquals("EF56",results[2]);
	}
	@Test
	public void makeMultiplePurchasesWorksForValidQuantities() {
		SortedMap<String,Integer> items = new TreeMap<String,Integer>();
		items.put("AB12", 12);
		items.put("CD34", 34);
		items.put("EF56", 56);
		
		when(stockCheckEngine.check(anyString())).thenReturn(100);
		
		when(pricingEngine.price("AB12",12)).thenReturn(1.23);
		when(pricingEngine.price("CD34",34)).thenReturn(3.45);
		when(pricingEngine.price("EF56",56)).thenReturn(6.78);
		
		when(paymentEngine.authorize("010203XYZ",11.46)).thenReturn(true);
		
		Shop shop = new Shop(pricingEngine,stockCheckEngine,paymentEngine);
		assertTrue(shop.makePurchases(items, "010203XYZ"));
		
		verify(stockCheckEngine,times(3)).check(anyString());
		verify(pricingEngine,times(3)).price(anyString(),anyInt());
		verify(paymentEngine).authorize("010203XYZ",11.46);
	}
}
