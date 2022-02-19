public class ReverseLinkedList {
    /**
     * Definition for ListNode
     */
      public static class ListNode {
          int val;
          ListNode next;
          ListNode(int x) {
              val = x;
              next = null;
          }
      }
        /**
         * @param head: n
         * @return The new head of reversed linked list.
         */
    public static ListNode reverse(ListNode head) {
        if(head ==null || head.next ==null)
            return head;
        ListNode currentNode = head;
        // print out testing ListNode
        while(currentNode != null){
            System.out.println(currentNode.val);
            currentNode = currentNode.next;
        }
        // null->1->2->3->4->5->null
        //  p    c
        ListNode prev = null;
        ListNode curr = head;
        while(curr !=null){
            // null->1->2->3->4->5->null
            //  p    c  n
            ListNode next = curr.next;

            // null<-1  2->3->4->5->null
            //  p    c  n
            curr.next = prev; // flip the link direction

            // null<-1  2->3->4->5->null
            //       c  n
            //       p
            prev = curr;

            // null<-1  2->3->4->5->null
            //       p  n
            //          c
            curr = next;

        }// the loop will keep moving the 'p''n''c' mechanism
        // null<-1<-2<-3<-4<-5  null
        //                   p  n
        //                      c
        return prev;
    }

    public static void main(String[] args){
        /* Start with the empty list. */
        ListNode nodeSta = new ListNode(0);    // create the start node
        ListNode nextNode;                     //create a intermediate node, referring to the current node
        nextNode=nodeSta;                      //make current node -> start node
        //create a linked list
        for(int i=1;i<4;i++){
            ListNode node = new ListNode(i);  //new node
            nextNode.next=node;               //link the node index with the current node
            nextNode=node;                    //move forward the current node
        } // when the for loop ends, the current node refers to the last one
        nextNode=nodeSta;                     //make the current node refers to the start again
        ListNode ans = reverse(nextNode);
        // print out result ListNode
        System.out.println("reversed linkedList================================================");
        while(ans != null){
            System.out.println(ans.val);
            ans = ans.next;
        }
//        System.out.println(ans);
    }

}
