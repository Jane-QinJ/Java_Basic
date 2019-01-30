public class Foo6{
    int x = 12;
    public static void go(final int x){
        System.out.println(x);
}
public static void main(String[] args){
    Foo6 foo = new Foo6();
    foo.go(5);
}
}