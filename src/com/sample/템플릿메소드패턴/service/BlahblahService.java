package com.sample.템플릿메소드패턴.service;

import com.sample.템플릿메소드패턴.dto.SomethingCondition;
import com.sample.템플릿메소드패턴.dto.ResStatistic;
import com.sample.템플릿메소드패턴.entity.OriginStaticEntity;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

public class BlahblahService {

    public List<OriginStaticEntity> search(SomethingCondition condition) {
        return selectSomething();
    }

    public List<ResStatistic> search(SomethingCondition condition, Function<OriginStaticEntity, ResStatistic> extraLogic) {
        List<ResStatistic> answerList = new ArrayList<>();

        List<OriginStaticEntity> originStaticEntities = selectSomething();
        for (OriginStaticEntity originStaticEntity : originStaticEntities) {
            answerList.add(extraLogic.apply(originStaticEntity));
        }

        return answerList;
    }

    private List<OriginStaticEntity> selectSomething(){

        List<OriginStaticEntity> list = new ArrayList<>();
        for (int i = 0; i < 20; i++) {
            OriginStaticEntity originStaticEntity = new OriginStaticEntity();
            originStaticEntity.id = i + 1;
            originStaticEntity.cost = (int) (Math.random() * 100);
            originStaticEntity.fee = (int) (originStaticEntity.cost * Math.random());
            list.add(originStaticEntity);
        }

        return list;
    }
}
