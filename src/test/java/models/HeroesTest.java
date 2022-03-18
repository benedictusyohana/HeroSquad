package models;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class HeroesTest {

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
        Heroes.clearAllHeroes();
    }

    @Test
    public void instantiatesHeroObjectsCorrectly_true() {
        Heroes hero = new Heroes("Emma", 20, "last-minute", "procrastination");
        assertTrue(true);
    }

    @Test
    public void returnsHeroNameCorrectly_String() {
        Heroes hero = new Heroes("Emma", 20, "last-minute", "procrastination");
        assertEquals("Emma", hero.getName());
    }

    @Test
    public void returnsHeroAgeCorrectly_int() {
        Heroes hero = new Heroes("Emma", 20, "last-minute", "procrastination");
        assertEquals(20, hero.getAge());
    }

    @Test
    public void returnsHeroPowerCorrectly_String() {
        Heroes hero = new Heroes("Emma", 20, "last-minute", "procrastination");
        assertEquals("last-minute", hero.getPower());
    }

    @Test
    public void returnsHeroWeaknessCorrectly_String() {
        Heroes hero = new Heroes("Emma", 20, "last-minute", "procrastination");
        assertEquals("procrastination", hero.getWeakness());
    }

    @Test
    public void allHeroesAreCorrectlyReturned_int() {
        Heroes hero = new Heroes("Emma", 20, "last-minute", "procrastination");
        Heroes otherHero = new Heroes ("Joy", 30, "coding", "debugging");
        assertEquals(2, Heroes.getAllInstances().size());
    }

    @Test
    public void allHeroesContainsAllHeroesObjects_true() {
        Heroes hero = new Heroes("Emma", 20, "last-minute", "procrastination");
        Heroes otherHero = new Heroes ("Joy", 30, "coding", "debugging");
        assertTrue(Heroes.getAllInstances().contains(hero));
        assertTrue(Heroes.getAllInstances().contains(otherHero));
    }

    @Test
    public void checkIfNewlyCreatedHeroIsSquadMember_false() {
        Heroes hero = new Heroes("Emma", 20, "last-minute", "procrastination");
        assertFalse(hero.isSquadMember());
    }

    @Test
    public void deletesSpecifiedHero() {
        Heroes hero = new Heroes("Emma", 20, "last-minute", "procrastination");
        Heroes otherHero = new Heroes ("Joy", 30, "coding", "debugging");
        otherHero.deleteHero();
        assertEquals(1, Heroes.getAllInstances().size());
        assertEquals(Heroes.getId(), 2);
    }

    @Test
    public void deletesAllHeroes() {
        Heroes hero = new Heroes("Emma", 20, "last-minute", "procrastination");
        Heroes otherHero = new Heroes ("Joy", 30, "coding", "debugging");
        Heroes.clearAllHeroes();
        assertEquals(0, Heroes.getAllInstances().size());
    }

    @Test
    public void findHeroById() throws Exception {
        Heroes hero = new Heroes("Emma", 20, "last-minute", "procrastination");
        Heroes secondHero = new Heroes ("Joy", 30, "coding", "debugging");
        Heroes foundHero = Heroes.findById(1);
        Heroes foundSecondHero = Heroes.findById(2);
        assertEquals(hero, foundHero);
        assertEquals(secondHero, foundSecondHero);
    }


}
