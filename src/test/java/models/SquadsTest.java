package models;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class SquadsTest {

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
        Squads.clearAllSquads();
    }

    @Test
    public void instantiatesSquadObjectsWithHeroObjectsCorrectly_true() {
        ArrayList<Heroes> heroes = new ArrayList<>();
        Squads squad = new Squads("Champions", "fight corruption", 5, heroes);
        assertTrue(true);
    }

    @Test
    public void returnsSquadNameCorrectly_String() {
        ArrayList<Heroes> heroes = new ArrayList<>();
        Squads squad = new Squads("Champions", "fight corruption", 5, heroes);
        assertEquals("Champions", squad.getName());
    }

    @Test
    public void returnsSquadCauseCorrectly_String() {
        ArrayList<Heroes> heroes = new ArrayList<>();
        Squads squad = new Squads("Champions", "fight corruption", 5, heroes);
        assertEquals("fight corruption", squad.getCause());
    }

    @Test
    public void returnsSquadSizeCorrectly_int() {
        ArrayList<Heroes> heroes = new ArrayList<>();
        Squads squad = new Squads("Champions", "fight corruption", 5, heroes);
        assertEquals(5, squad.getSize());
    }

    @Test
    public void returnsSquadHeroesCorrectly_ArrayList() {
        ArrayList<Heroes> heroes = new ArrayList<>();
        Squads squad = new Squads("Champions", "fight corruption", 5, heroes);
        assertEquals(heroes, squad.getHeroes());
    }

    @Test
    public void returnsAllSquadInstancesCorrectly_int() {
        ArrayList<Heroes> heroes = new ArrayList<>();
        Squads squad = new Squads("Champions", "fight corruption", 5, heroes);
        Squads secondSquad = new Squads("Peace-makers", "fight war", 3, heroes);
        Squads thirdSquad = new Squads("Entrepreneurs", "fight unemployment", 2, heroes);
        assertEquals(3, Squads.getSquadInstances().size());
    }

    @Test
    public void squadsContainsAllSquadObjects_true() {
        ArrayList<Heroes> heroes = new ArrayList<>();
        Squads squad = new Squads("Champions", "fight corruption", 5, heroes);
        Squads secondSquad = new Squads("Peace-makers", "fight war", 3, heroes);
        Squads thirdSquad = new Squads("Entrepreneurs", "fight unemployment", 2, heroes);
        assertTrue(Squads.getSquadInstances().contains(squad));
        assertTrue(Squads.getSquadInstances().contains(secondSquad));
        assertTrue(Squads.getSquadInstances().contains(thirdSquad));
    }

    @Test
    public void findSquadById() throws Exception {
        ArrayList<Heroes> heroes = new ArrayList<>();
        Squads squad = new Squads("Champions", "fight corruption", 5, heroes);
        Squads secondSquad = new Squads("Peace-makers", "fight war", 3, heroes);
        Squads thirdSquad = new Squads("Entrepreneurs", "fight unemployment", 2, heroes);
        Squads foundSquad = Squads.findById(1);
        Squads foundSecondSquad = Squads.findById(2);
        Squads foundThirdSquad = Squads.findById(3);
        assertEquals(squad, foundSquad);
        assertEquals(secondSquad, foundSecondSquad);
        assertEquals(thirdSquad, foundThirdSquad);
    }

    @Test
    public void deletesAllSquads() {
        ArrayList<Heroes> heroes = new ArrayList<>();
        Squads squad = new Squads("Champions", "fight corruption", 5, heroes);
        Squads secondSquad = new Squads("Peace-makers", "fight war", 3, heroes);
        Squads.clearAllSquads();
        assertEquals(0, Squads.getSquadInstances().size());
    }
}