package com.sample.브릿지패턴.vo;

import com.sample.브릿지패턴.handler.Hunting_Handler;

public class Animal {

    private Hunting_Handler hunting;

    public Animal(Hunting_Handler hunting) {
        this.hunting = hunting;
    }

    public void Find_Quarry() {
        hunting.Find_Quarry();
    }

    public void Detected_Quarry() {
        hunting.Detected_Quarry();
    }

    public void attack() {
        hunting.attack();
    }

    public void hunt() {
        Find_Quarry();
        Detected_Quarry();
        attack();
    }
}
