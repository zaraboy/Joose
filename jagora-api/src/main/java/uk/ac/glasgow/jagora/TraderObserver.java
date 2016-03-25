package uk.ac.glasgow.jagora;

import java.util.List;

public interface TraderObserver {
	public void update(List<TickEvent<Trade>> tradeHistory);
		
}
