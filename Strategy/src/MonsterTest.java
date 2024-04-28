import Monsters.Imp;
import Monsters.Kobold;
import Monsters.Monster;
import org.junit.Test;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import static org.junit.Assert.*;

public class MonsterTest {

    // Test for creating an Imp
    @Test
    public void testImpCreation() {
        // Arrange
        HashMap<String, Integer> items = new HashMap<>();
        items.put("gold", 5);
        Integer maxHP = 15;
        Integer xp = 20;

        // Act
        Imp imp = new Imp(maxHP, xp, items);

        // Assert
        assertNotNull(imp);
        assertEquals(maxHP, imp.getMaxHP());
        assertEquals(maxHP, imp.getHp());
        assertEquals(xp, imp.getXp());
        assertNotNull(imp.getItems());
    }

    // Test for creating a Kobold
    @Test
    public void testKoboldCreation() {
        // Arrange
        HashMap<String, Integer> items = new HashMap<>();
        items.put("gold", 5);
        Integer maxHP = 1;
        Integer xp = 5;

        // Act
        Kobold kobold = new Kobold(maxHP, xp, items);

        // Assert
        assertNotNull(kobold);
        assertEquals(maxHP, kobold.getMaxHP());
        assertEquals(maxHP, kobold.getHp());
        assertEquals(xp, kobold.getXp());
        assertNotNull(kobold.getItems());
    }

    // Test combat between Imp and Kobold
    @Test
    public void testCombat() {
        // Arrange
        HashMap<String, Integer> items = new HashMap<>();
        items.put("gold", 5);
        List<Monster> monsters  = new ArrayList<>();
        monsters.add(new Imp(15, 20, items));
        monsters.add(new Kobold(1, 5, items));

        // Assert
        while ((monsters.get(0).getHp() > 0 && (monsters.get(1).getHp() > 0))){
            System.out.println(monsters.get(0).attackTarget(monsters.get(1)));
            System.out.println(monsters.get(1).attackTarget(monsters.get(0)));
        }

        assertTrue(monsters.get(0).getHp() <= 0 || monsters.get(1).getHp() <= 0);
    }
}