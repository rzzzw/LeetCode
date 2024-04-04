class Solution {
    public String gcdOfStrings(String str1, String str2) {
        if (!(str1 + str2).equals(str2 + str1)) {
            return "";
        }
        int gcdLen = gcd(str1.length(), str2.length());
        return str1.substring(0, gcdLen);
    }
    private int gcd(int x, int y) {
        if (y == 0) {
            return x;
        } else {
            return gcd(y, x % y);
        }
    }
}

/**
ABCABC     ABC
x:6        y:3
x:3        y:0


ABABAB      AB
6           2
2           0

ABABABAB    ABA
ABABABABABA != ABAABABABAB



*/