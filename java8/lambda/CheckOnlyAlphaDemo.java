interface CheckAlpha{
    boolean isAlphaOnly(String a);
}


public class CheckOnlyAlphaDemo {

    public static void main(String[] args){
        CheckAlpha checkAplha=s->s.chars().allMatch(Character::isAlphabetic);

        String s1="ab2223232";
        String s2="abweewwe";
        System.out.println(checkAplha.isAlphaOnly(s1));
        System.out.println(checkAplha.isAlphaOnly(s2));
    }
}
