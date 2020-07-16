package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class CirclePop {

    JFrame frame;
    JLabel scoreText = new JLabel("Score: " + 0);
    JLabel sizeText = new JLabel("Size: ");
    Circle circle;
    JButton enlargeSize;
    JButton reduceSize;

    public static void main(String[] args) {
        CirclePop circlePop = new CirclePop();
        circlePop.drawFrame();
    }

    public void drawFrame() {
    	// Initializations
        frame = new JFrame();
        circle = new Circle();
        enlargeSize = new JButton("+");
        reduceSize = new JButton("-");
        JPanel scorePanel = new JPanel();
        JPanel buttonsPanel = new JPanel();

        // Add Graphics
        frame.getContentPane().add(scorePanel, BorderLayout.WEST);
        frame.getContentPane().add(buttonsPanel, BorderLayout.EAST);
        scorePanel.add(scoreText);
        buttonsPanel.add(sizeText);
        buttonsPanel.add(enlargeSize);
        buttonsPanel.add(reduceSize);
        frame.getContentPane().add(circle);

        // Event Listeners
        circle.addMouseListener(new DestroyCircleController());
        enlargeSize.addMouseListener(new EnlargeButtonPress());
        reduceSize.addMouseListener(new ReduceButtonPress());

        // frame configs
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500, 500);
        frame.setVisible(true);

        circle.removeCircleAfterTime();
    }

    class DestroyCircleController extends MouseAdapter {
        @Override
        public void mousePressed(MouseEvent e) {
            if (circle.shape.contains(e.getPoint())) {
                circle.removeCircle();
                scoreText.setText("Score: " + circle.getScore());
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