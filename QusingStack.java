import java.util.Stack;

class QusingStack{
    Stack<Integer> st1= new Stack<>();
    Stack<Integer> st2= new Stack<>();

    public void enqueue(int item){
        st1.push(item);
    }

    public int dequeue(){
        if(st2.isEmpty()){
            while(!st1.isEmpty()){
                st2.push(st1.pop());
            }
        }
    

        if(!st2.isEmpty()){
            return st2.pop();
        }else{
            System.out.println("Queue is empty");
            return -1;
        }
    }

    public boolean isEmpty(){
        return st1.isEmpty() && st2.isEmpty();
    }
}