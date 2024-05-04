package edu.iit.sat.itmd4515.gkanderi.web;

import jakarta.faces.event.PhaseEvent;
import jakarta.faces.event.PhaseId;
import jakarta.faces.event.PhaseListener;
import java.util.logging.Logger;

/**
 * The JSFPhaseListener class is responsible for logging JSF phase events.
 * It implements the PhaseListener interface to listen for JSF phase changes.
 * This class logs information before and after each JSF phase.
 * 
 * @author 18722
 */
public class JSFPhaseListener implements PhaseListener {

    private static final Logger LOG = Logger.getLogger(JSFPhaseListener.class.getName());

    /**
     * Gets the identifier of the current phase.
     *
     * @return The identifier of the current phase.
     */
    @Override
    public PhaseId getPhaseId() {
        return PhaseId.ANY_PHASE;
    }

    /**
     * Executes before a JSF phase.
     *
     * @param event The PhaseEvent object representing the phase change event.
     */
    @Override
    public void beforePhase(PhaseEvent event) {
        if (event.getPhaseId() == PhaseId.RESTORE_VIEW) {
            LOG.info("################################ NEW JSF REQUEST IS STARTING ################################");
        }
        LOG.info("Before the JSF Phase >>>>>>>> " + event.getPhaseId());
    }

    /**
     * Executes after a JSF phase.
     *
     * @param event The PhaseEvent object representing the phase change event.
     */
    @Override
    public void afterPhase(PhaseEvent event) {
        LOG.info("After the JSF Phase >>>>>>>> " + event.getPhaseId());
        if (event.getPhaseId() == PhaseId.RENDER_RESPONSE) {
            LOG.info("################################ JSF REQUEST IS DONE ################################");
        }
    }
}
