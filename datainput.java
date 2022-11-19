//数据读入
//第一种
import java.util.*;
public class TestOne {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);   
           while (sc.hasNext()) {
              int[] array = new int[11];
		        for (int i = 0 ; i < 11 ; i ++ ) 
				{
					array[i] = Integer.valueOf(sc.next());
				}		
         }
	}
}

//第二种
import java.util.Scanner;
import java.util.*;
public class TestOne 
{
	public static void main(String[] args) 
    {
	    Scanner sc = new Scanner(System.in) ;
	    String s = sc.nextLine() ;
	    char[] sr = s.toCharArray() ;
	}
}