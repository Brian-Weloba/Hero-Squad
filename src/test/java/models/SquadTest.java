package models;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class SquadTest {

    @Test
    public void SquadInstantiatesWithContent_true() {
        Squad squad = new Squad("Avengers");
        assertEquals("Avengers", squad.getSquadName());
    }

    @Test
    public void all_ReturnsAllInstancesOfSquads_true() {
        Squad squad = new Squad("Avengers", "World Peace", 5);
        Squad squad2 = new Squad("Hydra", "World Domination", 7);
        assertTrue(Squad.getSquads().contains(squad2));
        assertTrue(Squad.getSquads().contains(squad));

    }

    @Test
    public void findReturnsCorrectSquad() {
        Squad.clearAllSquads();
        Squad squad = new Squad("Avengers", "World Peace", 5);
        assertEquals(1, Squad.findById(squad.getId()).getId());
    }

    @Test
    public void findReturnsCorrectlyWhenMoreThanOneSquadExists() {
        Squad.clearAllSquads();
        Squad squad = new Squad("Avengers", "World Peace", 5);
        Squad squad2 = new Squad("Hydra", "World Domination", 7);
        assertEquals(2, Squad.findById(squad2.getId()).getId());
    }

}