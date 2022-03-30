public class SimpleLinkedList<T> {
    public static class SimpleLinkedListException extends Exception {
        public SimpleLinkedListException(String message) {
            super(message);
        }
    }

    private class SimpleLinkedListNode {
        public T value;
        public SimpleLinkedListNode next;

        public SimpleLinkedListNode(T value, SimpleLinkedListNode next) {
            this.value = value;
            this.next = next;
        }

        public SimpleLinkedListNode(T value) {
            this(value, null);
        }
    }

    private SimpleLinkedListNode head = null;
    private int size = 0;

    public T getNumberOfLastPerson(int k) throws SimpleLinkedListException {
        int count = 0;
        SimpleLinkedListNode curr = head;

        if (k == 1) {
            return get(size);
        }

        while (size > 1) {
            count ++;
            if (count == k - 1) {
                if (curr.next.next.equals(head)) {
                    removeLast();
                } else if (curr.next.equals(head)) {
                    removeFirst();
                } else {
                        curr.next = curr.next.next;
                        size --;
                    }
                curr = curr.next;
                count = 0;
            } else {
                curr = curr.next;
            }
        }
        return getFirst();
    }

    public void addFirst(T value) {
        head = new SimpleLinkedListNode(value, head);
        if (size == 0) {
            head.next = head;
        }
        size++;
    }

    public void addLast(T value) {
        if (size == 0) {
            head = new SimpleLinkedListNode(value);
            head.next = head;
        } else {
            getNode(size).next = new SimpleLinkedListNode(value, head);
        }
        size++;
    }

    private void checkEmptyError() throws SimpleLinkedListException {
        if (size == 0) {
            throw new SimpleLinkedListException("Empty list");
        }
    }

    private SimpleLinkedListNode getNode(int index) {
        SimpleLinkedListNode curr = head;
        for (int i = 1; i < index; i++) {
            curr = curr.next;
        }
        return curr;
    }

    public void removeFirst() throws SimpleLinkedListException {
        checkEmptyError();
        if (size == 1) {
            head = null;
        } else {
            getNode(size).next = head = head.next;
        }
        size--;
    }

    public void removeLast() throws SimpleLinkedListException {
        checkEmptyError();
        if (size == 1) {
            head = null;
        } else {
            getNode(size - 1).next = head;
        }
        size--;
    }

    public void remove(int index) throws SimpleLinkedListException {
        checkEmptyError();
        if (index <= 0 || index > size) {
            throw new SimpleLinkedListException("Incorrect index");
        }
        if (index == 1) {
            removeFirst();
        } else if (index == size) {
            removeLast();
        } else {
            getNode(index - 1).next = getNode(index).next;
        }
        size--;
    }

    public int size() {
        return size;
    }

    public T get(int index) throws SimpleLinkedListException {
        checkEmptyError();
        return getNode(index).value;
    }

    public T getFirst() throws SimpleLinkedListException {
        checkEmptyError();
        return head.value;
    }

}