package Paper;
import org.junit.Test;
public class Test_Hamming {
	@Test
    public void getHammingDistanceTest() {
        String str0 = I_O.readTxt("e:/fast/orig.txt");
        String str1 = I_O.readTxt("e:/fast/orig_0.8_add.txt");
        int distance = Hamming.getHammingDistance(SimHash.getSimHash(str0), SimHash.getSimHash(str1));
        System.out.println("�������룺" + distance);
        System.out.println("���ƶ�: " + (100 - distance * 100 / 128) + "%");
    }
}
