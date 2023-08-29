package hello.core.singleton;

public class SingletonService {

    // 자기 자신을 내부에 private static 으로 가지면 static 영역에 SingletonService 하나만 올라간다
    private static final SingletonService instance = new SingletonService();

    public static SingletonService getInstance() {
        return instance;
    }

    // 생성자를 private로 선언해서 외부에서 new 키워드를 사용한 객체 생성을 못하게 막는다
    private SingletonService() {

    }

    public void logic() {
        System.out.println("싱글톤 객체 로직 호출");
    }
}
