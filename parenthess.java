public class parenthess<Item>
{
    String strs;
    mystack stack;
    public parenthess (String s)
    {
        strs = s;
        stack = new mystack<Item>(s.length());
    }
    public Boolean parse()
    {
        for(int i = 0;i < strs.length(); i++)
            {
                if(strs.charAt(i) == '(') stack.push(strs.charAt(i));
                else if(strs.charAt(i) == '[') stack.push(strs.charAt(i));
                else if(strs.charAt(i) == '{') stack.push(strs.charAt(i));
                else if(strs.charAt(i) == ')' && stack.pop() != '(' ) return false;
                else if(strs.charAt(i) == ']' && stack.pop() != '[') return false;
                else if(strs.charAt(i) == '}' && stack.pop() != '{') return false;
            }
        if(stack.size() != 0) return false;
        return true;
    }
    private class mystack<Item>
    {
        private  char array[];
        private int current;


        public mystack (int N)
        {
            array = new char[N];
            current = 0;
        }

        public void push(char par)
        {
            array[current++] = par;
        }
        public char pop() { return array[--current];}
        public int size()
        {
            return current;
        }
    }
    
}
