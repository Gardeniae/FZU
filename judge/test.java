package FZU.judge;

import java.util.Scanner;

public class test {
    public static void main(String[] args) {
        judgeType test = new judgeType();
        Scanner scanner = new Scanner(System.in);
        String str;
        while(true){
            System.out.println("输入大小写数字(按q返回)：");
            str = scanner.nextLine();//读取一行数据
            if(str.equals("q")){
                scanner.close();
                return;
            }
            int flag = test.judgeX(str);
            if (flag == 0) System.out.println("输入的是小写数字");
            else if(flag == 1) System.out.println("输入的是大写数字");
            else System.out.println("输入错误");
        }

    }
}
