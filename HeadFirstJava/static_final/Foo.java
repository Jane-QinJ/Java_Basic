//通过编译 在非静态方法中调用静态变量
public class Foo{
    static int x;
    public void go(){
	System.out.println(x + "success");
}
public static void main(String[] args){
//	Foo.go(); 静态方法不能引用非静态方法
}
}