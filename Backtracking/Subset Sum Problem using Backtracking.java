import java.util.ArrayList;
import java.util.List;

class HelloWorld {
    public static void rec(int[] a, int i,int target, List<Integer> temp) {
        if(target==0){
            System.out.print("[ ");
            for(Integer j:temp)
                System.out.print(j+" ");
            System.out.print("]");
            return;
        }
        if(i==a.length) return;
        rec(a,i+1,target,temp);
        if(a[i]<=target){
            temp.add(a[i]);
            rec(a,i+1,target-a[i],temp);
            temp.remove(temp.size()-1);
        }
    }

    public static void main(String[] args) {
        int[] a = {3, 34, 4, 12, 5, 2};
        int target = 30;
        rec(a, 0,target,new ArrayList<>());
    }
}
