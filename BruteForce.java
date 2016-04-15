package projekti;

public class BruteForce {

    private static char [] x = {'0','1','2','3','4','5','6','7','8','9','a', 'b', 'c', 'd', 'e', 'f',
        'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z', 'A' ,'B','C','D','E','F','G','H','I','J','K','L','M','N','O','P','Q'
		,'R','S','T','U','V','W','X','Y','Z'};

	
   public static void bF()
    {
        String pw = null;

        for(int i = 0; i<x.length;i++)
        {
            //pw = x[i];
            pw = Character.toString(x[i]);
            for(int j = 0; j < x.length;j++)
            {
                pw += x[j];
                for(int z=0; z<x.length;z++)
                {
                    pw += x[z];
                    for(int l=0; l<x.length;l++)
                    {
                        pw += x[l];
                        for(int b=0; b<x.length;b++)
                        {
                            pw += x[b];
                            System.out.println(pw);
                            pw =removeLastChar(pw);
                            //pw.replace(Character.toString(pw.charAt(pw.length()-1)), "");
                        }
                        pw = removeLastChar(pw);
                        //pw.replace(Character.toString(pw.charAt(pw.length()-1)), "");
                        //pw.replace(pw.substring(0,pw.length()-1), "");
                    }
                    pw = removeLastChar(pw);
                    //pw.replace(Character.toString(pw.charAt(pw.length()-1)), "");
                    //pw.replace(pw.substring(0,pw.length()-1), "");
                }
                pw = removeLastChar(pw);
                //pw.replace(Character.toString(pw.charAt(pw.length()-1)), "");
                //pw.replace(pw.substring(0,pw.length()-1), "");
            }
            pw = removeLastChar(pw);
            //pw.replace(Character.toString(pw.charAt(pw.length()-1)), "");
            //pw.replace(pw.substring(0,pw.length()-1), "");
        }
    }
	
    private static String removeLastChar(String s) {
        if(s != null)
        {
            s.substring(0,s.length()-1);
        }
        return s;
    }
}
