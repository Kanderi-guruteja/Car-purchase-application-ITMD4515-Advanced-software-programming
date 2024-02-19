package edu.iit.sat.itmd4515.gkanderi.lab3;

import jakarta.annotation.Resource;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.transaction.HeuristicMixedException;
import jakarta.transaction.HeuristicRollbackException;
import jakarta.transaction.NotSupportedException;
import jakarta.transaction.RollbackException;
import jakarta.transaction.SystemException;
import jakarta.transaction.UserTransaction;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validator;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 *
 * @author 18722
 */

@WebServlet(name = "CityServlet", urlPatterns = {"/City", "/Ct", "/C", "/gkanderi-fp/"})
public class CityServlet extends HttpServlet {

    @Resource
    Validator validator;

    @PersistenceContext(name = "itmd4515PU")
    EntityManager em;

    @Resource
    UserTransaction tx;

    private static final Logger LOG = Logger.getLogger(CityServlet.class.getName());

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        LOG.info("CityServlet Inside doPost");

        String cityIdParam = req.getParameter("cityId");
        String cityNameParam = req.getParameter("cityName");
        String countryCodeParam = req.getParameter("countryCode");

        LOG.info("cityIdParam\t\t" + cityIdParam);
        LOG.info("cityNameParam\t\t" + cityNameParam);
        LOG.info("countryCodeParam\t\t" + countryCodeParam);

        Integer cityId = null;
        if (cityIdParam != null && !cityIdParam.isBlank()) {
            cityId = Integer.parseInt(cityIdParam);
        }

        City city = new City(cityId, cityNameParam, countryCodeParam);
        Set<ConstraintViolation<City>> violations = validator.validate(city);

        if (violations.size() > 0) {
            // invalid
            LOG.info("Entering City details has failed validation. These are the validations: ");

            for (ConstraintViolation<City> violation : violations) {
                LOG.info(violation.toString());
            }

            req.setAttribute("city", city);
            req.setAttribute("violations", violations);
            RequestDispatcher rd = req.getRequestDispatcher("/WEB-INF/views/city.jsp"); // Corrected path to city.jsp
            rd.forward(req, resp);
        } else {
            // valid
            LOG.info("Entering City details has passed validation.");

            createAJPACity(city);

            req.setAttribute("city", city);
            RequestDispatcher rd = req.getRequestDispatcher("/WEB-INF/views/confirmation.jsp");
            rd.forward(req, resp);
        }

        LOG.info("Built City POJO post-conversion values:\t\t" + city.toString());
    }

    private void createAJPACity(City c) {
        try {
            tx.begin();
            em.persist(c);
            tx.commit();
        } catch (NotSupportedException | SystemException | RollbackException | HeuristicMixedException | HeuristicRollbackException | SecurityException | IllegalStateException ex) {
            LOG.log(Level.SEVERE, null, ex);
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        LOG.info("CityServlet Inside doGet");
        resp.setContentType("text/html");
        PrintWriter out = resp.getWriter();
        out.println("<html><head><title>Hello Guruteja</title></head><body>");
        out.println("<h1>Hello, Guruteja!</h1>");
        out.println("</body></html>");
    }
}
