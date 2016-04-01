/*Author: Maxwell Fraser
Doubly Linked bag and node classes
 */
public class DoublyLinkedBag<T> implements BagInterface<T> {

    private int size;
    private DoublyLinkedNode first;

    //Node holds data, and the node ahead and behind it
    private class DoublyLinkedNode {

        private T data;
        private DoublyLinkedNode next;
        private DoublyLinkedNode prev;

        //creates the node with data, next and prev node managment handled by bag
        private DoublyLinkedNode(T input) {
            data = input;
            next = null;
            prev = null;
        }

        //can use to clear out a node when needed
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
    //returns size
    public int getCurrentSize() {
        return size;
    }

    /**
     * Sees whether this bag is empty.
     *
     * @return True if the bag is empty, or false if not.
     */
    //checks to see if the bag in empty
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
    //checks to see if the bag is empty first
    //if empty then it sets the new entry as the first in the list
    //otherwise it sets the new enry as the first and pushes the rest of the nodes behid it
    public boolean add(T newEntry) {
        DoublyLinkedNode newN = new DoublyLinkedNode(newEntry);
        if (this.isEmpty()) {
            first = newN;
        } else {
            first.prev = newN;
            newN.next = first;
            first = newN;
        }
        size++;
        return true;
    }

    /**
     * Removes one unspecified entry from this bag, if possible.
     *
     * @return Either the removed entry, if the removal. was successful, or
     * null.
     */
    //removes the first entry from the bag
    //tells what item was reoved
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
    //searches for an entry and removes it
    public boolean remove(T anEntry) {
        boolean didRemove = false;
        DoublyLinkedNode current = first;
        //while next node is not null it continues searching until the last node
        //it also will stop if it removes an entry
        //removes the entry upon match with the parameter
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
    //clears the entire bag
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
    //checks for the frequency of an Entry by traversing from the first node
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
    //checks to see if it contains a specific entry, returns true if so
    public boolean contains(T anEntry) {
        boolean doesContain = false;
        DoublyLinkedNode current = first;
        while (current.next != null && !doesContain) {
            if (anEntry.equals(current.data)) {
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
    //returns an array of the bag by copying data to an array the same size of the bag
    //traverses from the first node and sets the array at index 0 to that entry
    //continues by one from that point
    public T[] toArray() {
        T[] convertArray = (T[]) new Object[size];
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
