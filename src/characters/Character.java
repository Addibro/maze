package characters;

import characters.enemies.Enemy;
import terrains.Maze;

/**
 * Created by andreasalme on 2016-08-04.
 */
public abstract class Character implements Explorer {

    // klass-variabler för att definiera max hp för alla objekt som extends Character klassen
    public static final int MAX_HEALTH = 10;

    // klass-variabler för Secret Weapons
    public static  final int CLEVERNESS = 5;
    public static final int SPELL = 4;
    public static final int SWORD = 3;
    public static final int TEETH = 2;
    public static final int CHAINS = 1;
    public static final int UNDEFINED = -1;

    // klass-variabler för att definiera standard värde för fotsteg
    public static final char DEFAULT_FOOTPRINT = '+';

    // instans-variabler för att beskriva karaktären
    private String name;
    private String description;
    private int secretWeapon;
    private int health;
    public char footprint;

    /**
     * Creates a new Character with following characteristics
     * @param name String name
     * @param description String description
     * @param health int health
     * @param secretWeapon int secret weapon
     */
    public Character(String name, String description, int health, int secretWeapon) {
        this.name = name;
        this.description = description;
        this.health = health;
        setSecretWeapon(secretWeapon);
        footprint = DEFAULT_FOOTPRINT;
    }


    public Character(String name, String description, int secretWeapon) {
        this(name, description, MAX_HEALTH, secretWeapon);
    }

    /**
     * Construct a new Character using the specified name, and using undefined value
     * for description and weapon, and a maximum health given by the constant MAX_HEALTH
     * @param name The String to be used as the name
     * @see Enemy
     */
    public Character(String name) {
        this(name, "Unknown description", MAX_HEALTH, UNDEFINED);
    }

    public Character() {
        this("Unknown name", "Unknown description", MAX_HEALTH, UNDEFINED);
    }

    /**
     * Replaces the name with the specified value n.
     * @param n The String to be used as the new name
     */
    public void setName(String n) {
        name = n;
    }
    /**
     * Returns the name of the character
     * @return The String that represents the name of the character
     */
    public String getName() {
        return name;
    }
    /**
     * Replaces the description with the specified value d.
     * @param description The String to be used as the new description
     */
    public void setDescription(String description) {
        this.description = description;
    }
    /**
     * Returns the descriptoin of the character
     * @return The String that represents the description of the character
     */
    public String getDescription() {
        return description;
    }

    public int getSecretWeapon() {
        return secretWeapon;
    }

    /**
     * Replaces the secretWeapon with the specified value sw.
     * @param secretWeapon The int to be used as the secret weapon. Only certain values are
     * allowed: CLEVERNESS, SPELL, SWORD, TEETH, CHAINS
     *
     * @see Character
     */
    public void setSecretWeapon(int secretWeapon) {
        if (       secretWeapon == CLEVERNESS
                || secretWeapon == SPELL
                || secretWeapon == SWORD
                || secretWeapon == TEETH
                || secretWeapon == CHAINS) this.secretWeapon = secretWeapon;
        else {
            this.secretWeapon = UNDEFINED;
        }
    }
    public void setHealth(int health) {
        this.health = health;
    }
    public int getHealth() {
        return health;
    }

    // Andra metoder
    public void resetHealth() {
        health = MAX_HEALTH;
    }

    public void printInfo() {
        String result =
                        "*****************************\n" +
                        "Name: " + name + "\n" +
                        "Description: " + description + "\n" +
                        "Secret Weapon: " + secretWeapon + "\n" +
                        "Health: " + health + "\n" +
                        "Alive?: " + isAlive() + "\n" +
                        "*****************************";
        System.out.println(result);
    }

    /**
     * This method represent the action to combat. Receives an enemy as parameter
     * and calculate combat result subtracting the value of the secret weapons of
     * the opponents. This method does not return any value but it is
     * able to change the value of the health variable depending on the result of
     * the combat. If the result is a positive number, we assume that our character
     * has won the battle, and as a consequence will increase the health points.
     * In the same way, if the number is negative our character will have lost the
     * battle, and as a consequence the character will lose health points.
     * @param enemy The Character that represent the enemy
     */
    public void fight(Character enemy) {
        int result = this.secretWeapon - enemy.secretWeapon;
        System.out.println("result:" + result);
        this.health += result; // result can be negative
    }

    /**
     * This method represent the action to combat. Receives two opponents as parameters
     * and calculate combat result subtracting the value of the secret weapons of
     * the opponents. This method does not return any value but it is
     * able to change the value of the health variable depending on the result of
     * the combat. If the result is a positive number, we assume that our character
     * has won the battle, and as a consequence will increase the health points.
     * In the same way, if the number is negative our character will have lost the
     * battle, and as a consequence the character will lose health points.
     * @param char1 The 1st opponent
     * @param char2 the 2nd opponent
     */
    public void fight(Character char1, Character char2) {
        int battle1 = this.secretWeapon - char1.getSecretWeapon();
        int battle2 = this.secretWeapon - char2.getSecretWeapon();


    }

    /**
     * This method checks if a character is or not alive checking the value of its
     * attribute health. If health is lower than zero the character is dead, in
     * other case is alive
     * @return a boolean value true (if character is alive) or false (if character is dead)
     */
    public boolean isAlive() {
        return health > 0;
    }


    @Override
    public void explore(Maze mazeToExplore) {
        Maze aux = mazeToExplore.clone();
        if (aux.findPathFrom(1, 0)) {
            aux.print(getFootprint());
        } else {
            System.out.println("No solution found!");
        }
    }

    @Override
    public char getFootprint() {
        return footprint;
    }
}