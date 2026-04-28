package com.muthu.dataStructur;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class HashMapWithChaining<K,V> {
	private List<LinkedList<Entities<K,V>>> list;
	private int elementsAdded = 0;
	private float loadFactory = 0.5f;
	
	public HashMapWithChaining(){
		this.list = new ArrayList<>();
		for(int i = 0; i < 10;i++) {
			list.add(new LinkedList<>());
		}
	}
	
	private class Entities<K,V>{
		K key;
		V value;
		public Entities(K key,V value){
			this.key =  key;
			this.value = value;
		}
	}
	
	public void put(K key,V value) {
		int hash = Math.abs(key.hashCode() % list.size());
		
		LinkedList<Entities<K, V>> entities = list.get(hash);
		for(Entities entity : entities) {	
			if(entity.key.equals(key)) {
				entity.value = value;
				return;
			}
		}
		if((float)elementsAdded / list.size() > loadFactory) {
			restructure();
		}
		entities.add(new Entities(key, value));
		elementsAdded++;
	}
	
	public V get(K key) {
		int hash = Math.abs(key.hashCode() % list.size());
		LinkedList<Entities<K, V>> entities = list.get(hash);
		for(Entities entity : entities) {	
			if(entity.key.equals(key)) {
				return (V) entity.value;
			}
		}
		return null;
	}
	
	public void remove(K key) {
		int hash = Math.abs(key.hashCode() % list.size());
		LinkedList<Entities<K, V>> entities = list.get(hash);
		Entities entityCur = null;
		for(Entities entity : entities) {	
			if(entity.key.equals(key)) {
				entityCur = entity;
				break;
			}
		}
		entities.remove(entityCur);
		elementsAdded--;
		
	}
	
	public boolean containsKey(K key) {
		return get(key)!=null;
	}
	
	public String toString() {
		int count = 0;
		StringBuilder text = new StringBuilder();
		for(LinkedList<Entities<K, V>> linked: list) {
			for(Entities<K,V>entity : linked) {
				for(int i = 0;i > count;i++) {
					text.append("\t");
				}
				text.append(entity.key + " -->"+entity.value);
				count++;
			}
			count=0;
			text.append("\n");
		}
		return text.toString();
	}
	
	private void restructure() {
		List<LinkedList<Entities<K, V>>> newContainer = list;
		list = new ArrayList<>();
		elementsAdded = 0;
		for(int i = 0; i < newContainer.size() * 2;i++) {
			list.add(new LinkedList<>());
		}
		for(LinkedList<Entities<K,V>> entityLinked : newContainer) {
			for(Entities<K, V> entity:entityLinked) {
				put(entity.key, entity.value);
			}
		}
	}
}
