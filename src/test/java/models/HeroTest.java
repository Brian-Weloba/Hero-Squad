package models;

import org.junit.Test;

import static org.junit.Assert.*;

public class HeroTest {

    @Test
    public void HeroInstantiatesWithContent_true() {
        Hero hero = new Hero("Bob", 22, "Telekinesis","Water");
        assertEquals("Bob",hero.getName());
    }
}