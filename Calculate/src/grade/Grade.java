package grade;

import java.io.*;

public class Grade {/*评分*/
    static final private String file1 = "e://AAA//Answers.txt";
    static final private String file2 = "e://AAA//word.txt";
    static final private String file3 = "e://AAA//Grade.txt";
    static private BufferedReader br1;
    static private BufferedReader br2;
    static private BufferedWriter bw;
    static private StringBuilder sb1 = new StringBuilder();
    static private StringBuilder sb2 = new StringBuilder();
    static private String result1;
    static private String result2;
    static int rightCount = 0;
    static int wrongCount = 0;

    static {
        try {
            br1 = new BufferedReader(new FileReader(file1));
            br2 = new BufferedReader(new FileReader(file2));
            bw = new BufferedWriter(new FileWriter(file3));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void grade() throws IOException {
        result1 = "correct:";
        result2 = "wrong:";
        sb1.append("（");
        sb2.append("（");
        String str1 = null,
        	   str2=null;
        int num=1;//题号
     
        while((str1 = br2.readLine())!=null
        	&&(str2 = br1.readLine())!=null){
           
            if(str1.equals(str2)){
                rightCount++;
                sb1.append(num+",");
                num++;
            }else {
                wrongCount++;
                sb2.append(num+",");
                num++;
            }
           // System.out.println("yes");
        }
        sb1.append(")");
        sb2.append(")");
        result1+=rightCount+sb1.toString();
        result2+=wrongCount+sb2.toString();
        
        bw.write(result1 + "\r\n");//经典换行
        bw.write(result2);
        
        
        br1.close();
        br2.close();
        bw.close();
    }
    
    public static void read(){//br2.readLine()————ok
        String str = null;
        try {
            while((str = br2.readLine())!=null)
                System.out.println(str);
        	while((str = br1.readLine())!=null)
                System.out.println(str);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
}

