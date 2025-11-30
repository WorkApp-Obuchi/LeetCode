import java.util.*;
/*
 * 225. Implement Stack using Queues
 * キューしか使えないけど、スタックのように動くデータ構造を作る問題」
 * ※キューは先頭しか取り出せない　スタックは最後の要素を取り出す
 * @param 引数名 引数の意味・使い方
  @return 返り値の意味
 */
public class ImplementStackusingQueues {
      //フィールド変数を作成
    Queue<Integer> q1;
    Queue<Integer> q2;
    //作成した変数をコンスタンス化
    public ImplementStackusingQueues() {
        q1 = new LinkedList<>();
        q2 = new LinkedList<>();
    }

    public void push(int x) {
        q1.offer(x); //後ろに追加
    }

    public int pop() {
        if(empty())return -1; //空の場合は-1を返す。
        while(q1.size() > 1){ //q1の最後1つ以外をq2に移す
            q2.offer(q1.poll());
        }
        int top = q1.poll(); //q1の最後の要素を取り出す
        //入れ替え
        Queue<Integer> tmp = q1;
        q1 = q2;
        q2 = tmp;
        return top;
    }

    public int top() {
        if (empty()) return -1; //空の場合は-1を返す。
        while (q1.size() > 1) {//q1の最後1つ以外をq2に移す
            q2.offer(q1.poll());
        }
        int top = q1.poll();
        q2.offer(top); // top は Stack から消さずに戻す
        // 入れ替え
        Queue<Integer> tmp = q1;
        q1 = q2;
        q2 = tmp;
        return top;
    }

    public boolean empty() {
        return q1.isEmpty() && q2.isEmpty();
    }

    public static void main(String[] args) {
        // Example1 の動作を再現
        ImplementStackusingQueues stack = new ImplementStackusingQueues();

        stack.push(1);
        stack.push(2);

        System.out.println(stack.top());   // 2
        System.out.println(stack.pop());   // 2
        System.out.println(stack.empty()); // false
    }
}
