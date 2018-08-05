package TestClass;

import static org.hamcrest.CoreMatchers.nullValue;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Stack;
import java.util.stream.Stream;

import org.junit.Test;

import AbstractFactory.rectangle;
import javafx.scene.transform.Translate;

public class ViewTest {
	
	/*
	 * 该方法有缺陷
	 * 求一个数组中元素和为指定值的子串
	 * 求一个数组中元素和为指定值的子串
	 * 求一个数组中元素和为指定值的字串
	 * 例如：a = {5,2,3,4};
	 * sum = 6
	 * 字串为:{2,4}
	 */
	@Test
	public void test(){
		int[] a = new int[]{5,2,3,4};
		int sum = 8;
		List<Integer> list = findsub(a, sum);
		if (list != null) {
			for (Integer integer : list) {
				System.out.print(integer+" ");
			}
		}else {
			System.out.println("没有符合条件的字串");
		}
		
	}
	public List<Integer> findsub(int[] a,int sum){
		//数组需要在定义的时候给定大小，不适合动态的添加元素，
		//所以使用list来存储符合条件的数组
		List<Integer> list = new ArrayList<Integer>();
		int strsum = 0;
		for (int i = 0; i < a.length; i++) {
			strsum += a[i]; //以每个元素为基点
			int k = 1;		//k代表从第几个元素开始累加
			while ((strsum < sum)&&(i+k<a.length)) {			
				for (int j = i+k; j < a.length; j++) {
					strsum += a[j];
					if (strsum < sum) {
						list.add(a[j]);
					}else if(strsum==sum){
						list.add(a[j]);
						return list;
					}else if (strsum>sum) {
						strsum -= a[j];
					}
				}//若for循环一遍没找到合适的元素，则从下一个元素开始累加
				k++;
				list.clear();
				list.add(a[i]);//把初始值添加上
				strsum = a[i];
			}
			if (strsum==sum) {
				list.add(a[i]);
				return list;
			}else if(strsum>sum){
				strsum -= a[i];
			}
		}
		return null;
	}
	
	/*
	 * 输入一个字符串，打印该字符串的所有排列，子串不算
	 */
	@Test
	public void test2(){
		char[] cs = {'a','b','c','d'}; int length = cs.length;        
        recursionSwap(cs,0,length);
    } 
	public void swap(char[] cs,int index1,int index2){ 
		char temp = cs[index1];
        cs[index1]=cs[index2];
        cs[index2]=temp;        
    } 
	public void recursionSwap(char[] cs,int start,int length){ 
		if(start>=length-1){
            print(cs); 
            return;
        } 
		//关键代码
		for(int i=start;i<length;i++){
            swap(cs,start,i);
            recursionSwap(cs,start+1,length);    
            swap(cs,start,i);
        }
    } 
	public void print(char[] cs){ 
		for(int i=0;i<cs.length;i++){
            System.out.print(cs[i]);
        }
        System.out.println();
	}
	
	/*
	 * 输入一个正整数数组，把这些数字全部排列起来组成一个数字
	 * 输出其中最小的一个数字
	 * 思路：先把这些数字转换为字符串进行整合，整合完成后转换成数字比较大小
	 */
	@Test
	public void test4(){
		int[] a = new int[]{1,22,44,23,67};
		int length = a.length;
		String[] strings = translateStrings(a);
		List<Integer> b = new ArrayList<Integer>();
		rescute(strings,0,length,b);
		compare(b);
	}
	//把整型数组转换为字符串
	public String[] translateStrings(int[] a){
		int length = a.length;
		String[] strings = new String[length];
		for (int i = 0; i < length; i++) {
			strings[i] = String.valueOf(a[i]);
		}
		return strings;
	}
	//把字符串转换成整型数组
	public int[] translateInt(String[] strings){
		int length = strings.length;
		int[] a = new int[length];
		for (int i = 0; i < length; i++) {
			a[i] = Integer.parseInt(strings[i]);
		}
		return a;
	}
	//数组的排列
	public void rescute(String[] strings,int start,int end,List<Integer> b){
		if (start>=end-1) {
			//一种排列方式就是一个数字
			String str = "";
			for (int i = 0; i < strings.length; i++) {
				str += strings[i];
			}
			b.add(Integer.parseInt(str));
			return;
		}
		for (int i = start; i < end; i++) {
			swapstring(strings, i, start);
			rescute(strings, start+1, end, b);
			swapstring(strings, start, i);
		}
	}
	public void swapstring(String[] strings,int i,int j){
		String tempString = strings[i];
		strings[i] = strings[j];
		strings[j] = tempString;
	}
	//比较大小并输出
	public void compare(List<Integer> b){
		int min = b.get(0);
		for (int i = 1; i < b.size(); i++) {
			if (b.get(i)<min) {
				min = b.get(i);
			}			
		}
		System.out.print(min);
	}
}
