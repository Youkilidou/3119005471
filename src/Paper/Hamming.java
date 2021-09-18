package Paper;

public class Hamming{
	 /*
     * 输入两个simHash值，计算它们的汉明距离
     * return 汉明距离
     */
    public static int getHammingDistance(String simHash1, String simHash2) {//汉明距离#######
        int distance = 0;
        if (simHash1.length() != simHash2.length()) {
            // 出错，返回-1
            distance = -1;
        } else {
            for (int i = 0; i < simHash1.length(); i++) {
                // 每一位进行比较
                if (simHash1.charAt(i) != simHash2.charAt(i)) {
                    distance++;
                }
            }
        }
        return distance;
    }

    /*
     * 输入两个simHash值，输出相似度
     * return 相似度
     */
    public static double getSimilarity(String simHash1, String simHash2) {//相似度#########
    	
        // 通过 simHash1 和 simHash2 获得它们的汉明距离
        int distance = getHammingDistance(simHash1, simHash2);
        // 通过汉明距离计算出相似度，并返回
        return 0.01 * (100 - distance * 100 / 128);
    }

}
