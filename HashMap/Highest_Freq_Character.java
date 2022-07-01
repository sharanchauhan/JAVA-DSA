import java.util.*;
public class Highest_Freq_Character {
    public static void main(String[] args) throws Exception {
        // write your code here
        HashMap<Character,Integer> hm=new HashMap<>();
        Scanner s=new Scanner(System.in);
        String str=s.next();
        for(int i=0;i<str.length();i++)
        {
            if(hm.containsKey(str.charAt(i)))
            {
                hm.put(str.charAt(i),(hm.get(str.charAt(i))+1));
            }
            else
            {
                hm.put(str.charAt(i),1);
            }
        }
        int maxFreq=0;
        char maxFch=' ';
        for(Character ch:hm.keySet())
        {
            if(maxFreq<hm.get(ch))
            {
                maxFreq=hm.get(ch);
                maxFch=ch;
            }
        }
        System.out.println(maxFch);
        s.close();
    }
}