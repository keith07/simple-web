package edu.keith.algorithm;

import java.util.ArrayList;
import java.util.List;

/**
 * 九点解锁
 * @author keith
 *
 */
public class Point9 {
	private List<Point> points;
	/**
	 * 两点之间最短距离
	 */
	private int minLen = 3;
	
	/**
	 * 产生numPerLine*numPerLine个点
	 * @param numPerLine
	 */
	public void buildPoints(int numPerLine){
		points = new ArrayList<Point>();
		for(int i=0; i < numPerLine; i++){
			for(int j=0; j < numPerLine; j++){
				Point point = new Point(i,j);
				points.add(point);
			}
		}
		initPoint();
	}
	
	/**
	 * 计算可达路径
	 */
	private void initPoint(){
		
	}
	
	public static void main(String[] args){
		
	}

	class Point{
		private int x;
		private int y;
		private List<Point> reachablePoints;
		
		public Point(int x,int y){
			this.x = x;
			this.y = y;
		}

		public List<Point> getReachablePoints() {
			return reachablePoints;
		}

		public void setReachablePoints(List<Point> reachablePoints) {
			this.reachablePoints = reachablePoints;
		}

		public int getX() {
			return x;
		}

		public int getY() {
			return y;
		}
	}
	
	class Path{
		int x1,x2,y1,y2;
		
		public Path(Point p1,Point p2){
			x1=p1.getX();
			y1=p1.getY();
			x2=p2.getX();
			y2=p2.getY();
		}
		
		/**
		 * 判断路径是否合法
		 *   路径上包含其他合法的点则路径不合法
		 * @return
		 */
		public boolean isAvailable(){
			return false;
		}
	}
}
