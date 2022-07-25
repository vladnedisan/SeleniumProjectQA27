
public class Main {

    public static void main(String[] args) {
      LoginTest loginTest = new LoginTest();
      loginTest.validLoginTest();


    }

    public static void wait(int seconds) {
        try {
            Thread.sleep(seconds * 1000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

}
