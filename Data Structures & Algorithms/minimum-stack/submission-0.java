class MinStack {
    Stack<Integer>st;

    public MinStack() {
        st=new Stack<>();
        
    }
    
    public void push(int val) {
         st.push(val);
        
    }
    
    public void pop() {
         st.pop();
        
    }
    
    public int top() {
        return st.peek();
        
    }
    
    public int getMin() {
        Stack<Integer> temp=new Stack<>();
        int min=st.peek();
        while(!st.isEmpty()){
            int num=st.pop();
            temp.push(num);
            min=Math.min(min,num);

        }
        while(!temp.isEmpty()){
            st.add(temp.pop());
        }
        return min;
    }
}
