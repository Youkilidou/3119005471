package Paper;
import org.junit.Test;
public class Test_I_O {
	
	    @Test
	    public void readTxtTest() {
	        // ·�����ڣ�������ȡ
	        String str = I_O.readTxt("D:/test/orig.txt");
	        String[] strings = str.split(" ");
	        for (String string : strings) {
	            System.out.println(string);
	        }
	    }
	    @Test
	    public void writeTxtTest() {
	        // ·�����ڣ�����д��
	        double[] elem = {0.11, 0.22, 0.33, 0.44, 0.55};
	        for (int i = 0; i < elem.length; i++) {
	            I_O.writeTxt(elem[i], "D:/test/ans.txt");
	        }
	    }
	    @Test
	    public void readTxtFailTest() {
	        // ·�������ڣ���ȡʧ��
	        String str = I_O.readTxt("D:/test/none.txt");
	    }
	    @Test
	    public void writeTxtFailTest() {
	        // ·������д��ʧ��
	        double[] elem = {0.11, 0.22, 0.33, 0.44, 0.55};
	        for (int i = 0; i < elem.length; i++) {
	            I_O.writeTxt(elem[i], "User:/test/ans.txt");
	        }
	    }
	}

