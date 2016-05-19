package map;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 * 1.影响HashMap 性能有两个因素：初始容量和加载因子（加载因子是个百分比，就是当哈希表中数据达到多少百分比时进行 rehash，重建数据结构）
 * 
 * 2.默认加载因子是0.75，初始容量为 16,求在时间和空间上一种折衷
 * 
 * 3.多个线程同时访问一个哈希表，其中至少一个线程从结构上修改了该映射（添加或删除映射，只改变映射值不算结构改变）， 则它必须保持外部同步，
 * 一般通过自然封装该映射的对象进行同步操作来完成。如果不存在，则使用 Map m= Collections.synchronizedMap(new HashMap()) 来封装
 * 
 * 4.HashMap 与 HashTable 最大区别在于 HashTable 是线程安全的，同样，性能也就下降了
 * 
 * 5.
 * @author 朱素海
 *
 */
public class HashMapTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Map map = new HashMap();//构造一个初始容量为16 ，加载因子0.75
		
		Map synMap= Collections.synchronizedMap(new HashMap());//这是一个线程安全的哈希表
		
		Map m2 = new HashMap(10, 0.8f);//构造有初始容量
		System.out.println(m2.size());
	}

}
