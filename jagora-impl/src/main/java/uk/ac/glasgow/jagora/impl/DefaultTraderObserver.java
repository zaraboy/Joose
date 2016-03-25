package uk.ac.glasgow.jagora.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import uk.ac.glasgow.jagora.Stock;
import uk.ac.glasgow.jagora.StockExchange;
import uk.ac.glasgow.jagora.TickEvent;
import uk.ac.glasgow.jagora.Trade;
import uk.ac.glasgow.jagora.TraderObserver;

public class DefaultTraderObserver extends AbstractTrader implements TraderObserver {
	private List<TickEvent<Trade>> tradeHistory;
	
	
	public DefaultTraderObserver(String name, Double cash, Stock stock, Integer quantity, List<TickEvent<Trade>> tradeHistory) {
	        super(name, cash, createInventory(stock, quantity));
	        this.tradeHistory = tradeHistory;
	    }

	
	
    private static Map<Stock, Integer> createInventory(Stock stock, int quantity) {
        Map<Stock,Integer> inventory = new HashMap<Stock,Integer>();
        inventory.put(stock, quantity);
        return inventory;
    }



	@Override
	public void speak(StockExchange stockExchange) {
		// TODO Auto-generated method stub
		
	}



	@Override
	public void update(List<TickEvent<Trade>> tradeHistory) {
		// TODO Auto-generated method stub
		
	}

}
