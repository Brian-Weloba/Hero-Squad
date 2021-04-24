package models;

import org.junit.Test;

import static org.junit.Assert.*;

public class HeroTest {

    @Test
    public void HeroInstantiatesWithContent_true() {
        Hero hero = new Hero("Captain America", 45, 69,19,38,55,60,100,"Hydra");
        assertEquals("Captain America",hero.getName());
    }

    @Test
    public void all_ReturnsAllInstancesOfHeroes_true() {
        Hero hero = new Hero("Captain America", 45, 69,19,38,55,60,100,"Hydra");
        Hero hero2 = new Hero("Captain", 45, 69,19,38,55,60,100,"Hydra");
        assertTrue(Hero.getAll().contains(hero));
        assertTrue(Hero.getAll().contains(hero2));

    }
}