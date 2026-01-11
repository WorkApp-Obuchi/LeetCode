package LeetCode.LinkedList;

import java.util.ArrayDeque;
import java.util.Deque;

public class CalPoints {
    public int  calPoints(String[] operations) {
        Deque<Integer> stack = new ArrayDeque<>();

        for(String ope : operations) {
            switch(ope) {
                case "C": // 直前のスコアを削除
                    stack.pop();
                    break;
                case "D": // 直前のスコアの2倍を追加
                    stack.push(stack.peek() * 2);
                    break;
                case "+":
                    int top = stack.pop();
                    int newScore = top + stack.peek();
                    stack.push(top);
                    stack.push(newScore);
                    break;
                default:
                    // 整数として記録
                    stack.push(Integer.parseInt(ope));
                    break;
            }
        }
        int total = 0;
        for(int score : stack) {
            total += score;
        }
        return total;
    }

    public static void main(String[] args) {
        CalPoints solution = new CalPoints();

        // testcase1
        String[] ope1 = {"5","2","C","D","+"};
        int result1 = solution.calPoints(ope1);
        System.out.println("testcase1 : " + result1);// 30

        // testcase2
        String[] ope2 = {"5","-2","4","C","D","9","+","+"};
        int result2 = solution.calPoints(ope2);
        System.out.println("testcase2 : " + result2);// 27

        // testcase3
        String[] ope3 = {"1","C"};
        int result3 = solution.calPoints(ope3);
        System.out.println("testcase3 : " + result3);// 0
    }
}
