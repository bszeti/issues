package com.mycompany.cameltransporttest;

import org.apache.camel.Exchange;
import org.apache.camel.impl.DefaultExchange;
import org.apache.camel.test.blueprint.CamelBlueprintTestSupport;

import org.junit.Test;

public class RouteTest extends CamelBlueprintTestSupport {
	
    @Override
    protected String getBlueprintDescriptor() {
        return "/OSGI-INF/blueprint/CamelTransportTest.xml";
    }
    
    
    //Required to disable blueprint validation in the test bundle assembled by CamelBlueprintTestSupport
    @Override
    protected String getBundleDirectives(){
    	return "blueprint.aries.xml-validation:=false";
    }

    @Test
    public void testRoute() throws Exception {
    	Exchange exchange = new DefaultExchange(context);
    	exchange.getIn().setBody("");
    	exchange.setFromEndpoint(context.getEndpoint("direct:caller"));
    	
    	Exchange response = template.send("direct:caller",exchange);
    	
    	assertEquals("Hello World!", response.getIn().getBody());

    }

}
