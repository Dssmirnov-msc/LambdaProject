/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mephi.smirnov.lambdaproject;

/**
 *
 * @author Dmitry
 */
public class CharacterCreator {
    private final String[] male_names;
    private final String[] male_surnames;
    private final String[] female_names;
    private final String[] female_surnames;
    
    public CharacterCreator() {
        // Я потом перенесу списки в JSON, а пока мн лень
        male_names = new String[]{"Michael", "David"};
        male_surnames = new String[]{"Michaelson", "Davidson"};
        female_names = new String[]{};
        female_surnames = new String[]{};
    }
    
    public Character createMethuselah(Clan clan){
        String name = null;
        String surname = null;
        
        Character meth = new Character(name, surname, clan, 4);
        
        return meth;
    }
    
}
