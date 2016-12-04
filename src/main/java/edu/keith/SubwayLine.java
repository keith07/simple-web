package edu.keith;

import java.util.List;

/**
 * Created by Administrator on 2016/3/18.
 */
public class SubwayLine {
	private int lineNum;
	private String stopName;
	private SubwayLine previous;
	private SubwayLine next;
	private List<SubwayLine> transferLines;
}
