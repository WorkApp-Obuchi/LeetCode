import java.util.*;

/*
 * 232. Implement Queue using
 * スタックしか使えないけど、キューのように動くデータ構造を作る問題」
 * ※なんか、お皿積みみたいなイメージの考えだった　Listとも違う、、
 *@param 引数名 引数の意味・使い方
 @return 返り値の意味
 */
public class ImplementQueueusing{
    static class MyQueue {
     //フィールド変数を作成
    Stack<Integer> inStack;
    Stack<Integer> outStack;
    //作成した変数をコンスタンス化
    public MyQueue() {
        inStack = new Stack<>();
        outStack = new Stack<>();
    }

    public void push(int x) {//上に追加
        inStack.push(x);
    }

    public int pop() {//上から取り出す
        shiftStacks();
        return outStack.pop();
    }

    public int peek() {//上を見る
        shiftStacks();
        return outStack.peek();
    }

    public boolean empty() {//空かどうか調べる
        return inStack.isEmpty() && outStack.isEmpty();
    }

    private void shiftStacks() {
        if (outStack.isEmpty()) { //outStackが空なら
            while (!inStack.isEmpty()) {
                outStack.push(inStack.pop());
            }
        }
    }
}
    //実施用に作成
    public static void main(String[] args) {
        // 出力を格納するリスト
        List<Object> output = new ArrayList<>();

        // ["MyQueue", "push", "push", "peek", "pop", "empty"]
        MyQueue myQueue = new MyQueue();
        output.add(null); // コンストラクタは null

        myQueue.push(1);
        output.add(null); // push は void → null

        myQueue.push(2);
        output.add(null); // push は void → null

        output.add(myQueue.peek());  // peek → 1
        output.add(myQueue.pop());   // pop → 1
        output.add(myQueue.empty()); // empty → false

        System.out.println(output);
    }
}
