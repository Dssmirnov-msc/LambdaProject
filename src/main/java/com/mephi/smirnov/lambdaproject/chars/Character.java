/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mephi.smirnov.lambdaproject.chars;

import com.mephi.smirnov.lambdaproject.Clan;

/**
 *
 * @author Dima
 */
public class Character {
    
    private String name;
    private String surname; 
    private Clan clan; 
    private int generation;
    private int hungerLevel;
    
    Character(String name, String surname, Clan clan, int generation) {
        this.name = name;
        this.surname = surname;
        this.clan = clan;
        this.generation = generation;
    }
    
}
