import java.util.*;

public class DotCom{
	/*DotCom��ʵ������*/
	private ArrayList<String> locationCells; //����λ�õ�ArrayList
	private String name; //DotCom  ������

	public void setLocationCells(ArrayList<String> loc){ //����DotComλ�õ�set����
		locationCells = loc;
}
	public void setName(String n){
		name  = n;
}

public String checkYourself(String userInput){
	String result = "miss";
	int index = locationCells.indexOf(userInput); //indexOf()������ ��Ҳ��У�����λ�ã� �²��з���-1
	if(index >= 0){
	    locationCells.remove(index); //ɾ�������е�Ԫ��
	
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