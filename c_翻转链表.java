/**考察内容：
 * ①新建链表[内部类]+②虚拟节点+③新建指针[不动老链表]
 * 后移：node = node.next
 * 指向：node1.next = node2;
 * 遍历: while(cur != null)  while(cur.next != null)
 *
 */

public class c_翻转链表 {
    //内部类[结构体]
    static class ListNode{
        int val;
        ListNode next = null;
        public ListNode(int val){
            this.val = val;
        }
//        public ListNode(int val,ListNode next){
//            this.val = val;
//            this.next = next;
//        }
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);
        head.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        ListNode node = reverseBetween(2,4,head);
        while(node!=null){
            System.out.println(node.val);
            node = node.next;
        }
    }
    public static ListNode reverseBetween(int m, int n, ListNode head){
        //虚拟节点
        ListNode dunmmy = new ListNode(-1);
        dunmmy.next = head;
        //左节点
        ListNode pre = dunmmy;      //好处[不动原链表]
        for(int i=0; i<m; i++){
            pre = pre.next;
        }
        //右节点
        ListNode rightNode = pre;   //好处[不动pre节点]
        for(int i=0; i<n-m+1; i++){
            rightNode = rightNode.next;
        }
        //ToDo
        ListNode leftNode = pre.next;
        ListNode cur = rightNode.next;
        //切片
        pre.next = null;
        rightNode.next = null;
        //翻转链表
        reverse(leftNode);
        //拼接
        pre.next = leftNode;
        leftNode.next = cur;  //?????
        return dunmmy.next;
    }
    public static void reverse(ListNode head){
        ListNode pre = null;
        ListNode cur = head;
        while(cur != null){
            ListNode temp = cur.next;
            cur.next = pre;
            pre = cur;
            cur = temp;
        }

    }
}
