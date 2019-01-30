// 非静态方法能否存取(access)final变量
public class Foo3{
 
   static final int x ;
       static {
        x = 0;
}
    public void go(){
        System.out.print(x);
}
public static void main(String[] args){}

}