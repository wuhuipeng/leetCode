package cn.hereyou.link;

import java.util.HashSet;
import java.util.Set;

public class RingLinked {


    public boolean hasCycle(ListNode head) {
        int num = 0;
        while(head!=null){
            head = head.next;
            num++;
            if(num>10000){
                return true;
            }
        }
        return false;
    }

    //1.遍历链表节点，如果有节点被遍历两次，就说明存在环形链表，使用了哈希表，空间复杂度O(n)
    public boolean hasCycle2(ListNode head) {
        Set<ListNode> nodeSet = new HashSet<>();
        while (head != null) {
            if (!nodeSet.add(head)) {
                return true;
            }
            head = head.next;
        }
        return false;
    }
//思路： 每遍历一个Node，就将next指向自己，如果发现Node的next等于Node本身，就说明曾经来过，也就证明存在循环列表。
    public boolean hasCycle3(ListNode head) {
        while(head !=null && head.next !=null){
            ListNode node = head.next;
            if(node == head ){
                return true;
            }
            head.next = head;
            head = node;
        }
        return false;
    }
    public static void main(String[] args) {



    }
}
   class ListNode {
       int val;
       ListNode next;
       ListNode(int x) {
           val = x;
           next = null;
       }
   }