package uk.ac.glasgow.jagora.test.impl;

import org.junit.Before;
import static uk.ac.glasgow.jagora.test.stub.StubStock.lemons;
import java.util.Random;


import uk.ac.glasgow.jagora.impl.DefaultTrader;
import uk.ac.glasgow.jagora.impl.RandomTrader;
import uk.ac.glasgow.jagora.impl.TraderBuilder;
import uk.ac.glasgow.jagora.test.TraderBuilderTest;

public class BuilderTest extends TraderBuilderTest{
	
	
	@Before
	public void setup(){
		TraderBuilder theBuilder = new TraderBuilder();
		stock=lemons;
		quantity = 100;
		cash = 1000.0;
		name="default";
		theBuilder.requestTrader("default");
		defTrader = theBuilder
				.setName(name)
				.setCash(cash)
				.setStock(stock)
				.setInitialQuantity(quantity).build();
		
		theBuilder.requestTrader("random");
		randTrader = theBuilder
				.setName("random")
				.setCash(1000.0)
				.setStock(lemons)
				.setInitialQuantity(100)
				.setMaxQuantity(10)
				.setPriceRange(2.0)
				.setRandom(new Random()).build();
	}
	

}
