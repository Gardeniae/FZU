public class ChangeToChinese {

    public static String int2chineseNum(String src) {
        final String num[] = {"零", "壹", "贰", "叁", "肆", "伍", "陆", "柒", "捌", "玖"};
        final String unit[] = {"", "拾", "佰", "仟", "万", "拾", "佰", "仟", "亿", "拾", "佰", "仟"};
        String dst = "";
        int count = 0;
        int flag=src.length();
        String newStr = new StringBuffer(src).reverse().toString();
        for(int i=0;i<flag;i++) {
            char a=newStr.charAt(i);
            int b=a-'0';
            dst = (num[b] + unit[count]) + dst;
            count++;
        }
        if(flag==1&&newStr.charAt(0)=='0')  return "零元整";
        else    return (dst.replaceAll("零[仟佰拾]", "零").replaceAll("零+万", "万")
                .replaceAll("零+亿", "亿").replaceAll("亿万", "亿零")
                .replaceAll("零+", "零").replaceAll("零$", ""))+"元整";
    }

}
