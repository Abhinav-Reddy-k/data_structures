package com.company;

public class Main {

    public static void main(String[] args) {
/*
        String input = "()()()";
        boolean out = Expression.isBalenced(input);
        System.out.println(out);

        Array numbers = new Array(2);
        numbers.insert(1);
        numbers.insert(2);
        numbers.insert(3);
        System.out.println(numbers.indexOf(2));
        numbers.removeAt(2);
        numbers.print();

        DYNAMIC ARRAY
        ArrayList<Integer> list = new ArrayList<>();
        list.add(1);
        System.out.println(list);
        LINKEDLIST in Library
        var linked = new LinkedList<>();
        linked.addLast(1);
        linked.addFirst("Abhi");
        System.out.println(linked);
        LINKEDLIST FROM COM.COMPANY
        var linked_list = new LinkedList();
        linked_list.addLast(10);
        linked_list.addLast(30);
        linked_list.addLast(80);
        linked_list.addLast(80);
        linked_list.addFirst(110);
        linked_list.removeFirst();
        System.out.println(linked_list.indexOf(10));
        QUEUE

        Queue<Integer> queue = new ArrayDeque<>();
        queue.add(1);
        queue.add(2);
        reverse(queue);

        ArrayQueue queue = new ArrayQueue(3);
        queue.add(4);
        queue.add(5);
        queue.add(2);
        queue.remove();
        queue.remove();
        queue.add(3);
        queue.remove();
        queue.remove();
        queue.add(23);
        System.out.println(queue.toString());
        System.out.println(queue.peek());
        System.out.println(queue.isEmpty());
    }

    public static void reverse(Queue<Integer> queue){
        var stack = new Stack<Integer>();
        while(!queue.isEmpty())
            stack.push(queue.remove());
        while (!stack.isEmpty())
            queue.add(stack.pop());
        System.out.println(queue);
    }
*/
/*
        first_rep("abhinav");
    }

    public static void first_rep(String sentence) {
        Map<Character,Integer> map = new HashMap<>();
        for(var ch : sentence.toCharArray()){
            var count = map.getOrDefault(ch, 0);
            map.put(ch,count+1);
        }
        System.out.println(map);
*/
/*
        HashMap order = new HashMap();
        order.put(1,"vettel");
        order.put(1,"vet");
        order.put(2,"ham");
        order.put(3,"bot");
        order.put(6,"alex");
        order.put(4,"ver");
        order.remove(6);
        System.out.println(order.get(6));
*/
/*
        var tree = new BTree();
        tree.insert(10);
        tree.insert(8);
        tree.insert(12);
        tree.insert(9);
        tree.insert(11);
        tree.insert(15);
        tree.insert(1);
        tree.insert(70);
        tree.insert(60);
        tree.insert(50);
        tree.insert(40);

        var tree2 = new BTree();
        tree2.insert(10);
        tree2.insert(8);
        tree2.insert(12);
        tree2.insert(9);
        tree2.insert(11);
        tree2.insert(15);
        tree2.insert(1);
//        tree.traverseInOrder();
//        tree.nodeAtDistance(1);
        System.out.println(tree.height(null));
*/
        var avltree = new AVLTree();
        avltree.insert(10);
        avltree.insert(9);
        avltree.insert(8);
    }
}
