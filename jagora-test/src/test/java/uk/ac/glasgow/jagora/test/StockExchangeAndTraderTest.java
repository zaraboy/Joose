package uk.ac.glasgow.jagora.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static uk.ac.glasgow.jagora.test.stub.StubStock.lemons;

import org.junit.Ignore;
import org.junit.Test;

import uk.ac.glasgow.jagora.BuyOrder;
import uk.ac.glasgow.jagora.SellOrder;
import uk.ac.glasgow.jagora.StockExchange;
import uk.ac.glasgow.jagora.StockExchangeObservable;
import uk.ac.glasgow.jagora.Trader;
import uk.ac.glasgow.jagora.TraderObserver;
import uk.ac.glasgow.jagora.impl.DefaultStockExchange;
import uk.ac.glasgow.jagora.test.stub.StubTraderObserver;

@Ignore
public abstract class StockExchangeAndTraderTest {

	protected DefaultStockExchange stockExchange;

	protected BuyOrder badBuyOrder;
	protected SellOrder badSellOrder;
	
	protected SellOrder goodSellOrder;
	protected BuyOrder goodBuyOrder;

	protected Trader buyer;
	protected Trader seller;
	
	protected StubTraderObserver trader;

	public StockExchangeAndTraderTest() {
		super();
	}

	@Test
	public void testBadBuyOrder() {
		stockExchange.placeBuyOrder(badBuyOrder);
		stockExchange.placeSellOrder(goodSellOrder);
		stockExchange.doClearing();
		assertNotNull(trader.tradeHistory);
		assertNull(stockExchange.getBestBid(lemons));
		assertNotNull(stockExchange.getBestOffer(lemons));
		assertEquals(0, stockExchange.getTradeHistory(lemons).size());
	}
	
	@Test
	public void testBadSellOrder() {
		stockExchange.placeBuyOrder(goodBuyOrder);
		stockExchange.placeSellOrder(badSellOrder);
		stockExchange.doClearing();
		assertNotNull(trader.tradeHistory);
		assertEquals(0, stockExchange.getTradeHistory(lemons).size());
		assertNull(stockExchange.getBestOffer(lemons));
		assertNotNull(stockExchange.getBestBid(lemons));
	}


}