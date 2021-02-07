package Qmetry;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.RUNTIME)
public @interface QmetryTestCase {
    boolean logTicketReady();
}
