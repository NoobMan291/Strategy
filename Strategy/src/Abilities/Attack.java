package Abilities;

import Monsters.*;

public abstract interface Attack extends Ability {

    public abstract Integer attack(Monster target);
}
