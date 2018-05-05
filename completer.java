public class completer
{
    private mystack stack;
    private mystack optstack;
    private mystack varstack;
    private int allcount = 0;
    private int outcount = 1;

    public completer(String str)
    {
        optstack = new mystack(str.length());
        
        varstack = new mystack(str.length());
        for(int i = 0; i < str.length(); i++)
            {
                if(str.charAt(i) == 'a' || str.charAt(i) == 'b'
                   || str.charAt(i) == 'c')
                    {
                        varstack.push(str.charAt(i));
                    }
                else if(str.charAt(i) == '+' || str.charAt(i) == '*')
                    {
                        //StdOut.println(str.charAt(i));
                        if(varstack.size() < 2)
                            {
                                optstack.push(str.charAt(i));
                            }
                        else if(str.charAt(i) == '*')
                            {
                                if(optstack.next() == '*')
                                    {
                                        StdOut.print(varstack.next());
                                        StdOut.print(varstack.next());
                                        StdOut.print('*');
                                        optstack.push('*');
                                    }
                                else
                                    {
                                        optstack.push('+');
                                        optstack.push('*');
                                    }
                            }
                        else if(str.charAt(i) == '+')
                            {
                                if(optstack.size()  >= 1)
                                    {
                                        StdOut.print(varstack.next());
                                        StdOut.print(varstack.next());
                                        // char cache = optstack.next();
                                        // if(cache != a'+' || cache != '*')
                                        //     {
                                        //         StdOut.print(optstack.next());
                                        //     }
                                        // else
                                        StdOut.print(optstack.next());
                                        optstack.push(str.charAt(i));
                                    }
                                else
                                    {
                                        StdOut.println("Push3 " + str.charAt(i));
                                        optstack.push(str.charAt(i));
                                    }
                            }
                    }
            }
        while(varstack.size() > 0)
            StdOut.print(varstack.next());
        // if(optstack.next() == ' ')
        //     StdOut.println("TRUE");
        while(optstack.size() >= 1)
            StdOut.print(optstack.next());
        StdOut.println("");
    }
    private class mystack
    {

        private int current = 0;
        private char array[];
        private int count = 0;
        public mystack(int size)
        {
            array = new char[size*2];
        }
        public char next()
        {
            count--;
            return array[--current];
        }
        public int size()
        {
            return count;
        }

        public void push(char word)
        {
            array[current++] = word;
            count++;
        }
    }
    private void complment(String str)
    {
                stack = new mystack(str.length());
        for(int i = str.length() - 1; i>0; i--)
            {
                if(str.charAt(i) == ')'){ stack.push(str.charAt(i)); allcount++;}
                else if(str.charAt(i) == '+' || str.charAt(i) == '-'
                   || str.charAt(i) == '/' || str.charAt(i) == '*')
                    { stack.push(str.charAt(i--));
                        if(str.charAt(i) == '1')
                            {
                                stack.push(str.charAt(i));
                                if(i == 0)
                                    {
                                        while(allcount > 0)
                                            {
                                                allcount--;
                                                stack.push('(');
                                            }
                                        break;
                                    }
                                while(outcount > 0)
                                    {
                                        stack.push('(');
                                        outcount--;
                                        allcount--;
                                    }
                                outcount=1;
                            }
                        else if(str.charAt(i) == ')')
                            {
                                allcount++;
                                outcount++;stack.push(str.charAt(i));
                            }
                    }
                else
                    {
                        stack.push(str.charAt(i));
                    }
            }
        for(int i = 0; i <= stack.size();)
            {
                StdOut.print(stack.next());
            }
        StdOut.println("");
    }
}
