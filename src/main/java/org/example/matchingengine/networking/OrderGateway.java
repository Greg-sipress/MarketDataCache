package org.example.matchingengine.networking;


import io.aeron.Aeron;
import io.aeron.Publication;
import org.agrona.DirectBuffer;

import org.agrona.concurrent.UnsafeBuffer;
import org.example.matchingengine.model.MarketData;

import java.nio.ByteBuffer;

public class OrderGateway {
    private final Aeron aeron;
    private final Publication publication;

    public OrderGateway() {
        aeron = Aeron.connect(new Aeron.Context());
        publication = aeron.addPublication("aeron:udp?endpoint=224.0.1.1:40456", 1001);
    }

    private DirectBuffer encodeOrder(MarketData order) {
        byte[] bytes = order.toJson().getBytes();
        ByteBuffer byteBuffer = ByteBuffer.allocate(bytes.length);
        byteBuffer.put(bytes);
        return new UnsafeBuffer(byteBuffer.flip());
    }

    public void send(MarketData order) {
        // Encode to SBE (Simple Binary Encoding) format
        DirectBuffer buffer = encodeOrder(order);
        while (publication.offer(buffer) < 0) {
            // Backpressure handling
        }
    }
}
