
import java.util.Stack;
/*
 * 682. Baseball Game
 * 与えられた操作の配列から最終スコアを計算する。
 * @param operations 操作を表す文字配列
 *                   -数字：そのままスコアに追加
 *                   -"C"：直前のスコアを削除
 *                   -"D"：直前のスコアを２倍
 *                   -"+"：直前の２つのスコアの合計を追加
 * @return 最終的なスコアの合計
 */

public class BaseballGame {
  public int calPoints(String[] operations){
    Stack<Integer> stack = new Stack<>(); //空のスタックを作成

    for(String op: operations){
      //数字の場合の処理
      if(isNumber(op)){
        int num = Integer.parseInt(op);
        stack.push(num);
      }
      // "C" の場合は直前のスコアを削除
      else if(op.equals("C")){
        stack.pop();
      }
     // "D" の場合は直前のスコアを2倍して追加
      else if(op.equals("D")){
        stack.push(stack.peek() * 2);
      }
      // "+" の場合は直前2つのスコアを合計して追加
      else if(op.equals("+")){
        int last = stack.pop();//直前のスコアを取り出す
        int second = stack.peek();//直前の２つ目のスコアみる
        stack.push(last);
        stack.push(last + second);
      }
    }
    //スタックに残った全てのスコアを計算
    int num = 0;
    for(int s : stack){
      num = num + s;
    }
    return num;
  }
  //数字か判断するメソッド
  private boolean isNumber(String s){
    try {
      Integer.parseInt(s);
      return true;
    } catch (NumberFormatException e) {
      return false;
    }
  }

  public static void main(String[] args){
    BaseballGame game = new BaseballGame();

        // Example 1
        String[] ops1 = {"5","2","C","D","+"};
        System.out.println("Example 1 result: " + game.calPoints(ops1)); // 30

        // Example 2
        String[] ops2 = {"5","-2","4","C","D","9","+","+"};
        System.out.println("Example 2 result: " + game.calPoints(ops2)); // 27

        // Example 3
        String[] ops3 = {"1","C"};
        System.out.println("Example 3 result: " + game.calPoints(ops3)); // 0
  }
}
