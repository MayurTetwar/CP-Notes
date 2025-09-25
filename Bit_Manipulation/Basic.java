package Bit_Manipulation;

/*
    Operator: &
    Name: AND
    Description: Sets a bit to 1 only if both corresponding bits are 1.
    Example (a=5, b=3): 0101 & 0011 -> 0001 (1)

    Operator: |
    Name: OR
    Description: Sets a bit to 1 if at least one of the corresponding bits is 1.
    Example (a=5, b=3): 0101 | 0011 -> 0111 (7)

    Operator: ^
    Name: XOR
    Description: Sets a bit to 1 only if the corresponding bits are different.
    Example (a=5, b=3): 0101 ^ 0011 -> 0110 (6)

    Operator: ~
    Name: NOT
    Description: Inverts all the bits (0 becomes 1, and 1 becomes 0).
    Example: ~0101 -> ...11111010 (-6)

    Operator: << k
    Name: Left Shift
    Description: Shifts bits to the left, filling with 0s on the right. 
    Equivalent to multiplication by 2^k
    Example: 5 << 2 -> 010100 (20)

    Operator: >> k
    Name: Signed Right Shift
    Description: Shifts bits to the right. Fills with the sign bit on the left, 
    preserving the sign. Equivalent to division by 2^k
    Example: 5 >> 1 -> 0010 (2) and -5 >> 1 -> ...11111101 (-3)

    Operator: >>>
    Name: Unsigned Right Shift
    Description: Shifts bits to the right, always filling with 0s on the left.
    Example: -5 >>> 1 -> 0...1111110 (large positive number)
 */
public class Basic {
    public static void main(String[] args) {
        
        System.out.println();

    }
}

