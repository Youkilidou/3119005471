package Paper;
import java.util.Scanner;
public class Paper_main {

	
    public static void main(String[] args) {
    	Scanner sc=new Scanner(System.in);
 	    String in="";
 	       System.out.println("txt1?");
 	    in=sc.next();
 	    //args[0]=in;
        // �������������·������ȡ��Ӧ���ļ������ļ�������ת��Ϊ��Ӧ���ַ���
        String str0 = I_O.readTxt(in);
           System.out.println("txt2?");
        in=sc.next();
        
        String str1 = I_O.readTxt(in);
        //String resultFileName = args[2];
        // ���ַ����ó���Ӧ�� simHashֵ
        String simHash0 = SimHash.getSimHash(str0);
        String simHash1 = SimHash.getSimHash(str1);
        // �� simHashֵ������ƶ�
        double similarity = Hamming.getSimilarity(simHash0, simHash1);
        // �����ƶ�д�����Ľ���ļ���
             System.out.println("txt3?");
             in=sc.next();
            // resultFileName=in;
        I_O.writeTxt(similarity, in);
        // �˳�����
        sc.close();
        System.exit(0);
    }


}
