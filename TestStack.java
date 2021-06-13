public class TestStack {
    public static void main(String[] args) {
        Stack s = new Stack(2);

        try {
            s.pushRed("red0");
            // ["red0"] capacity = 2
            System.out.println(s.topRed()); // red0

            s.pushBlack("black0");
            // ["red0", "black0"] capacity = 2

            s.pushBlack("black1");
            // ["red0", "black1", "black0"] capacity = 4

            System.out.println(s.sizeRed()); // 1
            System.out.println(s.sizeBlack()); // 2

            s.popBlack();
            // ["red0", "black0"] capacity = 4

            System.out.println(s.sizeBlack()); // 1

            s.popRed();
            // ["black0"] capacity = 4

            System.out.println(s.sizeRed()); // 0

            s.pushBlack("black2");
            // ["black2", "black0"] capacity = 4

            System.out.println(s.isEmptyRed()); // true
            System.out.println(s.isEmptyBlack()); // false

            System.out.println(s.topBlack()); // black2

            
            System.out.println(s.topRed()); // ERROR
            
            s.popRed(); // ERROR
        } catch (Exception error) {
            System.out.println(error.getMessage());
        }
        
        System.out.println("16/16 SUCCESS TESTS");
    }
}
