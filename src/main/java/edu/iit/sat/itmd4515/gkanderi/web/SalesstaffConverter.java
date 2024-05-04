package edu.iit.sat.itmd4515.gkanderi.web;

import edu.iit.sat.itmd4515.gkanderi.domain.Salesstaff;
import edu.iit.sat.itmd4515.gkanderi.service.SalesstaffService;
import jakarta.ejb.EJB;
import jakarta.faces.component.UIComponent;
import jakarta.faces.context.FacesContext;
import jakarta.faces.convert.Converter;
import jakarta.faces.convert.FacesConverter;

/**
 * The SalesstaffConverter class converts Salesstaff objects to and from a string representation.
 * It is used for converting Salesstaff objects in JSF views.
 * 
 * @author 18722
 */
@FacesConverter(value="salesstaffConverter", managed=true)
public class SalesstaffConverter implements Converter<Salesstaff>{

    @EJB 
    SalesstaffService SalesstaffService;
    
    /**
     * Converts a string value to a Salesstaff object.
     * 
     * @param context The FacesContext object.
     * @param component The UIComponent object.
     * @param value The string value to convert.
     * @return The Salesstaff object.
     */
    @Override
    public Salesstaff getAsObject(FacesContext context, UIComponent component, String value) {
        return SalesstaffService.read(Long.valueOf(value));
    }

    /**
     * Converts a Salesstaff object to its string representation.
     * 
     * @param context The FacesContext object.
     * @param component The UIComponent object.
     * @param value The Salesstaff object to convert.
     * @return The string representation of the Salesstaff object.
     */
    @Override
    public String getAsString(FacesContext context, UIComponent component, Salesstaff value) {
        return String.valueOf(value.getId());
    }
}
