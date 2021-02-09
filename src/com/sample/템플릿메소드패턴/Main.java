package com.sample.템플릿메소드패턴;

import com.sample.템플릿메소드패턴.dto.ResStatistic;
import com.sample.템플릿메소드패턴.dto.SomethingCondition;
import com.sample.템플릿메소드패턴.service.BlahblahService;

import java.util.List;

/*
* 템플릿 메소드 패턴
* 대부분 재사용되면서 특정부분만 변경이 이루어질때 특정부분을 사용하는 쪽에서 정의할수 있도록 하는 패턴.
* 변하는 부분을 함수로 구현후 해당 함수를 인자로 넘기는 구현도 있을수 있고
* 누군가 해당 부분을 상속받아 재정의 하는 형태로도 가능.
* 페이징같은거에 쓸수있으면 좋을듯
* */

/*
* 여기서 제시하는 예제는 함수를 인자로 넘기는 형태로 작성.
* 프레임워크처럼 큰 프로그램을 만드는게 아니고 단순 서비스 로직을 작성한다면
* 이러한 경우가 더 많을거라 판단.
* */

public class Main {

    public static void main(String[] args) {
        BlahblahService blahblahService = new BlahblahService();

        List<ResStatistic> searchResult = blahblahService.search(
                new SomethingCondition(),
                originEntity -> {
                    ResStatistic resStatistic = new ResStatistic();
                    resStatistic.id = originEntity.id;
                    resStatistic.cost = originEntity.cost - originEntity.fee;

                    //blahblah
                    //뭔가 더 복잡한 로직
                    //...
                    //...
                    //이정도 로직은 반환용 dto로 변환할때 바꿔도 될것같긴한데...더 잘 어울리는 예제가 생각이 안남
                    return resStatistic;
                });

        for (ResStatistic resStatistic : searchResult) {
            //기획자의 기획에 따라 수시로 수수료 포함여부, 환율적용여부 등이 바뀐다는 가정.
            // dto객체의 변수 이름을 기획자의 요구사항에 맞게 수시로 바꿀경우 프론트에서도 작업을 해줘야 하기 때문에
            // 변수의 이름이 포괄적인 의미를 갖도록 네이밍 됨. 해당 내용은 클린코드 책에도 있기떄문에 참고.
            System.out.printf("select id : %d, cost: %d", resStatistic.id, resStatistic.cost);
            System.out.println();
        }
    }
}
