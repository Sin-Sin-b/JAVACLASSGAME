import java.util.Scanner;
public class Game {
    Scanner scanner = new Scanner(System.in);
  public void run() {
      System.out.println("게임에 오신 것을 환영합니다.");
  while(true) {
      System.out.println("\n🏕️ --- 야영지에 도착했습니다 --- 🏕️");
      System.out.println("무엇을 하시겠습니까?");
      System.out.println("1. 전투 스테이지로 이동");
      System.out.println("2. 상점 이용하기");
      System.out.println("3. 인벤토리 확인");
      System.out.println("4. 내 정보 보기");
      System.out.println("5. 스킬 정비");
      System.out.println("6. 게임 종료");
      System.out.print("선택: ");

      int choice = scanner.nextInt();
      switch (choice) {
          case 1:


              break;
          case 2:
              break;// Player 객체의 상태 표시 메소드 호출
          case 3:
              break;
          case 4:
              break;
          case 5:
              break;
          case 6:
              System.out.println("게임을 종료합니다.");
              return; // run 메소드를 끝내서 프로그램 종료
          default:
              System.out.println("잘못된 입력입니다.");
      }


  }

}
