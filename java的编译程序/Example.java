/*编译器创建的字节码文件是根据类名确定的，如果和源文件不一致，生成的字节码就是  * Example1.class, 而执行编译 javac Example.java指定的是源文件的名称。
* 1. 编译java程序 （命令行指定的为源文件名称 javac Example.java）
* 2.编译器创建字节码（类的名字.class 本例为Example1.class），包含了Java解释器将要执行的* 指令。javac的输出不是可被直接执行的代码
* 3.实际运行这个程序，要用到称为java的Java解释器。  java Example1(用类名作为一个命令行* 参数传递)
* 编译时使用的是源文件名， 解释执行是用的是类名，所以最好一致， 原文件名的名称匹配.class   * 文件名称(如果类的访问限定符为public 则必须与源文件一致 eg:public class Example{})
*/
class Example1{   //修改类名之前为Example
    public static void main(String[] args){
        System.out.println("This is a simple java program");
    }
}