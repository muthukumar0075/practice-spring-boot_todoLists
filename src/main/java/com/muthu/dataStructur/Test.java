package com.muthu.dataStructur;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import com.muthu.dataStructur.MuthuListedList.MuthuNode;

public class Test {
	

	public static void main(String[] args) {
		
		
//		MuthuArrayList<Double> muthuList = new MuthuArrayList<Double>();
//		for(int i = 0; i< 100; i++ ) {
//			muthuList.add(25.5);
//		}
//		System.out.println(muthuList.size());
//		muthuList.set(9, 100.00);
//		System.out.println(muthuList.actualSize());
//		System.out.println(muthuList);
		/*
		 * List<ComparableTesting> compTestArr = new ArrayList<>();
		 * 
		 * compTestArr.add(new ComparableTesting(85,25)); compTestArr.add(new
		 * ComparableTesting(85,26)); compTestArr.add(new ComparableTesting(85,27));
		 * compTestArr.add(new ComparableTesting(85,29)); Comparator<ComparableTesting>
		 * com = (o1, o2) -> (o1.getAge() - o2.getAge());
		 * Collections.sort(compTestArr,com); System.out.println(compTestArr);
		 */
//		int[] arr = {1,2,3};
//		MyException obj1 = new MyException(25, "MuthuKumar",arr);
//		MyException obj2 = null;
//		try {
//			obj2 = (MyException) obj1.getClone();
//			obj2.arr[0] = 5;
//		} catch (CloneNotSupportedException e) {
//			e.printStackTrace();
//		}
//		System.out.println(Arrays.toString(obj1.arr));
		
//		MuthuListedList<Integer> listedList = new MuthuListedList<>();
//		listedList.addLast(10);
//		listedList.addLast(11);
//		listedList.addLast(12);
//		listedList.addAtIndex(1, 7);
//		listedList.addAtIndex(1, 9);
//		System.out.println(listedList);
//		listedList.removeAtIndex(0);
//		System.out.println(listedList);
//		listedList.removeAtIndex(2);
//		System.out.println(listedList);
//		listedList.removeLast();
//		System.out.println(listedList);
////		listedList.removeLast();
////		System.out.println(listedList);
//		System.out.println(listedList.getSize());
		
//		MuthuDoublyListedList<Integer> doublyListedList = new MuthuDoublyListedList<>();
//		doublyListedList.addStart(10);
//		doublyListedList.addStart(10);
//		doublyListedList.addStart(10);
//		doublyListedList.addLast(5);
//		doublyListedList.addAtIndex(2, 6);
//		doublyListedList.addAtIndex(4, 6);
//		doublyListedList.addAtIndex(1, 6);
//		doublyListedList.addAtIndex(0, 6);
//		System.out.println(doublyListedList);
//		System.out.println(doublyListedList.size());
//		MuthuCircularListedList<String> circularListedList = new MuthuCircularListedList<>();
//		circularListedList.addFirst("muthu");
//		circularListedList.addFirst("Sashya");
//		circularListedList.addLast("Kasandra");
//		circularListedList.addLast("Aries");
//		circularListedList.addAtIndex("Unplanned", 0);
//		circularListedList.addAtIndex("Unplanned", 4);
//		circularListedList.addAtIndex("Unplanned", 6);
//		circularListedList.removeLast();
//		circularListedList.removeLast();
//		circularListedList.show();
//		MuthuListedList<Integer> listedList = new MuthuListedList<>();
//		listedList.addLast(4);
//		listedList.addLast(2);
//		listedList.addLast(1);
//		listedList.addLast(3);
//		
//		
//		System.out.println(listedList.toDisplay(listedList.getHead()));
//		listedList.reverseList(listedList.getHead());
//		System.out.println(listedList.toDisplay(listedList.getHead()));
//		StackData<Integer> stack = new StackData<>();
//		stack.add(40);
//		stack.add(30);
//		stack.add(20);
//		stack.add(10);
//		stack.add(40);
//		stack.add(30);
//		stack.add(20);
//		stack.add(10);
//		stack.add(40);
//		stack.add(30);
//		stack.add(20);
//		stack.add(10);
//		System.out.println(stack);
//		stack.remove();
//		System.out.println(stack);
//		DequeData<Integer> deque = new DequeData<>();
//		deque.addFirst(1);
//		deque.addLast(2);
//		deque.addFirst(3);
//		deque.addLast(4);
//		deque.addFirst(5);
//		deque.addLast(6);
//		deque.addFirst(7);
//		deque.addLast(8);
//		System.out.println(deque.toDisplay(deque.head));
//		deque.removeFirst();
//		deque.removeLast();
//		System.out.println(deque.toDisplay(deque.head));
//		deque.removeFirst();
//		deque.removeLast();
//		System.out.println(deque.toDisplay(deque.head));
//		AVLTreeImplementation<Integer> tree = new AVLTreeImplementation<>();
//		for(int i = 0;i< 10;i++) {
//			tree.insertValue(i);
//		}
//		tree.display();
//		BinaryTreeImplementation<Integer> bTree = new BinaryTreeImplementation<>();
//		for(int i = 0;i < 10;i++) {
//			bTree.insertValues(i);
//		}
//		bTree.display();
		SegmentTreeImplementation tree = new SegmentTreeImplementation();
		int[] arr = {1,2,3,4};
		tree.segmentTree(arr); 
		tree.display();
		tree.updateValueOfTree(5,3);
		tree.display();
		
		
		
		
	}
	

}
