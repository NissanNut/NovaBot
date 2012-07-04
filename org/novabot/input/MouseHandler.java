package org.novabot.input;

import java.applet.Applet;
import java.awt.Component;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import org.novabot.Client;
import org.novabot.storage.FieldStorage;

public class MouseHandler implements MouseListener, MouseMotionListener,
		Runnable {

	private final Client client;
	private Component aComp;
	private Applet applet;
	public int botX, botY;
	private Thread mouseThread;
	private Focus focus;

	public MouseHandler(final Client client) {
		this.client = client;
		if (this.client.getApplet() != null) {
			applet = this.client.getApplet();
			aComp = applet.getComponent(0);
			if (aComp != null) {
				for (final MouseListener ml : aComp.getMouseListeners()) {
					aComp.removeMouseListener(ml);
				}
				for (final MouseMotionListener mml : aComp
						.getMouseMotionListeners()) {
					aComp.removeMouseMotionListener(mml);
				}
				for (final FocusListener fl : aComp.getFocusListeners()) {
					aComp.removeFocusListener(fl);
				}
				aComp.addMouseListener(this);
				aComp.addMouseMotionListener(this);
				focus = new Focus();
				aComp.addFocusListener(focus);
				mouseThread = new Thread(this);
				mouseThread.start();
			}
		}
	}

	public void clickAt(final int x, final int y, final boolean left) {
		System.out.print("WORDKRSFSDFSFSDFSFSDF");
		final MouseEvent event = new MouseEvent(aComp,
				MouseEvent.MOUSE_CLICKED, System.currentTimeMillis(), 0, x, y,
				1, left);
		for (final MouseListener ml : aComp.getMouseListeners()) {
			if (ml.equals(this))
				ml.mouseClicked(event);
		}
	}

	public void moveTo(final int x, final int y) {
		System.out.print("WORDKRSFSDFSFSDFSFSDF4235345345345345");
		final MouseEvent event = new MouseEvent(aComp, MouseEvent.MOUSE_MOVED,
				System.currentTimeMillis(), 0, x, y, 1, false);
		for (final MouseMotionListener mml : aComp.getMouseMotionListeners()) {
			if (mml.equals(this))
				mml.mouseMoved(event);
		}
	}

	public void run() {
		while (true) {
			try {
				fixInput();
				Thread.sleep(10);
			} catch (final Exception e) {
				System.out.print(e.getMessage());
			}
		}
	}

	private void fixInput() {
		if (aComp == null) {
			System.out
					.print("NOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOL");
		}
		if (!aComp.getMouseListeners()[0].equals(this)) {
			System.out.print("MouseListener Corrected!");
			for (final MouseListener ml : aComp.getMouseListeners()) {
				aComp.removeMouseListener(ml);
			}
			aComp.addMouseListener(this);
		}
		if (!aComp.getMouseMotionListeners()[0].equals(this)) {
			System.out.print("MouseMotionListener Corrected!");
			for (final MouseMotionListener mml : aComp
					.getMouseMotionListeners()) {
				aComp.removeMouseMotionListener(mml);
			}
			aComp.addMouseMotionListener(this);
		}
		if (!aComp.getFocusListeners()[0].equals(focus)) {
			for (final FocusListener fl : aComp.getFocusListeners()) {
				aComp.removeFocusListener(fl);
			}
			focus = new Focus();
			aComp.addFocusListener(focus);
		}
	}

	@Override
	public void mouseDragged(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseMoved(MouseEvent arg0) {
		botX = arg0.getX();
		botY = arg0.getY();
		//moveTo(botX, botY);
		FieldStorage.addField("botX", botX);
		FieldStorage.addField("botY", botY);
	}

	@Override
	public void mouseClicked(MouseEvent arg0) {
		// click(arg0.getX(), arg0.getY());
		final int x = arg0.getX();
		final int y = arg0.getY();
		System.out.print("MOUSE CLICKED AT X: " + x + ", Y: " + y);
	}

	@Override
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mousePressed(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

	private class Focus implements FocusListener {

		@Override
		public void focusGained(FocusEvent e) {
			System.out.print("Focus Gained!");
		}

		@Override
		public void focusLost(FocusEvent e) {
			System.out.print("Focus Lost!");
		}

	}

}
