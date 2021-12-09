package 归并排序;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.*;
import util.ArrayUtil;

/**
 * @author liutz
 * @date 2021/12/8
 */
public class MergeSort {

	public static void main(String[] args) throws Exception {
		int[] input = ArrayUtil.createArray(100);
//		System.out.println("input:" + Arrays.toString(input));
		int[] output = sort(input,3);
		System.out.println("output:" + Arrays.toString(output));
	}

	/**
	 *
	 * @param array 待排序的数据
	 * @param group	归并组数（2^n）
	 * @return
	 * @throws Exception
	 */
	public static int[] sort(int[] array,int group) throws Exception {
		int part = group * 2;
		if (array.length <= part) return null;
		double l = Math.log(part) / Math.log(2.0);
		if (l > (int) l) return null;

		ExecutorService pool = new ThreadPoolExecutor(group*2,20,5000, TimeUnit.MILLISECONDS,new LinkedBlockingQueue<>());
		ArrayList<int[]> list = new ArrayList<>();
		int partLen = array.length/part;
		for (int i = 0; i < part - 1; i++) {
			int[] p = Arrays.copyOfRange(array,i*partLen,(i+1)*partLen);
			list.add(p);
		}
		list.add(Arrays.copyOfRange(array,partLen*(part-1),array.length));
		CountDownLatch cd = new CountDownLatch(part);

		list.forEach(arr-> new Thread(()->{
			for (int i = 0; i < arr.length-1; i++) {
				int min;
				for (int j = i+1; j > 0; j--) {
					if (arr[j] < arr[j-1]) {
						min = arr[j];
						arr[j] = arr[j-1];
						arr[j-1] = min;
					} else {
						break;
					}
				}
			}
//			System.out.println(Arrays.toString(arr));
			cd.countDown();
		}).start());
		cd.await(5000, TimeUnit.MILLISECONDS);

		for (;;) {
			if(list.size()==1)break;
			CompletableFuture[] futures = new CompletableFuture[list.size()/2];
			ArrayList<int[]> newList = new ArrayList<>();
			for (int j = 0; j < list.size(); j++) {
				int[] arr1 = list.get(j);
				int[] arr2 = list.get(++j);
				int[] arr3 = new int[arr1.length + arr2.length];
				newList.add(arr3);
				futures[j/2] = CompletableFuture.runAsync(()->{
					int a = 0,b = 0;
					for (int k = 0; k < arr3.length;k++) {
						if (a == arr1.length) {
							arr3[k] = arr2[b];
							b++;
							continue;
						}
						if (b == arr2.length) {
							arr3[k] = arr1[a];
							a++;
							continue;
						}
						if (arr1[a] <= arr2[b]) {
							arr3[k] = arr1[a];
							a++;
						} else {
							arr3[k] = arr2[b];
							b++;
						}
					}
				},pool);
			}
			CompletableFuture.allOf(futures).join();
			list = newList;
		}
		pool.shutdownNow();
		return list.get(0);
	}

}
