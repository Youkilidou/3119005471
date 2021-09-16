package Paper;
import com.hankcs.hanlp.HanLP;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.util.List;

public class SimHash {
	 /**
     * ����String�����������hashֵ�������ַ�����ʽ���
     * @param str �����Srting�����ַ���
     * @return ����str��hashֵ
     */
    public static String getHash(String str){
        try{
        	HanLP.Config.enableDebug();
            // ����ʹ����MD5���hashֵ
            MessageDigest messageDigest = MessageDigest.getInstance("MD5");
            return new BigInteger(1, messageDigest.digest(str.getBytes("UTF-8"))).toString(2);
        }catch(Exception e){
            e.printStackTrace();
            return str;
        }
    }

    /**
     * ����String,���������simHashֵ�������ַ�����ʽ���
     * @param str �����Srting�����ַ���
     * @return ����str��simHashֵ
     */
    public static String getSimHash(String str){
        // �ı�����̫��ʱHanLp�޷�ȡ�ùؼ���
        try{
            if(str.length() < 200) throw new ShortStringException("�ı����̣�");
        }catch (ShortStringException e){
            e.printStackTrace();
            return null;
        }
        // �������ʾ��������,ȡ128λ,�� 0 1 2 λ��ʼ��ʾ�Ӹ�λ����λ
        int[] v = new int[128];
        // 1���ִʣ�ʹ�����ⲿ����hankcs���ṩ�Ľӿڣ�
        List<String> keywordList = HanLP.extractKeyword(str, str.length());//ȡ�����йؼ���
        // hash
        int size = keywordList.size();
        int i = 0;//��i�����ѭ��
        for(String keyword : keywordList){
            // 2����ȡhashֵ
            String keywordHash = getHash(keyword);
            if (keywordHash.length() < 128) {
                // hashֵ��������128λ���ڵ�λ��0����
                int dif = 128 - keywordHash.length();
                for (int j = 0; j < dif; j++) {
                    keywordHash += "0";
                }
            }
            // 3����Ȩ���ϲ�
            for (int j = 0; j < v.length; j++) {
                // ��keywordHash��ÿһλ��'1'���бȽ�
                if (keywordHash.charAt(j) == '1') {
                    //Ȩ�ط�10�����ɴ�Ƶ�Ӹߵ��ͣ�ȡȨ��10~0
                    v[j] += (10 - (i / (size / 10)));
                } else {
                    v[j] -= (10 - (i / (size / 10)));
                }
            }
            i++;
        }
        // 4����ά
        String simHash = "";// ���淵�ص�simHashֵ
        for (int j = 0; j < v.length; j++) {
            // �Ӹ�λ��������λ
            if (v[j] <= 0) {
                simHash += "0";
            } else {
                simHash += "1";
            }
        }
        return simHash;
    }
}
