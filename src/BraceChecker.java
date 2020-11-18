import java.util.Stack;
public class BraceChecker {
    public boolean isValid(String braces) {
        Stack<Character> s = new Stack<>();
        int count = 0;
        if(braces.length() <= 1){
            return false;
        }
        for(int i = 0; i < braces.length(); i++)
        {
            char ch = braces.charAt(i);
            switch (ch){
                case '{':
                case '[':
                case '(': s.push(ch);
                    break;
                case '}':
                case ']':
                case ')': if(!s.empty()){
                    char chx = s.pop();
                    if((ch=='}' && chx!='{') ||
                            (ch==']' && chx!='[') ||
                            (ch==')' && chx!='(') )
                        count--;
                    else
                        count++;
                }
                    break;
                default: count--; break;
            }
        }
        if(count < 1)
        {
            return false;
        }
        if(braces.length() / count == 2)
            return true;
        else
            return false;
    }

}
