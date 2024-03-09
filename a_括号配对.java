import java.util.HashMap;
import java.util.Stack;

public class a_括号配对 {
    public static void main(String[] args) {
        String s = "[]{}[]()";
        System.out.println(isValid(s));
    }
    public static boolean isValid(String s){
        int n = s.length();
        if(n % 2 == 1){return  false;}
        //键值对
        HashMap<Character,Character> map = new HashMap<>();
        map.put(']','[');
        map.put('}','{');
        map.put(')','(');
        //临时栈
        Stack<Character> stack = new Stack<>();
        for(int i=0; i<n; i++){
            Character ch = s.charAt(i);
            if(map.containsKey(ch)){
                if(stack.isEmpty() || stack.peek() != map.get(ch)){
                    return false;
                }
                stack.pop();
            }else {
                stack.push(ch);
            }
        }
        return stack.isEmpty();
    }
}

/**考察内容：栈、哈希表、字符串
 * 栈      [栈接口，push(),peak(),pop()]
 * 哈希表   [put(key,value),containsKey(key),get(key)]
 * 字符串   [chatAt(i)]
 * 巧思：①key和value对换  -- > 这样就可避免value无法找key问题
 *      ②是"],},)"并且对上了，出栈；否则直接入栈
 */
