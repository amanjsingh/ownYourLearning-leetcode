package main.dailyChallenge.linkedList;

public class ReverseSubList {
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        ListNode itr = head;
        for(int i=2; i<=10; i++){
            itr.next = new ListNode(i);
            itr = itr.next;
        }
        PrintList printer = new PrintList();

        printer.printList(head);

        ListNode newHead = new ReverseSubList().reverseBetween(head,3,7);

        printer.printList(head);
    }

    public ListNode reverseBetween(ListNode head, int left, int right) {
        ListNode curr=head, prev=null, next=null, leftJoin=null, rightJoin=null;
        while(left>1){
            prev = curr;
            curr = curr.next;
            left--;
            right--;
        }

        leftJoin = prev;
        rightJoin = curr;

        while(right>0){
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
            right--;
        }
        if(leftJoin != null){
            leftJoin.next = prev;
        }else{
            head = prev; //leftJoin=null -> Start reversal from first element
        }

        rightJoin.next = curr;

        return head;
    }
}
