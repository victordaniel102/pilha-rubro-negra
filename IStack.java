public interface IStack {
    Object topRed() throws EmptyRedStackException;
    Object topBlack() throws EmptyBlackStackException;

    void pushRed(Object o);
    void pushBlack(Object o);

    Object popRed() throws EmptyRedStackException;
    Object popBlack() throws EmptyBlackStackException;

    int sizeRed();
    int sizeBlack();

    boolean isEmptyRed();
    boolean isEmptyBlack();
}
