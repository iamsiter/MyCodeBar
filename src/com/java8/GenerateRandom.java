package com.java8;

import java.util.Arrays;
import java.util.Random;

/*
* java.util.Random class
  Math.random method : Can Generate Random Numbers of double type.

  //Random().nextInt(int bound) = Random integer from 0 (inclusive) to bound (exclusive)

	//1. nextInt(range) = nextInt(max - min)
	new Random().nextInt(5);  // [0...4] [min = 0, max = 4]
	new Random().nextInt(6);  // [0...5]
	new Random().nextInt(7);  // [0...6]
	new Random().nextInt(8);  // [0...7]
	new Random().nextInt(9);  // [0...8]
	new Random().nextInt(10); // [0...9]
	new Random().nextInt(11); // [0...10]

	//2. To include the last value (max value) = (range + 1)
	new Random().nextInt(5 + 1)  // [0...5] [min = 0, max = 5]
	new Random().nextInt(6 + 1)  // [0...6]
	new Random().nextInt(7 + 1)  // [0...7]
	new Random().nextInt(8 + 1)  // [0...8]
	new Random().nextInt(9 + 1)  // [0...9]
	new Random().nextInt(10 + 1) // [0...10]
	new Random().nextInt(11 + 1) // [0...11]

	//3. To define a start value (min value) in a range,
	//   For example, the range should start from 10 = (range + 1) + min
	new Random().nextInt(5 + 1)  + 10 // [0...5]  + 10 = [10...15]
	new Random().nextInt(6 + 1)  + 10 // [0...6]  + 10 = [10...16]
	new Random().nextInt(7 + 1)  + 10 // [0...7]  + 10 = [10...17]
	new Random().nextInt(8 + 1)  + 10 // [0...8]  + 10 = [10...18]
	new Random().nextInt(9 + 1)  + 10 // [0...9]  + 10 = [10...19]
	new Random().nextInt(10 + 1) + 10 // [0...10] + 10 = [10...20]
	new Random().nextInt(11 + 1) + 10 // [0...11] + 10 = [10...21]

	// Range = (max - min)
	// So, the final formula is ((max - min) + 1) + min

	//4. Test [10...30]
	// min = 10 , max = 30, range = (max - min)
	new Random().nextInt((max - min) + 1) + min
	new Random().nextInt((30 - 10) + 1) + 10
	new Random().nextInt((20) + 1) + 10
	new Random().nextInt(21) + 10    //[0...20] + 10 = [10...30]

	//5. Test [15...99]
	// min = 15 , max = 99, range = (max - min)
	new Random().nextInt((max - min) + 1) + min
	new Random().nextInt((99 - 15) + 1) + 15
	new Random().nextInt((84) + 1) + 15
	new Random().nextInt(85) + 15    //[0...84] + 15 = [15...99]

	//Done, understand?



*/
public class GenerateRandom {
    public static void main(String[] args) {
        //MTD 1
        Random random = new Random();
        int next = 3 + random.nextInt(5);
        //System.out.println(next);

        //MTD 2
        double rand = Math.random();//returns a double value with a positive sign,
        // greater than or equal to 0.0 and less than 1.0

        int next2 = 3 + (int) (Math.random() * 5);
        System.out.println(next2);
    }
}
