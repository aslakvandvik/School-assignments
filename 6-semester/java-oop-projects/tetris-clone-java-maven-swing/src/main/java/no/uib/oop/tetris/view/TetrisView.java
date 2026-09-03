package no.uib.oop.tetris.view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Font;
import java.awt.geom.Rectangle2D;

import javax.swing.JPanel;

import no.uib.oop.grid.CellPosition;
import no.uib.oop.grid.GridCell;
import no.uib.oop.grid.GridDimension;
import no.uib.oop.tetris.model.GameState;

/**
 * View component that renders a Tetris board.
 */
public class TetrisView extends JPanel {

	public static final int OUTERMARGIN = 15;
	public static final int CELLMARGIN = 2;
	public static final int PREFERREDSIDESIZE = 30;
	public static final int SIDEBARWIDTH = 180;

	private ColorTheme colorTheme;
	private ViewableTetrisModel tetrisModel;

	public TetrisView(ViewableTetrisModel tetrisModel) {
		this.tetrisModel = tetrisModel;

		this.colorTheme = new DefaultColorTheme();
		this.setBackground(colorTheme.getBackgroundColor());

		this.setFocusable(true);
		this.setPreferredSize(getDefaultSize(tetrisModel.getDimension()));
	}

	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D g2 = (Graphics2D) g;
		drawGame(g2);
	}

	private void drawGame(Graphics2D g2) {
		Rectangle2D boardBox = new Rectangle2D.Double(
				OUTERMARGIN,
				OUTERMARGIN,
				this.getWidth() - SIDEBARWIDTH - OUTERMARGIN * 3,
				this.getHeight() - OUTERMARGIN * 2);
		Rectangle2D sidebarBox = new Rectangle2D.Double(
				boardBox.getMaxX() + OUTERMARGIN,
				OUTERMARGIN,
				SIDEBARWIDTH,
				this.getHeight() - OUTERMARGIN * 2);
		g2.setColor(this.colorTheme.getCellColor('-'));
		g2.fill(boardBox);
		g2.setColor(Color.DARK_GRAY);
		g2.fill(sidebarBox);
		g2.setColor(this.colorTheme.getFrameColor());
		g2.draw(boardBox);
		g2.draw(sidebarBox);

		CellPositionToPixelConverter converter = new CellPositionToPixelConverter(boardBox,
				this.tetrisModel.getDimension(), CELLMARGIN);
		drawCells(g2, this.tetrisModel.getTilesOnBoard(), converter,
				this.colorTheme);
		drawCells(g2, this.tetrisModel.getCurrentTetromino(), converter,
				this.colorTheme);
		this.drawSidebar(g2, sidebarBox);

		if (this.tetrisModel.getGameState() != GameState.ACTIVE_GAME) {
			this.drawOverlay(g2, boardBox);
		}

	}

	private void drawOverlay(Graphics2D g2, Rectangle2D box) {
		g2.setColor(this.colorTheme.getPopUpColor());
		g2.fill(box);
		g2.setColor(this.colorTheme.getCellColor('w'));
		GameState gameState = this.tetrisModel.getGameState();
		if (gameState == GameState.WELCOME_SCREEN) {
			this.drawCenteredLines(g2, box,
					new String[] {"Velkommen til Tetris", "Trykk ned for å begynne"},
					28, 18);
		} else if (gameState == GameState.PAUSED_GAME) {
			this.drawCenteredLines(g2, box,
					new String[] {"Pause", "Trykk P for å fortsette"},
					28, 18);
		} else if (gameState == GameState.GAME_OVER) {
			this.drawCenteredLines(g2, box,
					new String[] {
						"Game Over",
						"Poeng: " + this.tetrisModel.getScore(),
						"Trykk ned for velkomstskjerm"
					},
					28, 18);
		}
	}

	private void drawSidebar(Graphics2D g2, Rectangle2D sidebarBox) {
		g2.setColor(this.colorTheme.getCellColor('w'));
		g2.setFont(new Font("Arial", Font.BOLD, 18));
		int x = (int) sidebarBox.getX() + 15;
		int y = (int) sidebarBox.getY() + 30;
		g2.drawString("Poeng: " + this.tetrisModel.getScore(), x, y);
		y += 30;
		g2.drawString("Nivå: " + this.tetrisModel.getLevel(), x, y);
		y += 30;
		g2.drawString("Linjer: " + this.tetrisModel.getLinesCleared(), x, y);
		y += 50;
		g2.setFont(new Font("Arial", Font.PLAIN, 14));
		g2.drawString("Opp: roter", x, y);
		y += 22;
		g2.drawString("Venstre: flytt venstre", x, y);
		y += 22;
		g2.drawString("Høyre: flytt høyre", x, y);
		y += 22;
		g2.drawString("Ned: soft drop", x, y);
		y += 22;
		g2.drawString("Mellomrom: hard drop", x, y);
		y += 22;
		g2.drawString("P: pause", x, y);
		y+=22;
	}

	private void drawCenteredLines(Graphics2D g2, Rectangle2D box, String[] lines,
			int titleFontSize, int textFontSize) {
		int totalHeight = titleFontSize + (lines.length - 1) * (textFontSize + 12);
		double centerX = box.getCenterX();
		double startY = box.getCenterY() - totalHeight / 2.0;
		for (int i = 0; i < lines.length; i++) {
			int fontSize = i == 0 ? titleFontSize : textFontSize;
			g2.setFont(new Font("Arial", i == 0 ? Font.BOLD : Font.PLAIN, fontSize));
			OopGraphics.drawCenteredString(g2, lines[i], centerX,
					startY + i * (textFontSize + 12));
		}
	}

	private static void drawCells(Graphics2D g2, Iterable<GridCell> iterable,
				CellPositionToPixelConverter converter, ColorTheme colorTheme) {
		for (GridCell cell : iterable) {
			CellPosition pos = cell.pos();
			Character value = cell.value();
			Rectangle2D bounds = converter.getBoundsForCell(pos);

			// fill cell
			g2.setColor(colorTheme.getCellColor(value));
			g2.fill(bounds);

			// draw frame/outline
			g2.setColor(colorTheme.getFrameColor());
			g2.draw(bounds);
		}
	}

	private static Dimension getDefaultSize(GridDimension gd) {
		int width = (int) (PREFERREDSIDESIZE * gd.cols()
				+ CELLMARGIN * (gd.cols() + 1) + 3 * OUTERMARGIN + SIDEBARWIDTH);
		int height = (int) (PREFERREDSIDESIZE * gd.rows()
				+ CELLMARGIN * (gd.rows() + 1) + 2 * OUTERMARGIN);
		return new Dimension(width, height);
	}

}
