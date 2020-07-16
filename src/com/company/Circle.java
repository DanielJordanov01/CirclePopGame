package com.company;

import java.awt.*;
import java.awt.geom.Ellipse2D;
import javax.swing.*;

class Circle extends JPanel {

	Shape shape;
	Graphics g;
	private int score = 0;
	private int width = 30;
	private int height = 30;

	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D g2 = (Graphics2D) g;

		double x = Math.random() * 250;
		double y = Math.random() * 250;

		shape = new Ellipse2D.Double(x, y, width, height);
		g2.setColor(Color.red);
		g2.fill(shape);
	}

	public void removeCircle() {
		revalidate();
		repaint();
		score += 10;
	}

	public int getScore() {
		return score;
	}

	public void increaseDimensions() {
		if (this.width == 90 && this.height == 90) {
			this.width += 0;
			this.height += 0;
		} else {
			this.width += 5;
			this.height += 5;
		}
		revalidate();
		repaint();
	}

	public void decreaseDimensions() {
		if (this.width == 10 && this.height == 10) {
			this.width -= 0;
			this.height -= 0;
		} else {
			this.width -= 5;
			this.height -= 5;
		}
		revalidate();
		repaint();
	}

	public void removeCircleAfterTime() {
		new java.util.Timer().schedule(
				new java.util.TimerTask() {
					@Override
					public void run() {
						removeCircle();
					}
				}, 2000, 1000
		);
	}
}