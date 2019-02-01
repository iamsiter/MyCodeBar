
public class Sumo {

    public static void main(String[] args) {
        String str = "aaabcaa";
        System.out.println(str.substring(7,7));


        //String reStr= rearrange(str);
        //System.out.println(reStr);

    }

    private static String rearrange(String str) {
        char [] ch=str.toCharArray();
        int i=0,j=0;
        for(i=1;i<ch.length;i++){
            if(ch[i]==ch[i-1]){
                j=i+1;
                while(j<ch.length){
                    if(ch[i]!=ch[j]){
                        char temp=ch[i];
                        ch[i]=ch[j];
                        ch[j]=temp;
                        break;
                    }else{
                        j++;
                    }
                }

                if(j>=ch.length){
                    System.out.println("Not possible");
                    return str;
                }

            }
        }
        return new String(ch);
    }

}
