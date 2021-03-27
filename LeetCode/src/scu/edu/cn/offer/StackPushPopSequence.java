package scu.edu.cn.offer;

import java.util.Stack;

/**
 * @program: leetcode
 * @description: 栈的压入、弹出序列
 * 输入两个整数序列，第一个序列表示栈的压入顺序，请判断第二个序列是否为该栈的弹出顺序。假设压入栈的所有数字均不相
 * 等。例如，序列 {1,2,3,4,5} 是某栈的压栈序列，序列 {4,5,3,2,1} 是该压栈序列对应的一个弹出序列，但 {4,3,5,1,2} 就不可能是该压
 * 栈序列的弹出序列。
 * @create: 2021-03-27 16:04
 **/
public class StackPushPopSequence {
    public static void main(String[] args) {

    }
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        Stack<Integer> stack = new Stack<>();
        int index = 0;
        for (int value : pushed) {
            stack.add(value);
            while (!stack.empty()) {
                if (stack.peek() == popped[index]) {
                    stack.pop();
                    index++;
                } else {
                    break;
                }
            }
        }
        return stack.empty();
    }
}
