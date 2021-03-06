package org.redhat;

import java.util.ArrayList;
import java.util.List;

import org.apache.camel.Exchange;
import org.apache.camel.Message;
import org.apache.camel.impl.DefaultExchange;
import org.apache.camel.processor.aggregate.AggregationStrategy;

public class MyAggregationStrategy implements AggregationStrategy { 
	
    @Override 
    public Exchange aggregate(Exchange oldExchange, Exchange newExchange) { 
        List<Exchange> list; 
        Exchange answer = oldExchange; 

        if (oldExchange == null) { 
            answer = new DefaultExchange(newExchange); 
            list = new ArrayList<Exchange>(); 
            answer.setProperty(Exchange.GROUPED_EXCHANGE, list); 
        } else { 
            list = oldExchange.getProperty(Exchange.GROUPED_EXCHANGE, List.class); 
        } 
        Message message = newExchange.getIn(); 
        message.setBody(newExchange.getIn().getBody(String.class)); 
        if (newExchange != null) { 
            list.add(newExchange); 
        } 
        return answer; 
    } 
} 