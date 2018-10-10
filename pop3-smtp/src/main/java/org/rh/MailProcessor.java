package org.rh;

import java.util.List;
import java.util.Map;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;

public class MailProcessor implements Processor {

	@Override
	public void process(Exchange exchange) throws Exception {
		String mailBody = exchange.getIn().getBody(String.class);
        System.out.println("MailBody to be processed: " + mailBody);
        mailBody = mailBody.replace("\n", "").replace("\r", "");
        exchange.getOut().setBody(mailBody);
	}
	

}
