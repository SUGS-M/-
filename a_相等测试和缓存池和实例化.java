public class a_相等测试和缓存池和实例化 {
    public static void main(String[] args) {
        //在缓存池外
        Integer a = 1000;
        Integer b = 1000;
        System.out.println(a == b);            //false   比较地址
        System.out.println(a.equals(b));       //true    比较内容

        //在缓存池内[指向同一处地址]
        Integer c = 100;
        Integer d = 100;
        System.out.println(c == d);            //ture   比较地址
        System.out.println(c.equals(d));       //true    比较内容


        int e = 100;
        Integer f = 100;
        System.out.println(e == f);            //ture   自动拆箱[成了基本类型比较]
        System.out.println("1");               
        System.out.println(f == e);            //ture   自动拆箱[成了基本类型比较]
        System.out.println(f.equals(e));       //true   自动装箱[成了包装类比较]

        int g = 1000;
        int h = 1000;
        System.out.println(g == h);            //ture


        String s1 = "111";
        String s2 = new String("111");
        System.out.println(s1 == s2);          //fasle[会创建一个新的字符串对象，无论字符串常量池中是否已经存在相同的内容]
        System.out.println(s1.equals(s2));     //true

        //字符串缓存池
        String s11 = "111";
        String s22 = "111";
        System.out.println(s11 == s22);          //true
        System.out.println(s11.equals(s22));     //true

        String s111 = new String("111");
        String s222 = new String("111");
        System.out.println(s111 == s222);          //fasle
        System.out.println(s111.equals(s222));     //true


    }
}
