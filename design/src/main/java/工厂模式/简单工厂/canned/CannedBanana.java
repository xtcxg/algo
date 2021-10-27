package 工厂模式.简单工厂.canned;

import 工厂模式.简单工厂.Canned;

public class CannedBanana implements Canned {
    @Override
    public void open() {
        System.out.println("canned banana has been opened");
    }
}
