package 工厂模式.简单工厂;

import 工厂模式.简单工厂.canned.CannedApple;

public class Application {
    public static void main(String[] args) {
        Cannery cannery = Cannery.getInstance();
        CannedApple apple = cannery.getCanned(CannedApple.class);
        apple.open();
    }
}
