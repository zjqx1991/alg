package com.raven.alg.s5recursion;

public class Queue82 {

	//数组大小
	int max = 8;
	// arr = {0 , 4, 7, 5, 2, 6, 1, 3}
	int[] array = new int[max];
	static int count = 0;
	static int judgeCount = 0;
	public static void main(String[] args) {
		Queue82 queue8 = new Queue82();
		queue8.check(0);
		System.out.printf("共有%d种ⷨ", count);
		System.out.printf("共回溯%d次", judgeCount); // 1.5w
		System.out.println();
	}



	private void check(int n) {
		if(n == max) {  //n = 8 代表防止成功
			print();
			return;
		}

		//表示每个皇后都是从0列开始
		for(int i = 0; i < max; i++) {
			//第n+1个皇后防止在第i+1列表
			array[n] = i;
			//判断是否可以放置皇后在n+1位置
			if(judge(n)) {
				// 防止下一行
				check(n+1);
			}
		}
	}

	/**
	 *	判断是否可以放置皇后
	 * @param n
	 * @return
	 */
	private boolean judge(int n) {
		judgeCount++;
		for(int i = 0; i < n; i++) {
			//1. array[i] == array[n]  表示在同一列
			//2. Math.abs(n-i) == Math.abs(array[n] - array[i]) 表示在一个斜线上
			// n = 1  ���õ� 2�� 1 n = 1 array[1] = 1
			// Math.abs(1-0) == 1  Math.abs(array[n] - array[i]) = Math.abs(1-0) = 1
			if(array[i] == array[n] || Math.abs(n-i) == Math.abs(array[n] - array[i]) ) {
				return false;
			}
		}
		return true;
	}

	//输出
	private void print() {
		count++;
		for (int i = 0; i < array.length; i++) {
			System.out.print(array[i] + " ");
		}
		System.out.println();
	}

}
