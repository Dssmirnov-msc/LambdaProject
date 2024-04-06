/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mephi.smirnov.lambdaproject;

import com.mephi.smirnov.lambdaproject.map.Region;
import com.mephi.smirnov.lambdaproject.chars.Character;
import java.util.ArrayList;

/**
 *
 * @author Dima
 */
public class World {
    
    ArrayList<Region> regions;
    ArrayList<Character> characters;
    ArrayList<Organization> organizations;
    ArrayList<Clan> clans;
    
    
    public World() {
        regions = new ArrayList<>();
    }
    
    
    
    
    public void addRegion(Region region){
        regions.add(region);
    }

    public void addOrganization(Organization organization) {
        organizations.add(organization);
    }
}
