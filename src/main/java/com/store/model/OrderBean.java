/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.store.model;

import com.store.business.logic.OrderValidator;
import java.util.Set;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;

/**
 *
 * @author Numalama
 */
@Named(value = "orderModel")
@RequestScoped
public class OrderBean {
    
    @Inject 
    private OrderValidator orderValidator;
    
    
    private Long id;
    
    private String name;
    
    private Long componentId;
    
    private String componentName;
     
    private Long componentQty;
    
    

    
    //private Set<ComponentBean> components;
      /**
     * Creates a new instance of OrderBean
     */
    public OrderBean() {
    }
    
        public String doOrderWithSoap(){
              System.out.println("La commande commence");
              //boolean isValid =   orderValidator.process(id, name); 
              boolean isValid =   orderValidator.process(id, name, componentId, componentName, componentQty); 
              System.out.println(isValid);
              if(isValid==true){
                return "valid";
            }else{
                return "invalid";
            }
        } 
    
    
    
    
    
    //
    
   
  
    
    
    /**
     * @return the id
     */
    public Long getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }


    

    /**
     * @return the componentId
     */
    public Long getComponentId() {
        return componentId;
    }

    /**
     * @param componentId the componentId to set
     */
    public void setComponentId(Long componentId) {
        this.componentId = componentId;
    }

    /**
     * @return the componentName
     */
    public String getComponentName() {
        return componentName;
    }

    /**
     * @param componentName the componentName to set
     */
    public void setComponentName(String componentName) {
        this.componentName = componentName;
    }

    /**
     * @return the componentQte
     */
    public Long getComponentQty() {
        return componentQty;
    }

    /**
     * @param componentQte the componentQte to set
     */
    public void setComponentQty(Long componentQty) {
        this.componentQty = componentQty;
    }

    
}
