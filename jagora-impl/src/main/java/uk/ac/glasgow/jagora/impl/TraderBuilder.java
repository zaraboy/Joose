package uk.ac.glasgow.jagora.impl;

import java.util.Map;
import java.util.Random;

import uk.ac.glasgow.jagora.Stock;
import uk.ac.glasgow.jagora.Trader;

public class TraderBuilder {
	private String type; // type of Trader - Random or Default
	
	private Integer initialQuantity;
	private String name;
	private Double cash;
	private Map<Stock,Integer> inventory;
	private Random random;
	private double priceRange;
	private Integer maxTradeQuantity;
	private Stock stock;
	private Double lastKnownBestOffer;
	private Double lastKnownBestBid;
	
	public void requestTrader(String type){
		this.type = type;
	}
	
	
	public TraderBuilder setName(String name){
		this.name = name;
		return this;
		
	}
	
	public TraderBuilder setCash(Double cash){
		this.cash = cash;
		return this;
	}
	
	public TraderBuilder setInventory(Map<Stock,Integer> inventory){
		this.inventory = inventory;
		return this;
	}
	
	public TraderBuilder setPriceRange(double priceRange){
		this.priceRange = priceRange;
		return this;
	}
	
	public TraderBuilder setRandom(Random random){
		this.random = random;
		return this;
	}
	
	public TraderBuilder setMaxQuantity(Integer maxQuantity){
		this.maxTradeQuantity = maxQuantity;
		return this;
	}
	
	public TraderBuilder setStock(Stock stock){
		this.stock = stock;
		return this;
	}
	
	public TraderBuilder setInitialQuantity(Integer initialQuantity){
		this.initialQuantity = initialQuantity;
		return this;
	}
	
	
	public Trader build(){
		if(type == null){
			return null;
		}
		if(type.equals("default")){
			return new DefaultTrader(name, cash, stock, initialQuantity);
		}
		if(type.equals("random")){
			return new RandomTrader(name, cash, stock, initialQuantity, maxTradeQuantity, priceRange, random);
		}
		return null;
	}
	
	
	

}
