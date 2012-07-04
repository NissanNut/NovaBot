package org.novabot.api.script;

import java.awt.Graphics;

import org.novabot.Client;
import org.novabot.NovaBot;
import org.novabot.api.methods.Mouse;
import org.novabot.internal.script.ScriptManifest;

public abstract class Script {
	private static boolean isPaused = false;
	private final ScriptManifest manifest;
	private Mouse mouse;
	private boolean running;

	public Script() {
		manifest = getClass().getAnnotation(ScriptManifest.class);
	}

	public boolean onStart() {
		return true;
	}

	public void onStop() {
	}

	public abstract boolean loop();

	public void paint(Graphics g) {
	}

	public final void setRunning(final boolean running) {
		this.running = running;
	}

	public final boolean isRunning() {
		return running;
	}

	public void log(final String str) {
		NovaBot.log(manifest.name(), str);
	}

	protected static final boolean isPaused() {
		return isPaused;
	}

	protected static void setPaused(final boolean bool) {
		isPaused = bool;
	}

	public void setMouse(final Client client) {
		this.mouse = new Mouse(client);
	}

	public Mouse getMouse() {
		return mouse;
	}

	public final void stop() {
	}

	protected ScriptManifest getAnnotaion() {
		return manifest;
	}
}
