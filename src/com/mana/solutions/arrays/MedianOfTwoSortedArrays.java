package com.mana.solutions.arrays;

public class MedianOfTwoSortedArrays {

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int x = nums1.length; //Larger array
        int y = nums2.length; //Smaller array BS performed on this array
        if (x > y)
            return findMedianSortedArrays(nums2, nums1);

        int low = 0;
        int high = x;
        while (low <= high) {
            int partitionX = (low + high) / 2;
            int partitionY = (x + y + 1) / 2 - partitionX;

            int maxLeftX = (partitionX == 0) ? Integer.MIN_VALUE : nums1[partitionX - 1];
            int minRightX = (partitionX == x) ? Integer.MAX_VALUE : nums1[partitionX];

            int maxLeftY = (partitionY == 0) ? Integer.MIN_VALUE : nums2[partitionY - 1];
            int minRightY = (partitionY == y) ? Integer.MAX_VALUE : nums2[partitionY];

            if ((maxLeftX <= minRightY) && (maxLeftY <= minRightX)) {
                if ((x + y) % 2 == 0) {
                    return (double) (Math.max(maxLeftX, maxLeftY) + Math.min(minRightX, minRightY)) / 2;
                } else {
                    return (double) (Math.max(maxLeftX, maxLeftY));
                }
            } else if (maxLeftX > minRightY) {
                high = partitionX - 1;
            } else {
                low = low = partitionX + 1;
            }

        }
        return (-1.0);
    }

}


/*
* x -> Elements in array X
y -> Elements in array Y
(x+y+1)/2  -> Formula to calculate elements in left partition

Suppose x = 7 and y = 2    i.e. x+ y = 9
Using (x+y+1)/2 = (7+2+1)/2 = 5.
This means there should be 5 elements in left partition and remaining 4 elements should be in right.

Not lets take case of x = 7 and y = 3 i.e. x+y=10
Using (x+y+1)/2 = (7+3+1)/2 = 5.5
Now most of the programming languages will convert 5.5 to 5 if you are using integer type variable to store this value.
So in this case 5.5 will become 5.
This means there should be 5 elements in left partition and remaining 5 elements should be in right.

He added 1 to x+y so that the same formula can work in even and odd case programatically.
*/