package org.example.matchingengine.handlers;

import com.lmax.disruptor.EventHandler;
import org.example.matchingengine.model.MarketData;

public class OrderLogger implements EventHandler<MarketData> {


    @Override
    public void onEvent(MarketData marketData, long l, boolean b) throws Exception {

        //MarketData order = orderEvent.getOrder();
        System.out.println("Order: " + marketData.toString());
    }
}
