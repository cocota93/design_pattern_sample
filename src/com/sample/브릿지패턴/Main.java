package com.sample.브릿지패턴;

import com.sample.브릿지패턴.handler.Hunting_Method1;
import com.sample.브릿지패턴.handler.Hunting_Method2;
import com.sample.브릿지패턴.vo.Animal;
import com.sample.브릿지패턴.vo.Bird;
import com.sample.브릿지패턴.vo.Tiger;


//아래 링크에 있는 코드를 그대로 옮겨봤다.
//https://lktprogrammer.tistory.com/35
/*
* 설명만 봤을떄는 엄청 그럴듯해보였는데 설명을 곱씹을수록
* 어댑터패턴이랑 큰 차이를 못느끼겠다. 어댑터 패턴 쓰다가 작성되는 코드가 점점 많아져서 구현부쪽에 인터페이스 쫌 많아지면 딱 브릿지패턴 모양 될것같은데...
* 음...
* 내맘대로 다시 정의해보면 '추상화 수준을 통일성있게 맞춰서 코드를 작성하는 패턴' 인것 같다.
* */


public class Main {

    public static void main(String[] args) {
        Animal tiger = new Tiger(new Hunting_Method2());
        Animal bird = new Bird(new Hunting_Method1());

        tiger.hunt();
        System.out.println("--------------");
        bird.hunt();
    }
}
