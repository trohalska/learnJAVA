package exeptions;

import java.util.logging.Level;
import java.util.logging.Logger;

public class LoggerEventIdentifier {
    private static final Logger LOG = Logger.getLogger(LoggerEventIdentifier.class.getName());

    public  void identifyEvent() {
        try {
//            doIdentify();
        } catch (Exception e) {
            LOG.log(Level.SEVERE, "Error while identify event", e);
        }
    }
}
