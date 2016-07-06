package recursionfun;

/**
 * Created by amartinez on 7/5/16.
 */
public class MyLinkedListImpls {

    public static void main(String[] args) {
        Node head = new Node("A",new Node("B",new Node("C",null)));
        //Node head = new Node("A",null);
        head = MyLinkedListImpls.reverseLinkedList(head);
        Node cursor = head;
        while(cursor != null){
            System.out.println("Data: " + cursor.getData());
            cursor = cursor.getNext();
        }
        System.out.println("Finished Reverse Linked List.");

    }

    //precondition: head node is not an empty list
    public static void insertSecond(Node head, String value) {

        head.setNext(new Node(value,head.getNext()));

    }

    //precondition: head node is not an empty list
    public static Node reverseLinkedList(Node head) {

        //just is case user doesn't pay attention to precondition
        if(head == null)
            return head;

        //copy head pointer
        Node prevNode = head;

        while(head.getNext() != null) {

            Node nextNode = head.getNext();

            //only on first node to we set 'next' to null (i.e. now end node)
            if(prevNode == head)
                head.setNext(null);
            else
                head.setNext(prevNode);

            //set head to current node
            prevNode = head;
            head = nextNode;
        }

        //head is pointing to new first, but need to set next if not equal prevNode
        if(prevNode != head)
            head.setNext(prevNode);

        return head;
    }



}
