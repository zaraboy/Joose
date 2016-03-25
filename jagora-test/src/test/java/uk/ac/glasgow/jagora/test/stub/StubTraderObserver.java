package uk.ac.glasgow.jagora.test.stub;
import java.util.List;
import java.util.Set;

import uk.ac.glasgow.jagora.Stock;
import uk.ac.glasgow.jagora.StockExchange;
import uk.ac.glasgow.jagora.TickEvent;
import uk.ac.glasgow.jagora.Trade;
import uk.ac.glasgow.jagora.TraderObserver;
import uk.ac.glasgow.jagora.impl.DefaultStockExchange;
import uk.ac.glasgow.jagora.StockExchangeObservable;

public class StubTraderObserver implements TraderObserver{
	
	public List<TickEvent<Trade>> tradeHistory = null;
	private String name;
	
	
	public StubTraderObserver(DefaultStockExchange stockExchange, String name ){
		this.name = name;
		stockExchange.registerObserver(this);
	}

	public String getName(){
		return name;
	}


	@Override
	public void update(List<TickEvent<Trade>> tradeHistory) {
		this.tradeHistory = tradeHistory;
	}}
