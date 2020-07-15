package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class CirclePop {

	JFrame frame;
	JLabel score = new JLabel("Score: " + 0);
	Circle circle;
	JButton enlargeSize;
	JButton reduceSize;

	public static void main(String[] args) {
		CirclePop circlePop = new CirclePop();
		circlePop.drawFrame();
	}

	public void drawFrame() {
		frame = new JFrame();
		circle = new Circle();
		enlargeSize = new JButton("+");
		reduceSize = new JButton("-");
		JPanel scorePanel = new JPanel();
		JPanel buttonsPanel = new JPanel();

		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().add(scorePanel, BorderLayout.WEST);
		frame.getContentPane().add(buttonsPanel, BorderLayout.EAST);
		scorePanel.add(score);
		buttonsPanel.add(enlargeSize);
		buttonsPanel.add(reduceSize);
		frame.getContentPane().add(circle);

		circle.addMouseListener(new DestroyCircleController());
		enlargeSize.addMouseListener(new EnlargeButtonPress());
		reduceSize.addMouseListener(new ReduceButtonPress());

		frame.setSize(500, 500);
		frame.setVisible(true);
	}

	class DestroyCircleController extends MouseAdapter {
		@Override
		public void mousePressed(MouseEvent e) {
			if (circle.shape.contains(e.getPoint())) {
				circle.removeCircle();
				score.setText("Score: " + circle.getScore());
			}
		}
	}

	class EnlargeButtonPress extends MouseAdapter {
		@Override
		public void mousePressed(MouseEvent e) {
			circle.increaseDimensions();
		}
	}

	class ReduceButtonPress extends MouseAdapter {
		@Override
		public void mousePressed(MouseEvent e) {
			circle.decreaseDimensions();
		}
	}
}