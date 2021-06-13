public class Stack implements IStack {
    private int capacity;
    private int redIndex;
    private int blackIndex;
    private Object[] rb;

    private void verifyAndResize() {
        if (redIndex + blackIndex == capacity - 2) {
            capacity *= 2;
            Object[] newRb = new Object[capacity];

            for (int i = 0; i <= redIndex; i++) {
                newRb[i] = rb[i];
            }

            for (int i = 0; i <= blackIndex; i++) {
                newRb[capacity-1-i] = rb[capacity/2-1-i];
            }

            rb = newRb;
        }
    }

    public Stack(int capacity) {
        redIndex = -1;
        blackIndex = -1;

        this.capacity = capacity;
        rb = new Object[this.capacity];
    }

    public void pushRed(Object o) {
        verifyAndResize();
        rb[++redIndex] = o;
    }

    public void pushBlack(Object o) {
        verifyAndResize();
        rb[capacity-1-(++blackIndex)] = o;
    }

    public boolean isEmptyRed() {
        return redIndex == -1;
    }

    public boolean isEmptyBlack() {
        return blackIndex == -1;
    }

    public Object topRed() throws EmptyRedStackException {
        if (isEmptyRed()) throw new EmptyRedStackException("A pilha vermelha está vazia!");
        return rb[redIndex];
    }

    public Object topBlack() throws EmptyBlackStackException {
        if (isEmptyBlack()) throw new EmptyBlackStackException("A pilha preta está vazia!");

        return rb[capacity-1-blackIndex];
    }

    public Object popRed() throws EmptyRedStackException {
        if (isEmptyRed()) throw new EmptyRedStackException("A pilha vermelha está vazia!");
        return rb[redIndex--];
    }

    public Object popBlack() throws EmptyBlackStackException {
        if (isEmptyBlack()) throw new EmptyBlackStackException("A pilha preta está vazia!");
        return rb[capacity-1-blackIndex--];
    }

    public int sizeRed() {
        return redIndex+1;
    }

    public int sizeBlack() {
        return blackIndex+1;
    }
}