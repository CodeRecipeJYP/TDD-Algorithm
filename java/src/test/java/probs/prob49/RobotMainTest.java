package probs.prob49;

import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

import static org.junit.Assert.*;

public class RobotMainTest {

    @Test
    public void main() {
    }

    @Test
    public void state_equals() {
        RobotMain.State state = new RobotMain.State(0, 0, 0);

        assertTrue(state.equals(new RobotMain.State(0, 0, 0)));
        assertFalse(state.equals(new RobotMain.State(0, 0, 1)));

        Set<RobotMain.State> set = new HashSet<>();
        set.add(state);
        set.add(new RobotMain.State(0, 0, 0));
        assertEquals(1, set.size());
    }
}