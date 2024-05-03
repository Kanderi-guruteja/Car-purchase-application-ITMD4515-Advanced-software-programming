/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.iit.sat.itmd4515.gkanderi.web;

import edu.iit.sat.itmd4515.gkanderi.domain.Manufacturer;
import edu.iit.sat.itmd4515.gkanderi.service.ManufacturerService;
import jakarta.ejb.EJB;
import jakarta.faces.component.UIComponent;
import jakarta.faces.context.FacesContext;
import jakarta.faces.convert.Converter;
import jakarta.faces.convert.FacesConverter;

/**
 *
 * @author 18722
 */
@FacesConverter(value="manufacturerConverter", managed=true)
public class ManufacturerConverter implements Converter<Manufacturer>{

    @EJB ManufacturerService ManufacturerService;
    
    @Override
    public Manufacturer getAsObject(FacesContext context, UIComponent component, String value) {
    
    return ManufacturerService.read(Long.valueOf(value));
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Manufacturer value) {
  
    return String.valueOf(value.getId());
    }
    
}
