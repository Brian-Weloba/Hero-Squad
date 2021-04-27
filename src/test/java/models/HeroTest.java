package models;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class HeroTest {

    @Test
    public void HeroInstantiatesWithContent_true() {
        Hero hero = new Hero("Captain America", 45, 69, 19, 38, 55, 60, 100, "Hydra", 1);
        assertEquals("Captain America", hero.getName());
    }

    @Test
    public void all_ReturnsAllInstancesOfHeroes_true() {
        Hero hero = new Hero("Captain America", 45, 69, 19, 38, 55, 60, 100, "Hydra", 1);
        Hero hero2 = new Hero("Captain", 45, 69, 19, 38, 55, 60, 100, "Hydra", 1);
        assertTrue(Hero.getAll().contains(hero));
        assertTrue(Hero.getAll().contains(hero2));

    }

    @Test
    public void getId_heroesInstantiateWithAnID_1() {
        Hero.clearAllHeroes();
        Hero hero = new Hero("Captain America", 45, 69, 19, 38, 55, 60, 100, "Hydra", 1);
        assertEquals(1, hero.getId());
    }

    @Test
    public void findReturnsCorrectHero() {
        Hero.clearAllHeroes();
        Hero hero = new Hero("Captain America", 45, 69, 19, 38, 55, 60, 100, "Hydra", 1);
        assertEquals(1, Hero.findById(hero.getId()).getId());
    }

    @Test
    public void findReturnsCorrectlyWhenMoreThanOneHeroExists() {
        Hero.clearAllHeroes();
        Hero hero = new Hero("Captain America", 45, 69, 19, 38, 55, 60, 100, "Hydra", 1);
        Hero hero2 = new Hero("Captain", 45, 69, 19, 38, 55, 60, 100, "Hydra", 1);
        System.out.println(hero2.getId());
        assertEquals(2, Hero.findById(hero2.getId()).getId());
    }

}