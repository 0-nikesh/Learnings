import java.util.LinkedList;
import java.util.Queue;

class StackUsingQ {

    Queue<Integer> Q1= new LinkedList<>();
    Queue<Integer> Q2= new LinkedList<>();

    public void push(int item){
        Q1.add(item);
        while(!Q2.isEmpty()){
            Q1.add(Q2.remove());
        }

        Queue<Integer> temp= Q1;
        Q1=Q2;
        Q2=temp;
    }
    public int pop(){
        if(!Q2.isEmpty()){
            return Q2.remove();
        }
        else{
            System.out.println("stack is empty");
            return -1;
        }
    }

    public boolean isEmpty(){
        return Q1.isEmpty() && Q2.isEmpty();
    }
    
}
