/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.iit.sat.itmd4515.gkanderi.web;

import edu.iit.sat.itmd4515.gkanderi.domain.Car;
import edu.iit.sat.itmd4515.gkanderi.service.CarService;
import jakarta.ejb.EJB;
import jakarta.faces.component.UIComponent;
import jakarta.faces.context.FacesContext;
import jakarta.faces.convert.Converter;
import jakarta.faces.convert.FacesConverter;

/**
 *
 * @author 18722
 */
@FacesConverter(value="carConverter",managed=true)
public class CarConverter implements Converter<Car>{

    @EJB CarService carservice;
    
    @Override
    public Car getAsObject(FacesContext context, UIComponent component, String value) {
  
   return carservice.read(Long.valueOf(value));
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Car value) {
   
    return String.valueOf(value.getId());
    }
    
}
