package com.springzero.pattern.factory;

import java.util.ArrayList;
import java.util.List;

/**
 * Lợi ích của Factory Method Pattern:
 * 
 * Bằng cách đóng gói (encapsulation) những cài đặt (implementation) và thiết lập (construct) cho lớp trong factory, 
 * chương trình của chúng ta có thể sử dụng những gì nó cần mà không biết đối tượng cụ thể nào đang được gọi, 
 * đối tượng đó được tạo ra như thể nào cũng như những đối tượng đó làm gì. 
 * - Trongnhững ứng dụng lớn với khả năng hỗ trợ nhiều thiết lập, cấu hình, factories còn có thể đóng vai trò như bộ 
 * phận trung tâm thực hiện việt thay đổi những cấu hình đó. Ví dụ, nếu bạn cần chuyển đổi nhiều database component 
 * truy xuất dữ liệu MySQL và thay thế chúng bằng những component mới truy xuất dữ liệu Oracle, tất cả những gì bạn 
 * cần làm là đổi lớp factory và chuyển nó sang những component Oracle. Phần còn lại của ứng dụng sẽ không bị ảnh 
 * hưởng, bởi vì tất cả những component database đều được cài đặt (implement) từ cùng 1 interface, gồm các hàm truy 
 * xuất, lưu cũng như cập nhật và xoá dữ liệu. Còn làm cách nào mà những component đó làm việc bên dưới và loại 
 * database nào mà chúng truy xuất thực sự không quan trọng.
 * 
 * @author Thuat T Nguyen
 *
 */
public class App {
	public static void main(String[] args) {
		ProductFactory factory = new MyProductFactory();
		Product p0 = factory.getCurrentProduct();
		Product p1 = factory.getProduct("Television");
		Product p2 = factory.getProduct("MPlayer");
		Product p3 = factory.getCurrentProduct();
		
		List<Product> list = new ArrayList<>();
		list.add(p0);
		list.add(p1);
		list.add(p2);
		list.add(p3);
		
		for (int i = 0; i < list.size(); i++) {
			list.get(i).show();
		}
	}
}
