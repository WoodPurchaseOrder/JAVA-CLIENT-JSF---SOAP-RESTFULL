/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.store.business.logic;





import com.store.integration.Component;
import com.store.integration.Order;
import com.store.integration.OrderingEndpoint;
import com.store.integration.OrderingService;
import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;
import javax.xml.ws.WebServiceRef;

/**
 *
 * @author Numalama
 */

@Stateless
public class SoapOrderValidator implements OrderValidator{
    
    
    @WebServiceRef(OrderingService.class)
    private OrderingEndpoint ordering; 
    
     @Override
     //public Boolean process(Long id, String name) {
     public Boolean process(Long id, String name, Long componentId, String componentName, Long componentQty) {
         List<Component> components = new ArrayList<Component>();
         
         Component c = new Component();
         Order o = new Order();
         
         c.setId(componentId);
         c.setName(componentName);
         c.setQty(componentQty);
         components.add(c);
        
         
         o.setId(id);
         o.setName(name);
         for (Component cc: components){
             o.getComponentList().add(cc);
         }
        
         //Boolean isValid = ordering.orderOperation(id, name,components);
         Boolean isValid = ordering.orderOperation(id, name, components);
         Boolean isObjectValid = ordering.orderObjectOperation(o);
         System.out.println("isValid:");
         System.out.println(isValid);
         return isValid;
     } 
}
