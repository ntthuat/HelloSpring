package com.springzero.core.datatype.impl;

import java.math.BigDecimal;
import java.math.RoundingMode;

/**
 * Abstract class này dùng để chứa các method dùng chung cho các class con.<br>
 * BigDecimal là type thường sử dụng trong tính toán tiền tệ.
 * BigDecimal là giá trị immutable (bất biến).
 * 
 * @author Thuat T Nguyen
 * @version 05/23/2017
 */
public abstract class AbstractNumber {
	// hàm này tự việc chuối quá
	protected final BigDecimal doSetRounded(final int scale, final BigDecimal value, final boolean rounded ){
		final BigDecimal result = value.setScale(scale, rounded ? RoundingMode.HALF_EVEN
		        : RoundingMode.DOWN);
		return result;
	}
	
	/***
	 * Divide a BigDecimal with rounding or not. Rounded value i
	 * 
	 * @param value - BigDecimal to be truncate & rounded
	 * @param rounded - indicate of rounding should be applied. If false, then DOWN is by default.
	 * @return rounded value, which is the one actually being set to the data
	 */
	// hàm do qre viết chưa hiểu hết
	/*protected final BigDecimal doSetRounded(final BigDecimal value, final boolean rounded) {

		final BigDecimal scaledValue = value.setScale(scale, rounded ? MathConfig.getDefaultRoundingMode()
		        : RoundingMode.DOWN);
		doSet(scaledValue);
		// check truncated again since truncated is calculated in doSet() above.
		final BigDecimal result = toBigDecimal();
		final BigDecimal diff = result.subtract(value);
		if (diff.signum() == 0) {
			truncated = false;
		} else {
    		if (rounded) {
    			// if rounded, then check integer truncation only
    			truncated = diff.abs().compareTo(BigDecimal.ONE) > 0; 
    		} else {
    			truncated = true;
    		}
		}
		return result;
	}*/
}
