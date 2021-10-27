package 工厂模式.简单工厂.canned;

import 工厂模式.简单工厂.Canned;

public class CannedApple implements Canned {
    @Override
    public void open() {
        System.out.println("canned apple has been opened");
    }
}
