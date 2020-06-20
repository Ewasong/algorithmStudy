package VJ.uva.uva210;


import java.util.*;

/***
 * 1670ms ac
 */
public class Main {

    public static int n;
    public static int t1;//赋值用时;
    public static int t2;//打印用时;
    public static int t3;//锁定用时;
    public static int t4;//解锁用时;
    public static int t5;//end用时;
    public static int q; //每个程序执行时间
    public static Map<Character, Integer> charToInt;
    public static Deque<Program> seqQueue;
    public static Queue<Program> blockingQueue;
    public static boolean locked;

    public static class Program {
        public LinkedList<String> statement;
        public int leftTime;
        public int id;

        public Program(LinkedList<String> statement, int leftTime, int id) {
            this.statement = statement;
            this.leftTime = leftTime;
            this.id = id;
        }
    }
    public static void init() {
        seqQueue = new LinkedList<>();
        blockingQueue = new LinkedList<>();
        charToInt = new HashMap<>();
        for (int i = 'a'; i <= 'z'; i++) {
            charToInt.put((char)i, 0);
        }
        locked = false;
    }
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int t = scan.nextInt();
        scan.nextLine();
        while (t-- > 0) {
            //程序个数
            n = scan.nextInt();
            t1 = scan.nextInt(); //赋值用时;
            t2 = scan.nextInt(); //打印用时;
            t3 = scan.nextInt(); //锁定用时;
            t4 = scan.nextInt(); //解锁用时;
            t5 = scan.nextInt(); //end用时;
            q = scan.nextInt(); //每个程序执行时间;
            scan.nextLine();
            int curId = 1;
            init();
            while (curId <= n) {
                LinkedList<String> statementList = new LinkedList<>();
                String curLine = null;
                while ((curLine = scan.nextLine()) != null) {
                    statementList.add(curLine);
                    if ("end".equals(curLine)) {
                        break;
                    }
                }
                seqQueue.offer(new Program(statementList, 0, curId));
                curId++;
            }
            solve();
            if (t > 0) {
                System.out.println();
            }
        }
    }

    public static void solve() {
        while (!seqQueue.isEmpty()) {
            Program program = seqQueue.poll();
            if (program == null) {
                break;
            }
            int time = q;
            //执行语句
            while (!program.statement.isEmpty()) {
                if (time <= 0) {
                    seqQueue.add(program);
                    break;
                }
                String statement = program.statement.peek();
                if ("lock".equals(statement)) {
                    time -= t3;
                    if (locked) {
                        blockingQueue.add(program);
                        break;
                    } else {
                        locked = true;
                    }
                }
                program.statement.removeFirst();
                if ("unlock".equals(statement)){
                    time -= t4;
                    locked = false;
                    if (!blockingQueue.isEmpty()) {
                        Program o = blockingQueue.poll();
                        seqQueue.addFirst(o);
                    }
                } else if ("end".equals(statement)) {
                    break;
                } else if (statement.contains("=")) {
                    time -= t1;
                    char c = statement.charAt(0);
                    int num = Integer.parseInt(statement.substring(4));
                    charToInt.put(c, num);
                } else if (statement.contains("print")){
                    time -= t2;
                    char c = statement.charAt(6);
                    System.out.println(program.id + ": " + charToInt.get(c));
                }
            }
        }
    }


}
