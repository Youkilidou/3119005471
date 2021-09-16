package Paper;
import java.util.Scanner;
public class Paper_main {

	
    public static void main(String[] args) {
    	Scanner sc=new Scanner(System.in);
 	    String in="";
 	       System.out.println("txt1?");
 	    in=sc.next();
 	    //args[0]=in;
        // 从命令行输入的路径名读取对应的文件，将文件的内容转化为对应的字符串
        String str0 = I_O.readTxt(in);
           System.out.println("txt2?");
        in=sc.next();
        
        String str1 = I_O.readTxt(in);
        //String resultFileName = args[2];
        // 由字符串得出对应的 simHash值
        String simHash0 = SimHash.getSimHash(str0);
        String simHash1 = SimHash.getSimHash(str1);
        // 由 simHash值求出相似度
        double similarity = Hamming.getSimilarity(simHash0, simHash1);
        // 把相似度写入最后的结果文件中
             System.out.println("txt3?");
             in=sc.next();
            // resultFileName=in;
        I_O.writeTxt(similarity, in);
        // 退出程序
        sc.close();
        System.exit(0);
    }


}
