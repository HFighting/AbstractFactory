package TestClass;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.junit.Test;

import AbstractFactory.rectangle;

public class ViewTest {
	
	/*
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
	
}
