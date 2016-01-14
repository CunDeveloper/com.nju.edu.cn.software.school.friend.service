package com.nju.edu.cn.software.service;

import java.io.IOException;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

import org.glassfish.jersey.media.sse.EventOutput;
import org.glassfish.jersey.media.sse.OutboundEvent;
import org.glassfish.jersey.media.sse.SseFeature;

/**
 *  client sends a request and server holds a connection until a new message is ready, 
 *  then it sends the message back to the client while still keeping the connection open 
 *  so that it can be used for another message once it becomes available. Once a new message is ready, 
 *  it is sent back to the client on the same initial connection. Client processes the messages sent back 
 *  from the server individually without closing the connection after processing each message. So, 
 *  SSE typically reuses one connection for more messages (called events). 
 *  SSE also defines a dedicated media type that describes a simple format of individual events sent 
 *  from the server to the client
 * @author xiaojuzhang
 *
 */

@Path("events")
public class SseResource {
	@GET
    @Produces(SseFeature.SERVER_SENT_EVENTS)
    public EventOutput getServerSentEvents() {
        final EventOutput eventOutput = new EventOutput();
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    for (int i = 0; i < 100; i++) {
                        final OutboundEvent.Builder eventBuilder
                        = new OutboundEvent.Builder();
                        eventBuilder.name("message-to-client");
                        eventBuilder.data(String.class,
                            "Hello world " + i + "!");
                        final OutboundEvent event = eventBuilder.build();
                        eventOutput.write(event);
                    }
                } catch (IOException e) {
                    throw new RuntimeException(
                        "Error when writing the event.", e);
                } finally {
                    try {
                        eventOutput.close();
                    } catch (IOException ioClose) {
                        throw new RuntimeException(
                            "Error when closing the event output.", ioClose);
                    }
                }
            }
        }).start();
        return eventOutput;
	}
}
