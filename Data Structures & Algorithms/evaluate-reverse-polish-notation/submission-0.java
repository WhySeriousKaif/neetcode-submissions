class Solution {
    public int evalRPN(String[] tokens) {
        List<String>tokenList=new ArrayList<>(Arrays.asList(tokens));


        while(tokenList.size()>1){
            for(int i=0;i<tokenList.size();i++){
                String token=tokenList.get(i);

                if("+-/*".contains(token)){
                    int a =Integer.parseInt(tokenList.get(i-2));
                    int b=Integer.parseInt(tokenList.get(i-1));
                    int res=0;
                    if(token.equals("+")){
                        res=a+b;
                    }
                    else if (token.equals("*")){
                        res=a*b;

                    }
                    else if (token.equals("/")){
                        res=a/b;
                        
                    }
                    else if (token.equals("-")){
                        res=a-b;
                        
                    }

                    tokenList.set(i-2,String.valueOf(res));
                    tokenList.remove(i);
                    tokenList.remove(i-1);
                    break;
                }
            }
        }
        return Integer.parseInt(tokenList.get(0));
    }
}
