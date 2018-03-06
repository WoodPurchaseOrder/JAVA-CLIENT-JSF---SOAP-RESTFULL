/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.store.business.logic;

import javax.ejb.Local;
import javax.inject.Inject;

/**
 *
 * @author Numalama
 */
@Local
public interface OrderValidator {
   //Boolean process(Long id, String name);
    Boolean process(Long id, String name, Long componentId, String componentName, Long componentQty);
}
