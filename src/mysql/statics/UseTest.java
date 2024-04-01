package mysql.statics;

public class UseTest {
    public static void main(String[] args) {
        Test x = new Test();
        Test y = new Test();

        x.a = 10;
        x.b = 20;

        y.a = 30;
        y.b = 40;

        Test.b = 60;

        System.out.println(x.a);
        System.out.println(x.b);
    }
}
