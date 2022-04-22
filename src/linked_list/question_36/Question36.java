package linked_list.question_36;
import java.util.List;
import java.util.ArrayList;

public class Question36 {
    static final int MAX_CHAR = 256;
    public static String firstNonRepeating(String A)
    {
        // code here
        String res = "";
        List<Character> dll = new ArrayList<>();
        boolean[] repeated = new boolean[MAX_CHAR];
        
        for(int i=0;i<A.length();i++){
            char ch = A.charAt(i);
            if(!repeated[ch]){
                if(!(dll.contains(ch))){
                    dll.add(ch);
                }else{
                    dll.remove((Character)ch);
                    repeated[ch] = true;
                }
            }
            if(dll.size()!=0){
                res = res + dll.get(0);
            }else{
                res = res + "#";
            }
        }
        return res;
    }
    public static void main(String[] args) {
        System.out.print(firstNonRepeating("aabc"));
    }
}
