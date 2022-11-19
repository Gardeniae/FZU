package com.example.service;

public class transform {
    public static String op(String num)
    {
        String res="";
        char [] str1=new char[]{'零','壹','贰','叁','肆','伍','陆','柒','捌','玖'};
        for (int i = 0; i < num.length(); i++) {
            char c = num.charAt(i);
            for (int j = 0; j < 10; j++) {
                if (c == str1[j]) {
                    res = res + j;
                }
            }
            if (c == '拾') {
                char s = num.charAt(i + 1);
                boolean flag = false;
                for (int k = 0; k < 10; k++) {
                    if (s == str1[k]) flag = true;
                }
                if (!flag) res = res + 0;
            }
        }
        return res;
    }
}
