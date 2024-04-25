package calculator;

public class Calculator {
    public int add(int a, int b) {
        return a + b;
    }

    public int multiple(int a, int b) {
        return a * b;
    }

    public int divide(int a, int b) throws Exception {
        if (b == 0) {
            throw new Exception();
        }
        return  a / b;
    }

    public int power(int a, int b) {
        int result = 1;
        if (a == 0)
            return result;
        else {
            for (int i = 0; i < b; i++) {
                result = multiple(result, a);
            }
        }
        if (b < 0) {
            try{
                return divide(1, result);
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
        return result;
    }
}
