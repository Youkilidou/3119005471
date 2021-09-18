package Paper;

public class Hamming{
	 /*
     * ��������simHashֵ���������ǵĺ�������
     * return ��������
     */
    public static int getHammingDistance(String simHash1, String simHash2) {//��������#######
        int distance = 0;
        if (simHash1.length() != simHash2.length()) {
            // ��������-1
            distance = -1;
        } else {
            for (int i = 0; i < simHash1.length(); i++) {
                // ÿһλ���бȽ�
                if (simHash1.charAt(i) != simHash2.charAt(i)) {
                    distance++;
                }
            }
        }
        return distance;
    }

    /*
     * ��������simHashֵ��������ƶ�
     * return ���ƶ�
     */
    public static double getSimilarity(String simHash1, String simHash2) {//���ƶ�#########
    	
        // ͨ�� simHash1 �� simHash2 ������ǵĺ�������
        int distance = getHammingDistance(simHash1, simHash2);
        // ͨ�����������������ƶȣ�������
        return 0.01 * (100 - distance * 100 / 128);
    }

}
