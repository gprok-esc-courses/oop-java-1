public class Test {
    public static void main(String[] args) {
        System.out.println("Hello World!");

        int a = 5;
        double d  = 6.45;
        boolean b = false;
        char c = 'A';
        String s = "This is a string";

        int [] arr = new int[10];
        arr[0] = 78;
        arr[1] = 109;

        if(a == 5) {
            System.out.println("a is 5");
        }
        else if(a < 5) {
            System.out.println("a less than 5");
        }
        else {
            System.out.println("a greater than 5");
        }

        if(a == 5 || c == 'A') {

        }

        a = 1;
        switch (a) {
            case 1:
                System.out.println("one");
            case 2:
                System.out.println("two");
            case 3:
                System.out.println("three");
            default:
                System.out.println("More than 3");
                break;
        }

        for (int i = 0; i < 10; i++) {
            System.out.println(i);
        }

        int i = 0;
        while (i < 10) {
            System.out.println(i);
            i++;
        }

        i = 0;
        do {
            System.out.println(i);
        } while(i < 10);

        String [] names = {"John", "Ann", "Peter", "Mike", "Mary"};

        for (String name : names) {
            System.out.println(name);
        }
        for (int j = 0; j < names.length; j++) {
            System.out.println(names[j]);
        }
    }
}
