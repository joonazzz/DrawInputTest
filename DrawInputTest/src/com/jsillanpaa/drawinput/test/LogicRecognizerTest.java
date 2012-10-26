package com.jsillanpaa.drawinput.test;

import com.jsillanpaa.drawinput.hwr.HwrStroke;
import com.jsillanpaa.drawinput.hwr.LogicRecognizer;
import com.jsillanpaa.drawinput.hwr.SpecialCharLogicRecognizer;

import android.graphics.PointF;
import android.test.AndroidTestCase;

public class LogicRecognizerTest extends AndroidTestCase {
	private static final int CANVAS_HEIGHT = 300;
	private static final int CANVAS_WIDTH = 300;
	private SpecialCharLogicRecognizer mLogicRecognizer;

	@Override
	protected void setUp() throws Exception {
		mLogicRecognizer = new SpecialCharLogicRecognizer(CANVAS_WIDTH, CANVAS_HEIGHT);
		super.setUp();
	}

	public void testHorVerCrossNearCenter() throws Exception {
		HwrStroke stroke1 = new HwrStroke(1);
		HwrStroke stroke2 = new HwrStroke(1);
		HwrStroke stroke3 = new HwrStroke(1);
		
		PointF s1_p0 = new PointF(-100.0f, 0.0f);
		PointF s1_p1 = new PointF(100.0f, 0.0f);
		
		PointF s2_p0 = new PointF(0.0f, 100.0f);
		PointF s2_p1 = new PointF(0.0f, -100.0f);
		
		PointF s3_p0 = new PointF(100.0f, 100.0f);
		PointF s3_p1 = new PointF(100.0f, -100.0f);
		
		stroke1.points.add(s1_p0);
		stroke1.points.add(s1_p1);
		
		stroke2.points.add(s2_p0);
		stroke2.points.add(s2_p1);
		
		stroke3.points.add(s3_p0);
		stroke3.points.add(s3_p1);
		
		assertTrue(mLogicRecognizer.horVerCrossNearCenter(stroke1, stroke2));
		assertFalse(mLogicRecognizer.horVerCrossNearCenter(stroke3, stroke2));
		
	}
	
	public void testIsDiagonalLine() throws Exception {
		HwrStroke stroke1 = new HwrStroke(1);
		PointF s1_p0 = new PointF(-100.0f, -100.0f);
		PointF s1_p1 = new PointF(100.0f, 100.0f);
		stroke1.points.add(s1_p0);
		stroke1.points.add(s1_p1);
		
		HwrStroke stroke2 = new HwrStroke(1);
		stroke2.points.add(new PointF(-100f, 100f));
		stroke2.points.add(new PointF(-80f, 75f));
		stroke2.points.add(new PointF(-20f, 25f));
		
		HwrStroke stroke3 = new HwrStroke(1);
		stroke3.points.add(new PointF(100f, 100f));
		stroke3.points.add(new PointF(80f, 200f));
		stroke3.points.add(new PointF(20f, 25f));
		
		assertEquals(-1.0f, mLogicRecognizer.isDiagonalLine(stroke1,true));
		assertEquals(1.0f, mLogicRecognizer.isDiagonalLine(stroke2,true));
		assertEquals(0.0f, mLogicRecognizer.isDiagonalLine(stroke3,true));
	}
	public void testCrossNearCenter() throws Exception {
		HwrStroke stroke1 = new HwrStroke(1);
		HwrStroke stroke2 = new HwrStroke(1);
		HwrStroke stroke3 = new HwrStroke(1);
		
		PointF s1_p0 = new PointF(-100.0f, -100.0f);
		PointF s1_p1 = new PointF(100.0f, 100.0f);
		
		PointF s2_p0 = new PointF(-100.0f, 100.0f);
		PointF s2_p1 = new PointF(100.0f, -100.0f);
		
		PointF s3_p0 = new PointF(-100.0f, 100.0f);
		PointF s3_p1 = new PointF(100.0f, 100.0f);
		
		stroke1.points.add(s1_p0);
		stroke1.points.add(s1_p1);
		
		stroke2.points.add(s2_p0);
		stroke2.points.add(s2_p1);
		
		stroke3.points.add(s3_p0);
		stroke3.points.add(s3_p1);
		
		assertTrue(LogicRecognizer.crossNearCenter(stroke1, stroke2));
		assertFalse(LogicRecognizer.crossNearCenter(stroke1, stroke3));
		assertFalse(LogicRecognizer.crossNearCenter(stroke2, stroke3));
		
	}
	
	public void testIsNearCenter() throws Exception {
		HwrStroke stroke1 = new HwrStroke(1);
		PointF s1_p0 = new PointF(-100.0f, -100.0f);
		PointF s1_p1 = new PointF(100.0f, 100.0f);
		stroke1.points.add(s1_p0);
		stroke1.points.add(s1_p1);
		
		assertTrue(LogicRecognizer.isNearCenter(0.0f, stroke1));
		assertFalse(LogicRecognizer.isNearCenter(1.0f, stroke1));
		assertFalse(LogicRecognizer.isNearCenter(-0.5f, stroke1));
		
	}
}
