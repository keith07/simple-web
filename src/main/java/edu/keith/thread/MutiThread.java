package edu.keith.thread;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CountDownLatch;

public class MutiThread {
	
	private CountDownLatch latch;

	public static void main(String[] args){
		List<Integer> intSet = new ArrayList<Integer>();
		for(int i=0;i<10000;i++)
			intSet.add(i+1);
		MutiThread thread = new MutiThread();
		System.out.println(thread.compute(intSet, 10));
	}
	
	public OperationSet compute(List<Integer> intSet,int threadNum){
		if(intSet == null || intSet.size()==0)
			return null;
		int realThreadNum = Math.min(intSet.size()/10,threadNum);
		int perNum = intSet.size()/realThreadNum;
		List<OperationSet> sets = new ArrayList<OperationSet>();
		latch = new CountDownLatch(realThreadNum);
		for(int i=0; i<realThreadNum; i++){
			int fromIndex=i*perNum;
			int toIndex=(i+1)*perNum;
			if(i==realThreadNum-1)
				toIndex=intSet.size();
			sets.add(_compute(intSet.subList(fromIndex, toIndex)));
		}
		try {
			latch.await();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		OperationSet set = sets.get(0);
		int count = set.getCount();
		int minVal = set.getMinVal();
		int maxVal = set.getMaxVal();
		long sumVal = set.getSumVal();
		for(int i=1; i<sets.size();i++){
			set = sets.get(i);
			count +=set.getCount();
			minVal = Math.min(set.getMinVal(), minVal);
			maxVal = Math.max(set.getMaxVal(), maxVal);
			sumVal +=set.getSumVal();
		}
		return new OperationSet(minVal,maxVal,count,sumVal);
	}
	
	private OperationSet _compute(final List<Integer> intSet){
		final OperationSet set = new OperationSet();
		Thread t = new Thread(new Runnable(){
			public void run() {
				System.out.println(Thread.currentThread().getName()+"is running");
				// TODO Auto-generated method stub
				int count = intSet.size();
				if(count == 0){
					latch.countDown();
					return;
				}
				int minVal = intSet.get(0);
				int maxVal = minVal;
				long sumVal = minVal;
				for(int i=1; i<count; i++){
					int val = intSet.get(i);
					minVal = Math.min(minVal, val);
					maxVal = Math.max(maxVal, val);
					sumVal += val;
				}
				set.setCount(count);
				set.setMaxVal(maxVal);
				set.setMinVal(minVal);
				set.setSumVal(sumVal);
				latch.countDown();
				
				System.out.println(latch.getCount());
			}
		});
		t.start();
		return set;
	}
}

class OperationSet{
	private int minVal;
	private int maxVal;
	private int count;
	private long sumVal;
	public OperationSet(){}
	public OperationSet(int minVal,int maxVal,int count,long sumVal){
		this.minVal = minVal;
		this.maxVal = maxVal;
		this.count = count;
		this.sumVal = sumVal;
	}
	public int getMinVal() {
		return minVal;
	}
	public void setMinVal(int minVal) {
		this.minVal = minVal;
	}
	public int getMaxVal() {
		return maxVal;
	}
	public void setMaxVal(int maxVal) {
		this.maxVal = maxVal;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	public long getSumVal() {
		return sumVal;
	}
	public void setSumVal(long sumVal) {
		this.sumVal = sumVal;
	}
	@Override
	public String toString() {
		return "minVal:"+minVal+"maxVal:"+maxVal+"count:"+count+"sumVal:"+sumVal;
	}
	
	
}
