// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : No, compilation errors and corner cases
class Solution {
    public String removeKdigits(String num, int k) {
        // Time Complexity O(n)
        // Space Complexity O(n), use stack
        Stack<Character> st = new Stack<>();
        if(num.length()==k) return ("0");
        if(k==0) return num;
        for(int i = 0 ; i < num.length();i++)
        {
            char curr = num.charAt(i);
            while(!st.isEmpty() && curr<st.peek()&& k>0)
            {
                st.pop();
                k--;
            }
           
            if(!st.isEmpty() || curr != '0')
            {
                st.push(curr);
            }
        }
        while(k>0 && !st.isEmpty())
        {
            st.pop();
            k--;
        }
        StringBuilder sb = new StringBuilder();
        if(st.isEmpty())
        return "0";
        while(!st.isEmpty())
        {
            sb.append(st.pop());
        }
        sb.reverse();
        return sb.toString();
    }
}

// Your code here along with comments explaining your approach
