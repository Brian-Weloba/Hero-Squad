package models;

import org.junit.Test;

import static org.junit.Assert.*;

public class SquadTest {

    @Test
    public void SquadInstantiatesWithContent_true() {
        Squad squad = new Squad("Avengers");
        assertEquals("Avengers",squad.getSquadName());
    }
}