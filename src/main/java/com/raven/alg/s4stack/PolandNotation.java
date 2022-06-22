package com.raven.alg.s4stack;


import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 逆波兰计算器
 * <p>
 * 例如：(3+4)*5-6  对应的后缀表达式就是 3 4 + 5 * 6 -
 * 1、从左到右扫描，将 3 和 4 压入堆栈
 * 2、遇到 + 运算符，因此弹出 4 和 3 ，计算出 3 + 4 = 7，在将 7 压入栈
 * 3、将 5 入栈
 * 4、接下来是 * 运算符，因此弹出 5 和 7，计算出 7 * 5 = 35，将 35 压栈
 * 5、将 6 入栈
 * 6、最后是 - 运算符，计算出 35 - 6 = 29，最后把 29 压入栈
 * <p>
 * 这就是后缀表达式计算思路，但是如何把 [中缀表达式] 转为 [后缀表达式]
 * <p>
 * [中缀表达式] 转为 [后缀表达式]
 * 后缀表达式：适合计算式进行运算，但是不适合人的书写
 * 中缀表达式：适合人的书写，但是不适合计算式运算
 * 所以需要把 [中缀表达式] 转为 [后缀表达式]
 * 思路：
 * 1、初始化两个栈：运算符栈（s1）和 存储中间结果的栈（s2）
 * 2、从左到右扫描中缀表达式
 * 3、遇到操作数时，将其压s2
 * 4、遇到运算符时，与 s1 栈顶的运算符比较优先级
 * 4.1、如果 s1 为空，或栈顶运算符为左括号"("，则直接将此运算符入栈
 * 4.2、否则，若优先级比栈顶运算符的高，也将运算符压入s1
 * 4.3、否则，将 s1 栈顶的运算符弹出并压入到 s2 中，再次转到 4.1 与 s1 中新的栈顶运算符相比较
 * 5、遇到括号时
 * 5.1、如果是左括号"("，则直接压入s1
 * 5.2、如果是右括号")"，则依次弹出 s1 栈顶的运算符，并压入 s2 ，直到遇到左括号为止，此时将这一对括号丢弃
 * 6、重复步骤 2~5，直到表达式的最右侧
 * 7、将 s1 中剩余的运算符依次弹出并压入 s2
 * 8、依次弹出 s2 中的元素并输出，结果的逆序即为中缀表达式对应的后缀表达式
 */
public class PolandNotation {


    /**
     * 计算器
     *
     * @param poland
     * @return
     */
    public static Integer calculatorPoland(List<String> poland) {
        return Operation.calculator(poland);
    }


    /**
     * 例如：(3+4)*5-6  对应的后缀表达式就是 3 4 + 5 * 6 -
     * [中缀表达式] 转为 [后缀表达式]
     * 后缀表达式：适合计算式进行运算，但是不适合人的书写
     * 中缀表达式：适合人的书写，但是不适合计算式运算
     * 所以需要把 [中缀表达式] 转为 [后缀表达式]
     * 思路：
     * 1、初始化两个栈：运算符栈（s1）和 存储中间结果的栈（s2）
     * 2、从左到右扫描中缀表达式
     * 3、遇到操作数时，将其压s2
     * 4、遇到运算符时，与 s1 栈顶的运算符比较优先级
     * 4.1、如果 s1 为空，或栈顶运算符为左括号"("，则直接将此运算符入栈
     * 4.2、否则，若优先级比栈顶运算符的高，也将运算符压入s1
     * 4.3、否则，将 s1 栈顶的运算符弹出并压入到 s2 中，再次转到 4.1 与 s1 中新的栈顶运算符相比较
     * 5、遇到括号时
     * 5.1、如果是左括号"("，则直接压入s1
     * 5.2、如果是右括号")"，则依次弹出 s1 栈顶的运算符，并压入 s2 ，直到遇到左括号为止，此时将这一对括号丢弃
     * 6、重复步骤 2~5，直到表达式的最右侧
     * 7、将 s1 中剩余的运算符依次弹出并压入 s2
     * 8、依次弹出 s2 中的元素并输出，结果的逆序即为中缀表达式对应的后缀表达式
     */
    public static List<String> parsePoland(String ls) {
        // 运算符栈（s1）
        Stack<String> s1 = new Stack<>();
        // 存储中间结果的栈（s2）
        List<String> list = new ArrayList<>();
        // 去除空格
        String trim = ls.trim();
        Integer index = 0;
        // 拼接多位数
        StringBuilder numBuilder = null;

        while (index < trim.length()) {
            String sub = trim.substring(index, index + 1);
            System.out.println("index = " + index + " sub = " + sub);

            // 3、遇到操作数时，将其压s2
            if (sub.matches("\\d+")) {
                numBuilder = new StringBuilder("");
                while (sub.matches("\\d+") && index < trim.length()) {
                    numBuilder.append(sub);
                    index++;
                    if (index < trim.length()) {
                        sub = trim.substring(index, index + 1);
                    }
                }
                list.add(numBuilder.toString());
                // 减去 while 中的 ++
                index--;
            }
            // 4、遇到运算符时，与 s1 栈顶的运算符比较优先级
            else if (Operation.isOperation(sub)) {
                while (true) {
                    // 4.1、如果 s1 为空，或栈顶运算符为左括号"("，则直接将此运算符入栈
                    if (s1.isEmpty() || s1.peek().equals("(")) {
                        s1.push(sub);
                        break;
                    }
                    // 4.2、否则，若优先级比栈顶运算符的高，也将运算符压入s1
                    else if (Operation.priority(sub) > Operation.priority(s1.peek())) {
                        s1.push(sub);
                        break;
                    }
                    // 4.3、否则，将 s1 栈顶的运算符弹出并压入到 s2 中，再次转到 4.1 与 s1 中新的栈顶运算符相比较
                    else {
                        list.add(s1.pop());
                    }
                }
            }
            // 5、遇到括号时
            // 5.1、如果是左括号"("，则直接压入s1
            else if (sub.equals("(")) {
                s1.push(sub);
            }
            // 5、遇到括号时
            // 5.2、如果是右括号")"，则依次弹出 s1 栈顶的运算符，并压入 s2 ，直到遇到左括号为止，此时将这一对括号丢弃
            else if (sub.equals(")")) {
                while (!s1.peek().equals("(")) {
                    list.add(s1.pop());
                }
                // 丢弃 s1 的左括号
                s1.pop();
            }
            index++;
        }


        // 7、将 s1 中剩余的运算符依次弹出并压入 s2
        while (!s1.isEmpty()) {
            list.add(s1.pop());
        }

        // 8、依次弹出 s2 中的元素并输出，结果的逆序即为中缀表达式对应的后缀表达式

        return list;
    }

}


/**
 * 操作
 */
class Operation {

    /**
     * 判断是否为操作符
     */
    public static Boolean isOperation(String item) {
        return "+".equals(item) || "-".equals(item) || "*".equals(item) || "/".equals(item);
    }


    /**
     * 判断操作符的优先级
     */
    public static int priority(String item) {
        switch (item) {
            case "+":
            case "-":
                return 1;

            case "*":
            case "x":
            case "/":
                return 2;
            default:
                throw new RuntimeException("操作符错误");
        }
    }


    /**
     * 判断操作符的优先级
     * 3 4 + 5 * 6 -
     */
    public static Integer calculator(List<String> poland) {
        Integer res = 0;
        Stack<String> stack = new Stack<>();
        for (String item : poland) {
            // 如果是数字
            if (item.matches("\\d+")) {
                stack.push(item);
            } else {
                int num1 = Integer.parseInt(stack.pop());
                int num2 = Integer.parseInt(stack.pop());

                switch (item) {
                    case "+":
                        res = num1 + num2;
                        break;
                    case "-":
                        res = num2 - num1;
                        break;
                    case "*":
                    case "x":
                        res = num1 * num2;
                        break;
                    case "/":
                        res = num2 / num1;
                        break;
                    default:
                        throw new RuntimeException("操作符错误");
                }
                // 结果入栈
                stack.push(res.toString());
            }
        }
        return res;
    }
}
