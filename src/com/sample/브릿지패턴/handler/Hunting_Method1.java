package com.sample.브릿지패턴.handler;

public class Hunting_Method1 implements Hunting_Handler {
    public void Find_Quarry() {
        System.out.println("물 위에서 찾는다");
    }

    public void Detected_Quarry() {
        System.out.println("물고기 발견!");
    }

    public void attack() {
        System.out.println("낚아챈다.");
    }
}