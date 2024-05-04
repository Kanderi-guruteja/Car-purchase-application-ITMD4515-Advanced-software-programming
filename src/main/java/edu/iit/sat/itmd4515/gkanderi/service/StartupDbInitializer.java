package edu.iit.sat.itmd4515.gkanderi.service;

import edu.iit.sat.itmd4515.gkanderi.domain.Appointment;
import edu.iit.sat.itmd4515.gkanderi.domain.Car;
import edu.iit.sat.itmd4515.gkanderi.domain.CarType;
import edu.iit.sat.itmd4515.gkanderi.domain.Leasingoffice;
import edu.iit.sat.itmd4515.gkanderi.domain.Manufacturer;
import edu.iit.sat.itmd4515.gkanderi.domain.Salesstaff;
import edu.iit.sat.itmd4515.gkanderi.security.Group;
import edu.iit.sat.itmd4515.gkanderi.security.GroupService;
import edu.iit.sat.itmd4515.gkanderi.security.User;
import edu.iit.sat.itmd4515.gkanderi.security.UserService;
import jakarta.annotation.PostConstruct;
import jakarta.ejb.EJB;
import jakarta.ejb.Singleton;
import jakarta.ejb.Startup;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.logging.Logger;

/**
 * Initializes the database with sample data upon application startup.
 * This class is annotated with @Startup and @Singleton to ensure that it runs once during application startup.
 * It injects various service classes to create and manage entities in the database.
 * This class creates sample sales staff, manufacturers, cars, appointments, and leasing offices.
 * It also establishes relationships between these entities.
 * 
 * @author 18722
 */
@Startup
@Singleton
public class StartupDbInitializer {

    private static final Logger LOG = Logger.getLogger(StartupDbInitializer.class.getName());

    @EJB
    private LeasingofficeService leasingofficeService;

    @EJB
    private CarService carService;

    @EJB
    private SalesstaffService salesstaffService;

    @EJB
    private ManufacturerService manufacturerService;

    @EJB
    private AppointmentService appointmentService;

    @EJB
    UserService userService;

    @EJB
    GroupService groupService;

    /**
     * Default constructor.
     */
    public StartupDbInitializer() {
    }

    /**
     * Method called after the constructor to initialize the database with sample data.
     */
    @PostConstruct
    public void postConstruct() {

        LOG.info("StartupDbInitializer.PostConstruct");

        // Create security groups
        Group salesStaffGroup = new Group("SALESSTAFF_GROUP", "Security realm sales staff group");
        Group manufacturerGroup = new Group("MANUFACTURER_GROUP", "Security realm manufacturer group");
        Group adminGroup = new Group("ADMIN_GROUP", "Security realm admin group users");

        // Persist security groups
        groupService.create(adminGroup);
        groupService.create(manufacturerGroup);
        groupService.create(salesStaffGroup);

        // Create users
        User salesStaff1 = new User("salesstaff1", "salesstaff1");
        salesStaff1.addGroup(salesStaffGroup);
        salesStaff1.addGroup(adminGroup);
        userService.create(salesStaff1);

        User salesStaff2 = new User("salesstaff2", "salesstaff2");
        salesStaff2.addGroup(adminGroup);
        salesStaff2.addGroup(manufacturerGroup);
        userService.create(salesStaff2);

        User salesStaff3 = new User("salesstaff3", "salesstaff3");
        salesStaff3.addGroup(salesStaffGroup);
        salesStaff3.addGroup(adminGroup);
        userService.create(salesStaff3);

        User manufacturer1 = new User("manufacturer1", "manufacturer1");
        manufacturer1.addGroup(manufacturerGroup);
        userService.create(manufacturer1);

        User manufacturer2 = new User("manufacturer2", "manufacturer2");
        manufacturer2.addGroup(manufacturerGroup);
        userService.create(manufacturer2);

        User admin = new User("admin", "admin");
        admin.addGroup(adminGroup);
        userService.create(admin);

        // Create leasing offices
        Leasingoffice l1 = new Leasingoffice("Leasingoffice one");
        Leasingoffice l2 = new Leasingoffice("Leasingoffice two");

        leasingofficeService.create(l1);
        leasingofficeService.create(l2);

        // Create cars
        Car c1 = new Car("Buick", LocalDate.of(2020, 10, 8), CarType.PETROL);
        Car c2 = new Car("Malibu", LocalDate.of(2021, 10, 9), CarType.ELECTRIC);
        Car c3 = new Car("Ferrari", LocalDate.of(2022, 10, 10), CarType.HYBRID);
        Car c4 = new Car("Maruti", LocalDate.of(2023, 10, 11), CarType.DIESEL);

        carService.create(c1);
        carService.create(c2);
        carService.create(c3);
        carService.create(c4);

        // Create sales staff
        Salesstaff s1 = new Salesstaff("Petrol vehicles sales staff");
        s1.setLeasingoffice(l1);
        s1.setUser(salesStaff1);
        Salesstaff s2 = new Salesstaff("Diesel vehicles sales staff");
        s2.setLeasingoffice(l2);
        s2.setUser(salesStaff2);
        Salesstaff s3 = new Salesstaff("Hybrid vehicles sales staff");
        s3.setLeasingoffice(l2);
        s3.setUser(salesStaff3);
        Salesstaff s4 = new Salesstaff("Electric vehicles sales staff");
        s4.setLeasingoffice(l1);
        s4.setUser(salesStaff1);

        salesstaffService.create(s1);
        salesstaffService.create(s2);
        salesstaffService.create(s3);
        salesstaffService.create(s4);

        // Create manufacturers
        Manufacturer m1 = new Manufacturer("maker@Buick.com", "Buick_Maker", LocalDate.of(2024, 10, 10));
        m1.addCar(c1);
        m1.addCar(c2);
        m1.setUser(manufacturer1);

        Manufacturer m2 = new Manufacturer("dielseheicles_salesstaff_too@Malibu.com", "Diesel_car_Maker", LocalDate.of(2012, 8, 11));
        m2.addCar(c3);
        m2.addCar(c4);
        m2.setUser(salesStaff2);

        Manufacturer m3 = new Manufacturer("maker@ferrari.com", "Ferrari", LocalDate.of(2013, 5, 20));
        m3.addCar(c1);
        m3.addCar(c3);
        m3.setUser(manufacturer2);

        manufacturerService.create(m1);
        manufacturerService.create(m2);
        manufacturerService.create(m3);

        // Create appointments
        Appointment a1 = new Appointment(LocalDate.of(2024, 5, 25), LocalTime.of(10, 30));
        a1.schedAppt(m1, c1, s1);
        Appointment a2 = new Appointment(LocalDate.of(2024, 6, 30), LocalTime.of(9, 30));
        a2.schedAppt(m3, c3, s2);

        appointmentService.create(a1);
        appointmentService.create(a2);

        LOG.info("==================================Salesstaff and their JPA relationships==================");

        // Log sales staff and their JPA relationships
        for (Salesstaff s : salesstaffService.findAll()) {
            LOG.info(s.toString());
            LOG.info("");

            LOG.info("==============Bi-directional 1:Many with Appointment==================================");
            for (Appointment appointment : s.getAppointments()) {
                LOG.info(appointment.toString());
            }
            LOG.info("");

            LOG.info("==============Bi-directional Many:1 with Salesstaff==================================");
            for (Appointment appointment : appointmentService.findAll()) {
                if (appointment.getSalesstaff() != null && appointment.getSalesstaff().equals(s)) {
                    LOG.info(appointment.toString());
                }
            }
            LOG.info("");
            if (s.getLeasingoffice() != null) {
                LOG.info("==============Unidirectional 1:1 with Leasingoffice==================================");
                LOG.info(s.getLeasingoffice().toString());
            }
            LOG.info("");

            LOG.info("\n");
            LOG.info("");
        }
    }

}
