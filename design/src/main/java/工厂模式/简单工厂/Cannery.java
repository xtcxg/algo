package 工厂模式.简单工厂;

import 工厂模式.简单工厂.canned.CannedApple;
import 工厂模式.简单工厂.canned.CannedBanana;

public class Cannery {
    private static Cannery cannery = new Cannery();
    private Cannery() {}
    public static Cannery getInstance() {
        return cannery;
    }

    public <T> T getCanned(Class<T> clazz) {
        if ("工厂模式.简单工厂.canned.CannedApple".equals(clazz.getName())) {
            return (T) new CannedApple();
        }
        if ("工厂模式.简单工厂.canned.CannedBanana".equals(clazz.getName())) {
            return (T) new CannedBanana();
        }
        throw new RuntimeException("canned not found");
    }
}
