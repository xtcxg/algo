package 单例模式.内部类;

public class Singleton {
    private static class Inside {
        private static final Singleton INSTANCE = new Singleton();
    }
    public static Singleton getInstance() {
        return Inside.INSTANCE;
    }
}
