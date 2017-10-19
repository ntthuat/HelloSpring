package com.springzero.java8;

import java.util.Arrays;
import java.util.List;

public class LambdaExpression {
	
	// Khai báo các inner interface
    interface MathOperation {
        int operation(int a, int b);
    }
	
    interface GreetingService {
        void printMessage(String message);
    }
    
	private int operate(int a, int b, MathOperation mathOperation) {
        return mathOperation.operation(a, b);
    }
	
	public static void main(String[] args) {
		LambdaExpression tester = new LambdaExpression();
		
		// Có khai báo kiểu dữ liệu cho các parameter
        MathOperation addition = (int a, int b) -> a + b;
        
        // Tùy chọn khai báo kiểu dữ liệu
        MathOperation subtraction = (int a, int b) -> a - b;
		
		// Câu lệnh return yêu cầu phải có các dấu {}
		MathOperation multiplication = (int a, int b) -> {
			return a * b;
		};
		
		MathOperation division = (int a, int b) -> a / b;
        
		// In kết quả ra màn hình
        System.out.println("10 + 5 = " + tester.operate(10, 5, addition));
        System.out.println("10 - 5 = " + tester.operate(10, 5, subtraction));
        System.out.println("10 x 5 = " + tester.operate(10, 5, multiplication));
        System.out.println("10 / 5 = " + tester.operate(10, 5, division));
        
        // Tùy chọn không sử dụng dấu ngoặc khi chỉ có 1 parameter
        GreetingService greetingService1 = message -> System.out.println("Hello " + message);

        // Tùy chọn sử dụng dấu ngoặc cho parameter
        GreetingService greetingService2 = (message) -> System.out.println("Hello " + message);
        
        greetingService1.printMessage("Alice");
        greetingService2.printMessage("Max");
        
        // Operator ::
		List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6);
		numbers.forEach(System.out::println);
	}
}
