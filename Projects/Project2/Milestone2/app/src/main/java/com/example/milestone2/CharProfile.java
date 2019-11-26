package com.example.milestone2;

import java.io.Serializable;
import java.util.Dictionary;
import java.util.Hashtable;

public class CharProfile implements Serializable {
    public String characterName;
    public String characterClass;
    int level = 1;
    Ability[] abilities = new Ability[6];
    Dictionary skills = new Hashtable();

    CharProfile(String name, String clas) {
        characterName = name;
        characterClass = clas;
        initAbilities();
        initSkills();
    }

    protected class Ability {
        String name;
        int score;
        int mod;

        Ability(String n, int s, int m) {
            name = n;
            score = s;
            mod = m;
        }
    }

    protected class Skill {
        String name;
        int rank;
        int mod;
        int misc;
        int score;

        Skill(String n, int r, int m, int mis) {
            name = n;
            rank = r;
            mod = m;
            misc = mis;
            score = rank + mod + misc;
        }
    }

    private void initAbilities() {
        String[] myAbilities = new String[] {"STR","DEX","CON","INT","WIS","CHA"};
        for(int i = 0; i < abilities.length; i++) {
            abilities[i] = new Ability(myAbilities[i], 10,0);
        }
    }

    private void initSkills() {
        //Initialize empty skills
        //Add each to dictionary
    }
}
