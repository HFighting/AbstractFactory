package MinStack;

import java.util.Stack;

class MinStack{ 
	private Stack<Integer> minStack = new Stack<Integer>(); //存储最小值的栈，一直存储最小的值
	private Stack<Integer> stack = new Stack<Integer>();  //普通的栈
	//最小值栈与普通栈是一一对应关系，最小值栈中存储的每一个元素都是普通栈中当前数目元素的最小值
	//peek()查看栈顶元素，不会移除该元素
	public int pop(){//每次出栈，两个栈都要出栈
		minStack.pop(); //出栈
		return stack.pop();
	} 
	public void push(int num){ 
		if(minStack.size()<=0){
			minStack.push(num); 
			return;
		}
		Integer min = minStack.lastElement(); 
		if(num<min){
			minStack.push(num);
		} else{
			minStack.push(min);
		}
		stack.push(num);
	} 
	public int min(){ 
		if(minStack.size()<=0){ 
			return -1;
		} 
		return minStack.lastElement();
	}
}