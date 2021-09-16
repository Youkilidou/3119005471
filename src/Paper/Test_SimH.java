package Paper;
import org.junit.Test;
public class Test_SimH {
	 @Test
	    public void getHashTest(){
	        String[] strings = {"余华", "是", "一位", "真正", "的", "作家"};
	        for (String string : strings) {
	            String stringHash = SimHash.getHash(string);
	            System.out.println(stringHash.length());
	            System.out.println(stringHash);
	        }
	    }
	    @Test
	    public void getSimHashTest(){
	        String str0 = I_O.readTxt("e:/fast/orig.txt");
	        String str1 = I_O.readTxt("e:/fast/orig_0.8_add.txt");
	        System.out.println(SimHash.getSimHash(str0));
	        System.out.println(SimHash.getSimHash(str1));
	    }
}
