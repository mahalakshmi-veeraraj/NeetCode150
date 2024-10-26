public class Solution {
    // you need treat n as an unsigned value
    public int reverseBits(int n) {
        int reversedNumber = 0;
        for (int index = 0; index < 32; index++) {
            // When you perform a left shift (<<), the bits are shifted to the left, which means:
            // The left most bit is dropped (eesentially removed), and a new '0' bit is added to the rightmost position.
            reversedNumber = reversedNumber << 1;  
            if ( (n & (1 << index)) != 0 ) // Check bit.
                reversedNumber = (reversedNumber | 1); // Set bit
        }  
        return reversedNumber;
    }
}