package Monsters;

import Abilities.Attack;

import java.util.HashMap;
import java.util.Objects;
import java.util.Random;

public class Monster {

    private Integer hp;
    private Integer xp = 10;
    private Integer maxHP;
    private HashMap<String, Integer> items;

    Integer agility = 10;
    Integer defense = 10;
    Integer strength = 10;
    Attack attack;

    public Monster(Integer maxHP, Integer xp, HashMap<String, Integer> items) {
        this.maxHP = maxHP;
        this.hp = maxHP;
        this.xp = xp;
        this.items = items;
    }

    public Integer getHp() {
        return hp;
    }

    public Integer getXp() {
        return xp;
    }

    public Integer getMaxHP() {
        return maxHP;
    }

    public HashMap<String, Integer> getItems() {
        return items;
    }

    public void setHp(Integer hp) {
        this.hp = hp;
    }

    public void setItems(HashMap<String, Integer> items) {
        this.items = items;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Monster monster = (Monster) o;
        return Objects.equals(getHp(), monster.getHp()) && Objects.equals(getXp(), monster.getXp()) && Objects.equals(getMaxHP(), monster.getMaxHP()) && Objects.equals(getItems(), monster.getItems());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getHp(), getXp(), getMaxHP(), getItems());
    }

    @Override
    public String toString() {
        return "hp=" + getHp() + "/" + getMaxHP();
    }

    public Integer getAgility() {
        return agility;
    }

    public Integer getDefense() {
        return defense;
    }

    public Integer getStrength() {
        return strength;
    }

    Integer getAttribute(Integer min, Integer max){
        Random rand = new Random();
        if (min > max){
            Integer temp = min;
            min = max;
            max = temp;
        }
        return rand.nextInt(max-min) + min;
    }

    boolean takeDamage(Integer damage){
        if (damage > 0){
            System.out.println("The creature was hit for " + damage + " damage");
            if (hp - damage <= 0){
                System.out.println("Oh no! the creature has perished");
                System.out.println(this);
                return false;
            }
            System.out.println(this);
        }
        return true;
    }

    public Integer attackTarget(Monster target){
        Integer att = attack.attack(target);
        target.takeDamage(att);
        return att;

    }

}
