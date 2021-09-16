package Paper;
import org.junit.Test;
public class Test_main {
	@Test
    public void origAndAllTest(){
        String[] str = new String[6];
        str[0] = I_O.readTxt("e:/fast/orig.txt");
        str[1] = I_O.readTxt("e:/fast/orig_0.8_add.txt");
        str[2] = I_O.readTxt("e:/fast/orig_0.8_del.txt");
        str[3] = I_O.readTxt("e:/fast/orig_0.8_dis_1.txt");
        str[4] = I_O.readTxt("e:/fast/orig_0.8_dis_10.txt");
        str[5] = I_O.readTxt("e:/fast/orig_0.8_dis_15.txt");
        String ansFileName = "e:/fast/emm.txt";
        for(int i = 0; i <= 5; i++){
            double ans = Hamming.getSimilarity(SimHash.getSimHash(str[0]), SimHash.getSimHash(str[i]));
            I_O.writeTxt(ans, ansFileName);
        }
    }
}
