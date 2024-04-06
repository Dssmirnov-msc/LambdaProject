/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mephi.smirnov.lambdaproject.chars;

import com.mephi.smirnov.lambdaproject.Clan;

/**
 *
 * @author Dmitry
 */
public class KindredCreator {

    
    private final String[] male_names;
    private final String[] male_surnames;
    private final String[] female_names;
    private final String[] female_surnames;
    
    public KindredCreator() {
        // Я потом перенесу списки в JSON, а пока мн лень
        male_names = new String[]{"Michael", "David"};
        male_surnames = new String[]{"Michaelson", "Davidson"};
        female_names = new String[]{};
        female_surnames = new String[]{};
    }
    
    public Kindred createMethuselah(Clan clan){
        String name = null;
        String surname = null;
        
        Kindred meth = new Kindred(name, surname, clan, 4);
        
        return meth;
    }
    public static Kindred create() {
        return new Kindred(); //To change body of generated methods, choose Tools | Templates.
    }
}
