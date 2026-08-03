// class Solution {
//     public int romanToInt(String s) {
//         Map<Character, Integer> map = new HashMap<>();
//         map.put('I', 1);
//         map.put('V', 5);
//         map.put('X', 10);
//         map.put('L', 50);
//         map.put('C', 100);
//         map.put('D', 500);
//         map.put('M', 1000);

//         int res = 0;

//         for(int i = s.length() - 1; i >= 0; i--){
//             int num = map.get(s.charAt(i));
//             if (4 * num < res) {
//                 res -= num;
//             } else {
//                 res += num;
//             }
//         }
//         return res;
//     }
// }


/**
DXCI
500 10 100 1
CMXCIV
100 1000 10 100 1 5

VL
5 50


class Solution {
    public int romanToInt(String s) {
        int num=0,ans=0;
        for(int i=s.length()-1;i>=0;i--){
            switch(s.charAt(i)){
                case 'I' -> num=1;
                case 'V' -> num=5;
                case 'X' -> num=10;
                case 'L' -> num=50;
                case 'C' -> num=100;
                case 'D' -> num=500;
                case 'M' -> num=1000;
            }
            if(4*num<ans){
                ans-=num;
            }
            else{ans+=num;}
        }
        return ans;
    }
}

 */


 /**
 input: Roman number to Integer coversion, the Roman number is represented by a Sting made with (I, V, X, L, C, D, M); output is a int
    map -> Roman number Character : int
    1' characters:  I, X, C
    2' 


 
  */

class Solution {
    public int romanToInt(String s) {
        int res = 0;
        char[] ch = s.toCharArray();
        for (int i = 0; i < s.length(); i++) {
            int cur = getValue(ch[i]);
            if (i + 1 < s.length() && cur < getValue(ch[i + 1])) {
                res += getValue(ch[i + 1]) - cur;
                i++;
            } else {
                res += cur;
            }
        }
        return res;
    } 

    private int getValue(char c) {
        switch (c) {
            case 'I': return 1;
            case 'V': return 5;
            case 'X': return 10;
            case 'L': return 50;
            case 'C': return 100;
            case 'D': return 500;
            case 'M': return 1000;
            default: return 0;
        }
    }
}