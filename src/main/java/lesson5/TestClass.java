package lesson5;

public class TestClass {
    public static void main(String[] args) {
        testLinkedListIterator();
    }

    private static void testLinkedListIterator(){
        MyLinkedList<Integer> list = new MyLinkedList<>();
        LinkedListIterator<Integer> iterator = new LinkedListIterator<>(list);

        iterator.insertAfter(3);
        iterator.insertBefore(5);
        iterator.insertAfter(0);
        iterator.insertBefore(1);
        System.out.println("Test linked list iterator.");
        list.display();
        System.out.println("Delete current element: " + iterator.deleteCurrent());
        list.display();

        System.out.println("Test foreach for linked list.");
        for (Integer item: list) {
            System.out.println(item);
        }
    }
}

