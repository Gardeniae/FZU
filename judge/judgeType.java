package FZU.judge;

public class judgeType {
    //输入类型判断
    /*
        设置变量inputs用于存放前端输入的数据
        函数setInput()用于设置inputs变量
        设置变量flags用于区分不同类型数据
        设置judgeX()用于判断inputs数据类型并返回flags的值
        flags = 0 /小写数字
                1 /大写数字
     */
    private String inputs;
    public int flags = -2;
    public static char[] basNum = {'零','壹','贰','叁','肆','伍','陆','柒','捌','玖','拾','佰','仟','万','亿','元','整'};
    public static char[] basNum1 = {'零','壹','贰','叁','肆','伍','陆','柒','捌','玖'};
    public static String basNum2 = "零壹贰叁肆伍陆柒捌玖拾佰仟万亿元整";
    private void setInput(String input){
        inputs = input;
    }

    public static boolean isNumeric(String str){
        for (int i = str.length();--i>=0;){
            if (!Character.isDigit(str.charAt(i))){
                return false;
            }
        }
        return true;
    }


    public boolean contain(char temp){
        int i;
        int flag = -1;
        int len = basNum.length;
        for(i = 0;i < len;i++){
            if(temp == basNum[i])
                    flag = 0;
        }
        return flag != -1;
    }
    public boolean isBas(char temp){
        for (char c : basNum1) {
            if (temp == c)
                return true;
        }
        return false;
    }
    public boolean Next(){
        int i;
        int len = inputs.length();
        for(i = 0 ; i < len-1; i++){
            char temp1 = inputs.charAt(i);
            if(isBas(temp1)){
                char temp2 = inputs.charAt(i+1);
                for (char c : basNum1) {
                    if (temp2 == c)
                        return false;
                }
            }
        }
        return true;
    }
    public int judgeX(String input){
        setInput(input);
        if(isNumeric(inputs)){//判断是否只含有数字
            if(inputs.charAt(0) == '0'){ //判断首位是否为0
                flags = -1;
                return flags;
            }
            flags = 0;//是小写
        }

        else{//判断大写
            if(inputs.contains(" ")){//判断是否有空格
                flags = -1;
                return flags;
            }
            else{//判断inputx中的汉字是否在basNum中
                int i;
                int len = inputs.length();
                 for(i = 0;i < len;i++){
                     char temp = inputs.charAt(i);
                     if(!contain(temp)){
                         flags = -1;
                         return flags;
                     }
                 }
            }
            if(!Next()){//判断0~9是否相连
                System.out.println("！！！！");
                flags = -1;
                return flags;
            }
            flags = 1;//是大写
        }
        return flags;
    }

}
