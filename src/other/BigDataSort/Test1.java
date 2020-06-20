package other.BigDataSort;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.*;

/***
 * 排序1G文件数字
 *
 */
public class Test1 {
    public static final int numSize = 1 << 27;
    public static final int fileNum = 1 << 4;

    public static final String orginalFilepath = "F:\\bigdata\\num.txt";
    public static final String result1Filepath = "F:\\bigdata\\result1.txt";
    public static final String result2Filepath = "F:\\bigdata\\result2.txt";

    /***
     * 不初始化时-Xmx100M
     * @param args
     * @throws Exception
     */
    public static void main(String[] args) throws Exception{
//        Init.init(numSize, orginalFilepath);

        long time1 = System.currentTimeMillis();
        Test1.kPathMergeSort(orginalFilepath, result1Filepath, fileNum);
//        Test1.bucketSort(orginalFilepath, result1Filepath, fileNum);

        long time2 = System.currentTimeMillis();
        System.out.println("kPathMergeSort:" + (time2 - time1));
//        System.out.println("bucketSort:" + (time2 - time1));

    }
    public static String getDataFilePath(int k) {
        return "F:\\bigdata\\data" + k + ".txt";
    }
    /***
     * 创建k个文件
     * @param k
     * @throws Exception
     */
    public static void createKFile(int k) throws Exception{
        if (k % 2 != 0) {
            throw new Exception("k要是2的倍数");
        }
        while (k-- > 0) {
            File file = new File(getDataFilePath(k));
            if (file.exists()) {
                file.delete();
            }
            file.createNewFile();
        }
    }
    /***
     * k路归并 +最小堆
     * @param filePath
     */
    public static void kPathMergeSort(String filePath, String resultPath, int k) throws Exception{
//        createKFile(k);
//        kPathMergeSortDivideFile(filePath, k);
        //k路归并
        Map<Integer, BufferedReader> fileKToReader = new HashMap<>();
        FileWriter fileWriter = null;
        fileWriter = new FileWriter(resultPath, false);
        PriorityQueue<SortNode> queue = new PriorityQueue<SortNode>(11,
                new Comparator<SortNode>() {
                    public int compare(SortNode p1, SortNode p2) {
                        return p2.val - p1.val;
                    }
                });
        Set<Integer> notEmptyK = new HashSet<>();
        for (int i = 1; i < k; i++) {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(getDataFilePath(i)));
            String line = bufferedReader.readLine();
            if (line != null) {
                int per = Integer.valueOf(line);
                queue.offer(new SortNode(per, i));
                notEmptyK.add(i);
            }
            fileKToReader.put(i, bufferedReader);
        }
        int cnt = 0;
        while (!queue.isEmpty()) {
            SortNode node = queue.poll();
            fileWriter.write(String.valueOf(node.val));
            fileWriter.write("\n");
            BufferedReader bufferedReader = fileKToReader.get(node.fileK);
            String line = bufferedReader.readLine();
            if (line != null) {
                int per = Integer.valueOf(line);
                queue.offer(new SortNode(per, node.fileK));
            }
            cnt++;
        }
        for (BufferedReader reader : fileKToReader.values()) {
            reader.close();
        }
        System.out.println("总排序" + cnt);
        fileWriter.close();
    }


    public static void kPathMergeSortDivideFile(String filePath, int k) throws Exception{
        BufferedReader in = new BufferedReader(new FileReader(filePath));
        int perFileCapacity = (int) numSize / k;
        int index = 1;
        String line = null;
        List<Integer> numList = new ArrayList<Integer>(perFileCapacity);
        int fileNum = 1;
        //分别排序
        while ((line = in.readLine()) != null) {
            Integer per = Integer.valueOf(line);
            numList.add(per);
            if (numList.size() > perFileCapacity) {
                Collections.sort(numList);
                writeFile(numList, getDataFilePath(fileNum));
                numList.clear();
                fileNum += 1;
            }
            index++;
        }
        in.close();

    }



    public static void writeFile(List<Integer> numList, String filePath) {
        FileWriter fileWriter = null;
        try {
            fileWriter = new FileWriter(filePath, false);
            for (int i = 0; i < numList.size(); i++) {
                fileWriter.write(numList.get(i).toString());
                fileWriter.write("\n");
            }
            fileWriter.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /***
     * 桶排序
     * @param filePath
     */
    public static void bucketSort(String filePath, String resultPath, int k) {

    }

    static final int hash(Object key) {
        int h;
        return (key == null) ? 0 : (h = key.hashCode()) ^ (h >>> 16);
    }

}
