//问题：替换字符串s中子串src为target,例如s:“ababcd”,src:“ab”,target:“cg”。判断逻辑写冗余
//思路：如何配对[字符串匹配]
public class a_去冗压缩 {
    public static void main(String[] args) {
        String str = "ababcd";
        String sub = "ab";
        //System.out.println(solution1(str1,str2));
        System.out.println(solution(str,sub));
    }
    public static String solution(String str, String sub){
        StringBuilder ans = new StringBuilder();
        int n = str.length();
        int m = sub.length();
        int i = 0;
        //字符串配对
        while(i<n){
            if(n-i < m){
                ans.append(str.charAt(i));       //字符串，不是字符数组
                i++;                             //i++不能忘了，要不不移动了
                continue;
            }
            boolean isMatch = true;
            for(int j=0; j<m; j++){
                if(str.charAt(i+j) != sub.charAt(j)){
                    isMatch = false;
                    break;                       //只找到不相等的开始，那个数据记录到ans中
                }
            }
            //添加一个字符
            if(isMatch){
                i += m; //冗余了，后移m位
            }else{
                ans.append(str.charAt(i));
                i++;
            }

        }
        return ans.toString();
    }





    public static String solution1(String str1, String str2){
        return str1.replace(str2,"");
    }

}
/**考察内容：字符串+变长字符串；字符串匹配
 * 字符串[chatAt(i)]
 * 变长字符串[append(value)，toString]
 * 设计思路[i++]
 */