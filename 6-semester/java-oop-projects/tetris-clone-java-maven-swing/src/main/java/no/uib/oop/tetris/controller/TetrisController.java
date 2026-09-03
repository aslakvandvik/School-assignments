package no.uib.oop.tetris.controller;

import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.Timer;

import no.uib.oop.tetris.model.GameState;
import no.uib.oop.tetris.midi.TetrisSong;
import no.uib.oop.tetris.view.TetrisView;

/**
 * Controller that forwards key events to a controllable model and requests repaints.
 */
public class TetrisController implements KeyListener {

	private final ControllableTetrisModel model;
	private final TetrisView tetrisView;
	private final Timer timer;
	private final TetrisSong tetrisSong;

	/**
	 * Creates a controller for the given model and view.
	 *
	 * @param model the controllable game model
	 * @param tetrisView the view to repaint and attach key input to
	 */
	public TetrisController(ControllableTetrisModel model, TetrisView tetrisView) {
		this.model = model;
		this.tetrisView = tetrisView;
		this.timer = new Timer(this.model.getTimerDelay(), this::clockTick);
		this.tetrisSong = new TetrisSong();
		this.updateTimerDelay();
		this.tetrisView.addKeyListener(this);
		this.tetrisSong.run();
		this.syncStateEffects();
	}

	@Override
	public void keyTyped(KeyEvent e) {
	}

	@Override
	public void keyPressed(KeyEvent e) {
		boolean changed = false;
		int code = e.getKeyCode();
		GameState gameState = this.model.getGameState();

		if (gameState == GameState.WELCOME_SCREEN) {
			if (code == KeyEvent.VK_DOWN) {
				this.model.startGame();
				changed = true;
			}
		} else if (gameState == GameState.GAME_OVER) {
			if (code == KeyEvent.VK_DOWN) {
				this.model.returnToWelcomeScreen();
				changed = true;
			}
		} else if (code == KeyEvent.VK_P) {
			this.model.togglePause();
			changed = true;
		} else if (gameState == GameState.PAUSED_GAME) {
			changed = false;
		} else if (code == KeyEvent.VK_LEFT) {
			changed = this.model.moveTetromino(0, -1);
		} else if (code == KeyEvent.VK_RIGHT) {
			changed = this.model.moveTetromino(0, 1);
		} else if (code == KeyEvent.VK_DOWN) {
			changed = this.model.moveTetromino(1, 0);
			if (changed) {
				this.timer.restart();
			}
		} else if (code == KeyEvent.VK_UP) {
			changed = this.model.rotateTetromino();
		} else if (code == KeyEvent.VK_SPACE) {
			changed = this.model.dropTetromino();
			if (changed) {
				this.timer.restart();
			}
		}

		if (changed) {
			this.syncStateEffects();
			this.tetrisView.repaint();
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
	}

	private void clockTick(ActionEvent event) {
		if (this.model.getGameState() != GameState.ACTIVE_GAME) {
			return;
		}
		this.model.clockTick();
		this.syncStateEffects();
		this.tetrisView.repaint();
	}

	private void updateTimerDelay() {
		int delay = this.model.getTimerDelay();
		this.timer.setDelay(delay);
		this.timer.setInitialDelay(delay);
	}

	private void syncStateEffects() {
		this.updateTimerDelay();
		GameState gameState = this.model.getGameState();
		if (gameState == GameState.ACTIVE_GAME) {
			this.timer.start();
			this.tetrisSong.doUnpauseMidiSounds();
		} else {
			this.timer.stop();
			this.tetrisSong.doPauseMidiSounds();
		}
	}

}
