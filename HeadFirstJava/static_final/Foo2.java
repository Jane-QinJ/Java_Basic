//静态方法中调用实例变量 编译报错
public class Foo2{
    int x;
    public static void go(){
        System.out.println(x);
}
    public static void main(String[] args){

}
}