package edu.iit.sat.itmd4515.gkanderi.web;

import edu.iit.sat.itmd4515.gkanderi.domain.Car;
import edu.iit.sat.itmd4515.gkanderi.service.CarService;
import jakarta.ejb.EJB;
import jakarta.faces.component.UIComponent;
import jakarta.faces.context.FacesContext;
import jakarta.faces.convert.Converter;
import jakarta.faces.convert.FacesConverter;

/**
 * A converter class for converting between Car objects and their corresponding string representations.
 * This class implements the Converter<Car> interface provided by JavaServer Faces (JSF).
 * The converter is registered with the name "carConverter" and managed by JSF.
 * It retrieves Car objects from the CarService based on their ID, and converts Car objects to their ID strings.
 * 
 * @author 18722
 */
/**
 * This class implements the Converter{@link Car} interface provided by JavaServer Faces (JSF).
 */
@FacesConverter(value = "carConverter", managed = true)
public class CarConverter implements Converter<Car> {

    @EJB
    CarService carService;

    /**
     * Converts the ID string representation of a Car to a Car object.
     *
     * @param context   The FacesContext object.
     * @param component The UIComponent object.
     * @param value     The ID string value representing the Car.
     * @return The Car object corresponding to the provided ID.
     */
    @Override
    public Car getAsObject(FacesContext context, UIComponent component, String value) {
        return carService.read(Long.valueOf(value));
    }

    /**
     * Converts a Car object to its ID string representation.
     *
     * @param context   The FacesContext object.
     * @param component The UIComponent object.
     * @param value     The Car object to be converted.
     * @return The ID string representation of the Car.
     */
    @Override
    public String getAsString(FacesContext context, UIComponent component, Car value) {
        return String.valueOf(value.getId());
    }

}
