/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.iit.sat.itmd4515.gkanderi.web;

import edu.iit.sat.itmd4515.gkanderi.domain.Salesstaff;
import edu.iit.sat.itmd4515.gkanderi.service.SalesstaffService;
import jakarta.ejb.EJB;
import jakarta.faces.component.UIComponent;
import jakarta.faces.context.FacesContext;
import jakarta.faces.convert.Converter;
import jakarta.faces.convert.FacesConverter;

/**
 *
 * @author 18722
 */
@FacesConverter(value="salesstaffConverter", managed=true)
public class SalesstaffConverter implements Converter<Salesstaff>{

    @EJB SalesstaffService SalesstaffService;
    
    @Override
    public Salesstaff getAsObject(FacesContext context, UIComponent component, String value) {
    
    return SalesstaffService.read(Long.valueOf(value));
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Salesstaff value) {
  
    return String.valueOf(value.getId());
    }
    
}
