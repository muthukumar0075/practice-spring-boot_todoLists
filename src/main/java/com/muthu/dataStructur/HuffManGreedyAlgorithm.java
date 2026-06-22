package com.muthu.dataStructur;
import java.util.BitSet;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.PriorityQueue;
import java.util.Queue;

public class HuffManGreedyAlgorithm{
	private Map<Character,String> encoderMap = new HashMap<>();
	private Map<String,Character> decoderMap = new HashMap<>();
	private String bitCode = "";
	class Node implements Comparable<Node>{
		private Character name;
		private Integer frequency;
		private Node left;
		private Node right;
		
		public Node(Character name,Integer frequency) {
			this.name = name;
			this.frequency = frequency;
			this.left = null;
			this.right = null;
		}
		
		public int compareTo(Node node) {
			return this.frequency - node.frequency;
		}
		
		public String toString() {
			return this.name+ "" + this.frequency;
		}
	}
	public void doEncode(String value) {
		Map<Character,Integer> freMap = new HashMap<>();
		
		//creating frequency map
		for(int i = 0;i < value.length();i++) {
			Character keyValue = value.charAt(i);
			if(freMap.containsKey(keyValue)) {
				Integer encodeValue = freMap.get(keyValue);
				freMap.put(keyValue, encodeValue+1);
			}
			else {
				freMap.put(keyValue, 1);
			}
		}
		
		//Creating node and adding in min heap
		Queue<Node> queue = new PriorityQueue<>();
		for(Entry<Character, Integer> map : freMap.entrySet()) {
			Node node = new Node(map.getKey(), map.getValue());
			queue.add(node);
		}
		
		// removing element from queue and combining as one.
		while(queue.size() != 1) {
			Node firstNode = queue.remove();
			Node secondNode = queue.remove();
			Integer total = firstNode.frequency + secondNode.frequency;
			Node node = new Node(null, total);
			node.left = firstNode;
			node.right = secondNode;
			queue.add(node); 
		}
		
		//Combined all node as single node
		Node finalNode = queue.remove();
		// creating the encode and decode value
		for(int i = 0;i < value.length();i++) {
			Character key = value.charAt(i);
			boolean done = true;
			getTheBitSet(key,finalNode,"",done);
			if(!encoderMap.containsKey(key)) {
				encoderMap.put(key, bitCode);
				decoderMap.put(bitCode, key);
			}
		}
		BitSet bitSet = new BitSet();
		int index = 0;
		for(int i = 0;i < value.length();i++) {
			String encodedValue = encoderMap.get(value.charAt(i));
			for(int j = 0;j < encodedValue.length();j++) {
				if(encodedValue.charAt(j) =='1') {
					bitSet.set(index);
				}
				index++;
				//System.out.println(bitSet.toString());
			}
			//System.out.print(encoderMap.get(value.charAt(i)));
		}
		System.out.println(bitSet+ " "+index);
	}
	
	public void decodeTheValue(String value) {
		String decodeValue = "";
		for(int i = 0;i < value.length();i++) {
			decodeValue += value.charAt(i);
			if(decoderMap.containsKey(decodeValue)) {
				System.out.print(decoderMap.get(decodeValue));
				decodeValue = "";
			}
			
		}
		System.out.println();
	}
	
	public void getTheBitSet(Character key,Node finalNode, String bitSet,boolean done) {
			if(finalNode == null) {
				return ;
			}
			
			if(finalNode.name != null && (finalNode.name).equals(key)) {
				bitCode = bitSet;
				return;
			}
			getTheBitSet(key, finalNode.left, bitSet+"0",done);
			getTheBitSet(key, finalNode.right, bitSet+"1",done);
		
	}
	
	public void finalPrintOf(Node finalNode) {
		if(finalNode == null) {
			return;
		}
		System.out.print(finalNode.name +""+ finalNode.frequency);
		finalPrintOf(finalNode.left);
		finalPrintOf(finalNode.right);
	}

}
