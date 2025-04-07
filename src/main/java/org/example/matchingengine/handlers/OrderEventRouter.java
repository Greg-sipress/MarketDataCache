package org.example.matchingengine.handlers;

import com.lmax.disruptor.EventHandler;
import org.example.matchingengine.model.MarketData;
import org.example.matchingengine.networking.OrderGateway;

public class OrderEventRouter implements EventHandler<MarketData> {


    public OrderGateway orderGateway = new OrderGateway();


    @Override
    public void onEvent(MarketData marketData, long l, boolean b) throws Exception {
        orderGateway.send(marketData);
    }
}
