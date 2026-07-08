public class RemoveAdjDuplicates {
    static char last_removed;
    
    static String removeUtil(String str){
        if(str.length() == 0 || str.length() == 1)
            return str;
        
        if(str.charAt(0) == str.charAt(1)){
            last_removed = str.charAt(0);
            
            while(str.length() > 1 && str.charAt(0) == str.charAt(1))
                str = str.substring(1);

            str = str.substring(1);
            return removeUtil(str);
        }

        String remain_str = removeUtil(str.substring(1));

        if(remain_str.length() != 0 && remain_str.charAt(0) == str.charAt(0)){
            last_removed = str.charAt(0);
            return remain_str.substring(1);
        }

        if(remain_str.length() == 0 && last_removed == str.charAt(0)){
            return remain_str;
        }

        return str.charAt(0) + remain_str;
    }

    static String remove(String str){
        last_removed = '\0';
        return removeUtil(str);
    }

    public static void main(String args[]) {
        String str1 = "azxxzy";
        System.out.println(remove(str1));

        String str2 = "caaabbbaacdddd";
        System.out.println(remove(str2));

        String str3 = "acaaabbbacdddd";
        System.out.println(remove(str3));
    }
}
