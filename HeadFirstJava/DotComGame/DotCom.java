import java.util.*;

public class DotCom{
	/*DotCom的实例变量*/
	private ArrayList<String> locationCells; //保存位置的ArrayList
	private String name; //DotCom  的名称

	public void setLocationCells(ArrayList<String> loc){ //更新DotCom位置的set方法
		locationCells = loc;
}
	public void setName(String n){
		name  = n;
}

public String checkYourself(String userInput){
	String result = "miss";
	int index = locationCells.indexOf(userInput); //indexOf()方法， 玩家猜中，返回位置， 猜不中返回-1
	if(index >= 0){
	    locationCells.remove(index); //删除被猜中的元素
	
	if(locationCells.isEmpty()){
	    result = "kill";
	    System.out.println("Ouch! You sunk " + name + ": <");
}else{
	result = "hit";
}//close if
} // close if
return result;
	
}//close method
}//close class