import java.io.IOException;
import java.util.Scanner;

/**
 * Created by ZhangYucong on 2017/3/12.
 */
public class FileTest {
    public static void main(String[] args) throws IOException {
//        int scNum = 0;
//        int gNum = 0;
//        int thr = 0;
//        String circuitName = null;
//
//        Scanner input = new Scanner(System.in);
//        System.out.print("Input scan chain number: ");
//        scNum = input.nextInt();
//        System.out.print("Input group number: ");
//        gNum = input.nextInt();
//        System.out.print("Input circuit name: ");
//        circuitName = input.next();
//        System.out.print("Input threshold value: ");
//        thr = input.nextInt();
        CommandProcess command = new CommandProcess();
        command.setArgs(args);

        DepthFirst groupingGenerator = new DepthFirst(command.scNum, command.gNum);
        groupingGenerator.scGrouping.stream().forEach(System.out::println);
        Matrix matrix = new Matrix(command.circuitName);
        Heuristic heuristic = new Heuristic(command.scNum, command.gNum, command.circuitName, command.thr);
        System.out.println("heuristic grouping: " + heuristic.scGroup);
        for (int i=0; i<groupingGenerator.scGrouping.size(); i++){
            System.out.println("Grouping " + i);
            System.out.println(groupingGenerator.scGrouping.get(i).toString());
            System.out.println("Groping evulate(Lower is better): " +
                    matrix.groupEvaluate(groupingGenerator.scGrouping.get(i)));
        }
    }
}
