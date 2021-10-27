package 单例模式;

import 单例模式.枚举.Singleton;

public class Application {
    public static void main(String[] args) {
        Singleton.INSTANCE.dosomething();
    }
}
