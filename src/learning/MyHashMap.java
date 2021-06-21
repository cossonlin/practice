package learning;

import java.util.Objects;

public class MyHashMap<K, V> {

	private final int bucketSize = 16;

	private Node[] bucket = new Node[bucketSize];

	void put(K key, V value) {
		int index = hash(key) % bucketSize;

		if (bucket[index] == null) {
			bucket[index] = new Node<>(key, value);
			return;
		}
		Node prevNode = bucket[index];
		Node node = prevNode;
		while (true) {
			if (node == null) {
				prevNode.next = new Node<>(key, value);
				return;
			} else {
				if (node.key.equals(key)) {
					node.value = value;
					return;
				} else {
					prevNode = node;
					node = node.next;
				}
			}
		}
	}

	V get(K key) {
		int index = hash(key) % bucketSize;
		Node<K, V> node = bucket[index];
		while (true) {
			if (node == null) {
				return null;
			} else {
				if (node.key.equals(key)) {
					return node.value;
				} else {
					node = node.next;
				}
			}
		}
	}

	private int hash(K key) {
		return Objects.hash(key);
	}

	class Node<K, V> {
		Node<K, V> next;
		K key;
		V value;

		Node(K key, V value) {
			this.key = key;
			this.value = value;
		}
	}
}
