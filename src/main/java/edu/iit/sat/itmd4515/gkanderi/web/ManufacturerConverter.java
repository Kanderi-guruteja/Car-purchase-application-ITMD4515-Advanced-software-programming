package edu.iit.sat.itmd4515.gkanderi.web;

import edu.iit.sat.itmd4515.gkanderi.domain.Manufacturer;
import edu.iit.sat.itmd4515.gkanderi.service.ManufacturerService;
import jakarta.ejb.EJB;
import jakarta.faces.component.UIComponent;
import jakarta.faces.context.FacesContext;
import jakarta.faces.convert.Converter;
import jakarta.faces.convert.FacesConverter;

/**
 * The ManufacturerConverter class is responsible for converting Manufacturer entities to and from their string representations in the JSF views.
 * It implements the Converter interface to provide custom conversion logic.
 * 
 * @author 18722
 */
@FacesConverter(value = "manufacturerConverter", managed = true)
public class ManufacturerConverter implements Converter<Manufacturer> {

    @EJB
    ManufacturerService ManufacturerService;

    /**
     * Converts the string representation of a Manufacturer entity ID to the corresponding Manufacturer object.
     * 
     * @param context The FacesContext.
     * @param component The UIComponent.
     * @param value The string representation of the Manufacturer ID.
     * @return The Manufacturer object.
     */
    @Override
    public Manufacturer getAsObject(FacesContext context, UIComponent component, String value) {
        return ManufacturerService.read(Long.valueOf(value));
    }

    /**
     * Converts a Manufacturer object to its string representation, which is its ID.
     * 
     * @param context The FacesContext.
     * @param component The UIComponent.
     * @param value The Manufacturer object.
     * @return The string representation of the Manufacturer ID.
     */
    @Override
    public String getAsString(FacesContext context, UIComponent component, Manufacturer value) {
        return String.valueOf(value.getId());
    }

}
