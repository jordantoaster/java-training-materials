package demos.mockito;

import java.util.ArrayList;
import java.util.List;
import java.util.SortedMap;

public class Shop {
	public Shop(PricingEngine pricingEngine, StockCheckEngine stockCheckEngine, PaymentEngine paymentEngine) {
		super();
		this.pricingEngine = pricingEngine;
		this.stockCheckEngine = stockCheckEngine;
		this.paymentEngine = paymentEngine;
	}
	public boolean makePurchase(String itemNo, int quantity, String cardNo) {
		if(stockCheckEngine.check(itemNo) >= quantity) {
			double charge = pricingEngine.price(itemNo, quantity);
			if(paymentEngine.authorize(cardNo, charge)) {
				return true;
			}
		}
		return false;
	}
	public String [] checkIfOrderPossible(SortedMap<String,Integer> items) {
		List<String> itemsUnderstocked = new ArrayList<String>();
		for(SortedMap.Entry<String, Integer> entry : items.entrySet()) {
			if(stockCheckEngine.check(entry.getKey()) < entry.getValue()) {
				itemsUnderstocked.add(entry.getKey());
			}
		}
		return itemsUnderstocked.toArray(new String[itemsUnderstocked.size()]);
	}
	public boolean makePurchases(SortedMap<String,Integer> items, String cardNo) {
		String[] understocked = checkIfOrderPossible(items);
		if(understocked.length == 0) {
			double charge = 0;
			for(SortedMap.Entry<String, Integer> entry : items.entrySet()) {
				charge += pricingEngine.price(entry.getKey(), entry.getValue());
			}
			return paymentEngine.authorize(cardNo, charge);
		} else {
			return false;
		}
	}

    private final PricingEngine pricingEngine;
    private final StockCheckEngine stockCheckEngine;
    private final PaymentEngine paymentEngine;
}
