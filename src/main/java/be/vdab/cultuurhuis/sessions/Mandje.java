package be.vdab.cultuurhuis.sessions;

import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.SessionScope;

import java.io.Serializable;
import java.util.*;

@Component
@SessionScope
public class Mandje implements Serializable {

    private static final long serialVersionUID = 1L;

    private final Map<Long, Integer> reserveringen;

    public Mandje() {
        this.reserveringen = new HashMap<>();
    }

    public void voegToe(long id, int aantal) {

        if (reserveringen.containsKey(id)) {
            int huidigAantal = reserveringen.get(id);
            reserveringen.replace(id, huidigAantal + aantal);
        } else {
            reserveringen.put(id, aantal);
        }

    }

    public void remove(long id) {
        if (reserveringen.containsKey(id)) {
            reserveringen.remove(id);
        }
    }

    public Map<Long, Integer> getReserveringen() {
        return Collections.unmodifiableMap(reserveringen);
    }


    public boolean isGevuld() {
        return ! reserveringen.isEmpty();
    }

    @Override
    public String toString() {
        return "Mandje{" +
                "reservaties=" + reserveringen +
                '}';
    }
}
