class MinStack {
    
    Stack<Integer>st;
    Stack<Integer>minSt;

    public MinStack() {
        st=new Stack<>();
        minSt=new Stack<>();

        
    }
    
    public void push(int val) {
        st.add(val);
        if(minSt.isEmpty()|| val<=minSt.peek()){
            minSt.add(val);
        }
        
    }
    
    public void pop() {
        if(st.isEmpty()) return;
        int top=st.pop();
        if(top==minSt.peek()){
            minSt.pop();
        }
        
    }
    
    public int top() {
       return  st.peek();

        
    }
    
    public int getMin() {
        return minSt.peek();
        
    }
}
