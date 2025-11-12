public class StageList {

    Stage floor4() {
        return new NormalStage("4층", "회사의 4층으로 연구 개발/ 기획 /디자인의 업무를 담당하는 층이다", "일반", 4, 1);
    }

    Stage floor5() {
        return new NormalStage("5층", "회사의 재무 / 회계의 업무를 담당하는 층이다.", "일반", 5, 2);
    }

    Stage floor6() {
        return new BossStage("6층", "회사의 인사 / 총무를 담당하는 층이다.", "중간보스", 6, 3);
    }

    Stage floor7() {
        return new NormalStage("7층", "회사의 영업 / 마케팅을 담당하는 층이다.", "일반", 7, 4);
    }

    Stage floor8() {
        return new BossStage("8층", "회사의 임원진들의 CTO,CFO 등등 임원진이 모여있는 층이다.", "중간보스", 8, 5);
    }

    Stage floor9() {
        return new BossStage("9층", "회사의 대표이사 / 이사회실이 있는 층이다.", "보스", 9, 6);
    }


}
