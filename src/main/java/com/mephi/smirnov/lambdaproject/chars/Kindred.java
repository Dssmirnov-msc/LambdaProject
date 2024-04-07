/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mephi.smirnov.lambdaproject.chars;

import com.mephi.smirnov.lambdaproject.Clan;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;


/**
 *
 * @author Dima
 */
public class Kindred {
    
    
    
    private String name;
    private String surname; 
    private Clan clan; 
    private int generation;
    private int hungerLevel;
    private int id;
    private Calendar embraceYear;
    private int visualAge; 
    private ArrayList<Ability> abilities;
    
    
    Kindred(String name, String surname, Clan clan, int generation) {
        this.name = name;
        this.surname = surname;
        this.clan = clan;
        this.generation = generation;
    }

    Kindred() {
       abilities = new ArrayList<>();
    }

    void addSimpleCharacteristic(String key, String value) {
        switch(key){
            case "id":
                id = Integer.parseInt(value);
                break;
            case "name":
                name = value;
            case "surname":
                surname = value;break;
            case "generation":
                generation = Integer.parseInt(value);break;
            case "embraceYear":
                embraceYear = new GregorianCalendar(Integer.parseInt(value), 0, 0);break;
            case "visualAge":
                visualAge = Integer.parseInt(value);break;
            case "clan": 
                clan = Clan.chooseClan(value);break;
            default:
        }
    }
    
    private void addAbility(String key, String value) {
        int level = Integer.parseInt(value);
        this.abilities.add(Ability.create(key, level));
    }
    
    void addCharacteristic(String key, String value, String coolectionTag) {
        switch(coolectionTag){
            case "abilities":
                addAbility(key,value);
                break;
            default :
                addSimpleCharacteristic(key,value);
        }
    }

    
    
}
