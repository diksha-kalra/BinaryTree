package com.cg.bst;

public class MyBinaryTree<K extends Comparable<K>> {
	private BinaryNode<K> root;

	public void add(K key) {
		this.root = this.addRecursively(root, key);
	}

	private BinaryNode<K> addRecursively(BinaryNode<K> current, K key) {
		if (current == null)
			return new BinaryNode<K>(key);
		int compResult = key.compareTo(current.key);
		if (compResult == 0)
			return current;
		if (compResult < 0) // if current>key -> left
			current.left = addRecursively(current.left, key);
		if (compResult > 0) // current<key ->right
			current.right = addRecursively(current.right, key);
		return current;
	}

	public int getSize() {
		return this.getSizeRecursively(root);
	}

	private int getSizeRecursively(BinaryNode<K> current) {
		return current == null ? 0 : 1 + this.getSizeRecursively(current.left) + this.getSizeRecursively(current.right);
	}

	public K search(K key) {
		return key = this.searchRecursively(root, key);
	}

	private K searchRecursively(BinaryNode<K> current, K key) {
		K searchKey = null;
		if (current == null || current.key == key)
			return current.key;
		int compResult = key.compareTo(current.key);
		if (compResult < 0)
			searchKey = searchRecursively(current.left, key);
		if (compResult > 0)
			searchKey = searchRecursively(current.right, key);
		return searchKey;
	}
}