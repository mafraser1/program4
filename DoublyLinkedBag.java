
public class DoublyLinkedBag<T> implements BagInterface<T> {

    private int size;
    private DoublyLinkedNode first;

    private class DoublyLinkedNode {

        private T data;
        private DoublyLinkedNode next;
        private DoublyLinkedNode prev;

        private DoublyLinkedNode(T input) {
            data = input;
            next = null;
            prev = null;
        }

        private DoublyLinkedNode(T input, DoublyLinkedNode prevNode) {
            data = input;
            prev = prevNode;
        }

        private void clear() {
            data = null;
            next = null;
            prev = null;
        }
    }

    /**
     * Gets the current number of entries in this bag.
     *
     * @return The integer number of entries currently in the bag.
     */
    public int getCurrentSize() {
        return size;
    }

    /**
     * Sees whether this bag is empty.
     *
     * @return True if the bag is empty, or false if not.
     */
    public boolean isEmpty() {
        if (size == 0) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * Adds a new entry to this bag.
     *
     * @param newEntry The object to be added as a new entry.
     * @return True if the addition is successful, or false if not.
     */
    public boolean add(T newEntry) {
        DoublyLinkedNode current;
        current = first;
        while (current.next != null) {
            current = current.next;
            //makes a new node that references the last node as the previous
            //then sets was the last node to reference the new node as the next node

        }
        DoublyLinkedNode newN = new DoublyLinkedNode(newEntry, current);
        current.next = newN;
        size++;
        return true;
    }

    /**
     * Removes one unspecified entry from this bag, if possible.
     *
     * @return Either the removed entry, if the removal. was successful, or
     * null.
     */
    public T remove() {
        T removedItem = first.data;
        first.data = null;
        first = first.next;
        first.prev = null;
        size--;
        return removedItem;

    }

    /**
     * Removes one occurrence of a given entry from this bag.
     *
     * @param anEntry The entry to be removed.
     * @return True if the removal was successful, or false if not.
     */
    public boolean remove(T anEntry) {
        boolean didRemove = false;
        DoublyLinkedNode current = first;
        while (current.next != null && !didRemove) {
            if (current.data == anEntry) {
                current.prev.next = current.next;
                current.next.prev = current.prev;
                current.clear();
                size--;
                didRemove = true;
            }
        }
        return didRemove;
    }
    
    {
        
    }

    /**
     * Removes all entries from this bag.
     */
    public void clear() {
        while (size > 0) {
            this.remove();
        }

    }

    /**
     * Counts the number of times a given entry appears in this bag.
     *
     * @param anEntry The entry to be counted.
     * @return The number of times anEntry appears in the bag.
     */
    public int getFrequencyOf(T anEntry) {
        int count = 0;
        DoublyLinkedNode current = first;
        while (current.next != null) {
            if (anEntry == current.data) {
                count++;
            }
            current = current.next;
        }
        return count;
    }

    /**
     * Tests whether this bag contains a given entry.
     *
     * @param anEntry The entry to locate.
     * @return True if the bag contains anEntry, or false if not.
     */
    public boolean contains(T anEntry) {
        boolean doesContain = false;
        DoublyLinkedNode current = first;
        while (current.next != null && !doesContain) {
            if (anEntry == current.data) {
                doesContain = true;
            }
            current = current.next;
        }
        return doesContain;
    }

    /**
     * Retrieves all entries that are in this bag.
     *
     * @return A newly allocated array of all the entries in the bag. Note: If
     * the bag is empty, the returned array is empty.
     */
    public T[] toArray() {
        T[] convertArray = (T[])new Object[size];
        DoublyLinkedNode current = this.first;
        for (int i = 0; i < size; i++) {
            convertArray[i] = current.data;
            current = current.next;
        }
        return convertArray;
    }
//	public <T> T[] toArray();  // Alternate
//	public Object[] toArray(); // Alternate

}
