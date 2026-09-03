package no.uib.this OOP course.sudoku.view;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.geom.Rectangle2D;
import java.util.Objects;

import javax.swing.JPanel;

import no.uib.this OOP course.sudoku.grid.CellPosition;
import no.uib.this OOP course.sudoku.grid.CellPositionToPixelConverter;
import no.uib.this OOP course.sudoku.grid.GridDimension;
import no.uib.this OOP course.sudoku.model.Model;
import no.uib.this OOP course.sudoku.model.PuzzleLoader;

/**
 * Swing view that renders the Sudoku board and status text.
 * This class extends {@link JPanel}, which gives the
 * view standard Swing painting behavior and event support.
 */
public class View extends JPanel {

  private static final int OUTER_MARGIN = 20;
  private static final int INNER_MARGIN = 2;
  private static final int STATUS_AREA_HEIGHT = 40;
  private static final int BUTTON_WIDTH = 240;
  private static final int BUTTON_HEIGHT = 52;
  private static final int BUTTON_GAP = 14;
  private static final int OVERLAY_PADDING = 26;
  private static final int PAUSE_BUTTON_WIDTH = 120;
  private static final int PAUSE_BUTTON_HEIGHT = 34;
  private static final Color BACKGROUND = new Color(245, 245, 245);
  private static final Color OVERLAY = new Color(0, 0, 0, 130);
  private static final Color PANEL = new Color(250, 250, 250);
  private static final Color PANEL_BORDER = new Color(210, 210, 210);
  private static final Color BUTTON_FILL = new Color(45, 45, 45);
  private static final Color BUTTON_FILL_PRESSED = new Color(25, 25, 25);
  private static final Color BUTTON_TEXT = Color.WHITE;
  private static final Color SELECTED_COLOR = new Color(183, 225, 255);
  private static final Color FIXED_COLOR = new Color(230, 230, 230);
  private static final Color EDITABLE_COLOR = Color.WHITE;
  private static final Color CELL_BORDER = new Color(170, 170, 170);
  private static final Color TEXT_COLOR = new Color(33, 33, 33);
  private static final Color STATUS_COLOR = new Color(60, 60, 60);

  private final Model model;
  private PuzzleLoader.Difficulty pressedDifficulty = null;

  public View(Model model) {
    this.model = model;
    this.setPreferredSize(new Dimension(620, 700));
  }

  @Override
  protected void paintComponent(Graphics g) {
    super.paintComponent(g);
    Graphics2D g2 = (Graphics2D) g;
    g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
    g2.setColor(BACKGROUND);
    g2.fillRect(0, 0, getWidth(), getHeight());

    if (model.isStartScreen()) {
      drawStartScreen(g2);
      return;
    }

    drawBoard(g2);

    if (model.isPlaying()) {
      drawPauseButton(g2);
    }

    if (model.isCompleted()) {
      drawCompletionOverlay(g2);
    } else if (model.isPaused()) {
      drawPauseOverlay(g2);
    } else if (model.isShowingControls()) {
      drawControlsOverlay(g2);
    }
  }

  private void drawBoard(Graphics2D g2) {
    CellPositionToPixelConverter converter = this.getCellPositionToPixelConverter();

    for (int row = 0; row < this.model.getDimension().rows(); row++) {
      for (int col = 0; col < this.model.getDimension().cols(); col++) {
        CellPosition pos = new CellPosition(row, col);
        Rectangle2D box = converter.getBoundsForCell(pos);

        Color fillColor = model.isFixed(pos) ? FIXED_COLOR : EDITABLE_COLOR;
        if (Objects.equals(pos, this.model.getSelected())) {
          fillColor = SELECTED_COLOR;
        }

        g2.setColor(fillColor);
        g2.fill(box);

        g2.setColor(CELL_BORDER);
        g2.draw(box);

        drawCellValue(g2, box, model.getValue(pos), model.isFixed(pos));
      }
    }

    drawSubgridLines(g2, converter);
    drawStatusText(g2);
  }

  private void drawCellValue(Graphics2D g2, Rectangle2D box, int value, boolean isFixed) {
    if (value == 0) {
      return;
    }

    Font font = isFixed ? new Font("SansSerif", Font.BOLD, 30) : new Font("SansSerif", Font.PLAIN, 30);
    g2.setFont(font);
    g2.setColor(TEXT_COLOR);

    String text = Integer.toString(value);
    double textWidth = g2.getFontMetrics().stringWidth(text);
    double textHeight = g2.getFontMetrics().getAscent();

    double x = box.getCenterX() - textWidth / 2;
    double y = box.getCenterY() + textHeight / 3;
    g2.drawString(text, (int) x, (int) y);
  }

  private void drawSubgridLines(Graphics2D g2, CellPositionToPixelConverter converter) {
    g2.setColor(Color.BLACK);
    g2.setStroke(new BasicStroke(3f));

    Rectangle2D first = converter.getBoundsForCell(new CellPosition(0, 0));
    Rectangle2D last = converter.getBoundsForCell(new CellPosition(8, 8));

    double left = first.getX();
    double top = first.getY();
    double right = last.getX() + last.getWidth();
    double bottom = last.getY() + last.getHeight();

    for (int i = 0; i <= 9; i += 3) {
      Rectangle2D refCol = converter.getBoundsForCell(new CellPosition(0, Math.min(i, 8)));
      double x = (i == 9) ? right : refCol.getX();
      g2.draw(new java.awt.geom.Line2D.Double(x, top, x, bottom));

      Rectangle2D refRow = converter.getBoundsForCell(new CellPosition(Math.min(i, 8), 0));
      double y = (i == 9) ? bottom : refRow.getY();
      g2.draw(new java.awt.geom.Line2D.Double(left, y, right, y));
    }
  }

  private void drawStatusText(Graphics2D g2) {
    g2.setColor(STATUS_COLOR);
    g2.setFont(new Font("SansSerif", Font.PLAIN, 18));
    g2.drawString(model.getStatusMessage(), OUTER_MARGIN, getHeight() - 12);
  }

  private void drawStartScreen(Graphics2D g2) {
    Rectangle2D panel = getStartPanelBounds();
    g2.setColor(OVERLAY);
    g2.fillRect(0, 0, getWidth(), getHeight());

    g2.setColor(PANEL);
    g2.fillRoundRect((int) panel.getX(), (int) panel.getY(), (int) panel.getWidth(), (int) panel.getHeight(), 26, 26);
    g2.setColor(PANEL_BORDER);
    g2.drawRoundRect((int) panel.getX(), (int) panel.getY(), (int) panel.getWidth(), (int) panel.getHeight(), 26, 26);

    g2.setColor(TEXT_COLOR);
    g2.setFont(new Font("SansSerif", Font.BOLD, 28));
    drawCenteredText(g2, "Sudoku", panel.getCenterX(), panel.getY() + 48);

    g2.setFont(new Font("SansSerif", Font.PLAIN, 18));
    drawCenteredText(g2, "Velg vanskelighetsgrad", panel.getCenterX(), panel.getY() + 72);

    for (PuzzleLoader.Difficulty difficulty : PuzzleLoader.Difficulty.values()) {
      drawButton(g2, getDifficultyButtonBounds(difficulty), difficulty.displayName(), difficulty == pressedDifficulty);
    }
  }

  private void drawCompletionOverlay(Graphics2D g2) {
    g2.setColor(OVERLAY);
    g2.fillRect(0, 0, getWidth(), getHeight());

    Rectangle2D panel = getCompletionPanelBounds();
    g2.setColor(PANEL);
    g2.fillRoundRect((int) panel.getX(), (int) panel.getY(), (int) panel.getWidth(), (int) panel.getHeight(), 26, 26);
    g2.setColor(PANEL_BORDER);
    g2.drawRoundRect((int) panel.getX(), (int) panel.getY(), (int) panel.getWidth(), (int) panel.getHeight(), 26, 26);

    g2.setColor(TEXT_COLOR);
    g2.setFont(new Font("SansSerif", Font.BOLD, 26));
    drawCenteredText(g2, "Gratulerer!", panel.getCenterX(), panel.getY() + 52);

    g2.setFont(new Font("SansSerif", Font.PLAIN, 18));
    drawCenteredText(g2, "Du løste Sudoku", panel.getCenterX(), panel.getY() + 86);
    drawCenteredText(g2, "Trykk N eller klikk nedenfor for nytt spill", panel.getCenterX(), panel.getY() + 116);

    drawButton(g2, getRestartButtonBounds(), "Nytt spill", false);
  }

  private void drawPauseButton(Graphics2D g2) {
    Rectangle2D bounds = getPauseButtonBounds();
    drawButton(g2, bounds, "Pause", false);
  }

  private void drawPauseOverlay(Graphics2D g2) {
    g2.setColor(OVERLAY);
    g2.fillRect(0, 0, getWidth(), getHeight());

    Rectangle2D panel = getPausePanelBounds();
    g2.setColor(PANEL);
    g2.fillRoundRect((int) panel.getX(), (int) panel.getY(), (int) panel.getWidth(), (int) panel.getHeight(), 26, 26);
    g2.setColor(PANEL_BORDER);
    g2.drawRoundRect((int) panel.getX(), (int) panel.getY(), (int) panel.getWidth(), (int) panel.getHeight(), 26, 26);

    g2.setColor(TEXT_COLOR);
    g2.setFont(new Font("SansSerif", Font.BOLD, 26));
    drawCenteredText(g2, "Spillet er pauset", panel.getCenterX(), panel.getY() + 52);

    g2.setFont(new Font("SansSerif", Font.PLAIN, 18));
    drawCenteredText(g2, "Velg hva du vil gjøre videre", panel.getCenterX(), panel.getY() + 86);

    drawButton(g2, getResumeButtonBounds(), "Fortsett", false);
    drawButton(g2, getPauseDifficultyButtonBounds(), "Endre vanskelighetsgrad", false);
    drawButton(g2, getControlsButtonBounds(), "Vis kontroller", false);
  }

  private void drawControlsOverlay(Graphics2D g2) {
    g2.setColor(OVERLAY);
    g2.fillRect(0, 0, getWidth(), getHeight());

    Rectangle2D panel = getControlsPanelBounds();
    g2.setColor(PANEL);
    g2.fillRoundRect((int) panel.getX(), (int) panel.getY(), (int) panel.getWidth(), (int) panel.getHeight(), 26, 26);
    g2.setColor(PANEL_BORDER);
    g2.drawRoundRect((int) panel.getX(), (int) panel.getY(), (int) panel.getWidth(), (int) panel.getHeight(), 26, 26);

    g2.setColor(TEXT_COLOR);
    g2.setFont(new Font("SansSerif", Font.BOLD, 26));
    drawCenteredText(g2, "Kontroller", panel.getCenterX(), panel.getY() + 48);

    g2.setFont(new Font("SansSerif", Font.PLAIN, 18));
    drawCenteredText(g2, "Klikk på en rute for å velge den", panel.getCenterX(), panel.getY() + 90);
    drawCenteredText(g2, "1-9: skriv tall i valgt rute", panel.getCenterX(), panel.getY() + 120);
    drawCenteredText(g2, "Backspace / Delete / 0: tøm valgt rute", panel.getCenterX(), panel.getY() + 150);
    drawCenteredText(g2, "N: start nytt spill", panel.getCenterX(), panel.getY() + 180);

    drawButton(g2, getBackToPauseButtonBounds(), "Tilbake", false);
  }

  private void drawButton(Graphics2D g2, Rectangle2D bounds, String text, boolean pressed) {
    Color fillColor = pressed ? BUTTON_FILL_PRESSED : BUTTON_FILL;
    int yOffset = pressed ? 3 : 0;

    g2.setColor(fillColor);
    g2.fillRoundRect((int) bounds.getX(), (int) bounds.getY() + yOffset, (int) bounds.getWidth(), (int) bounds.getHeight(), 22, 22);
    g2.setColor(BUTTON_TEXT);
    g2.setFont(new Font("SansSerif", Font.BOLD, 18));
    drawCenteredText(g2, text, bounds.getCenterX(), bounds.getCenterY() + 6 + yOffset);
  }

  private void drawCenteredText(Graphics2D g2, String text, double centerX, double baselineY) {
    double textWidth = g2.getFontMetrics().stringWidth(text);
    g2.drawString(text, (int) (centerX - textWidth / 2), (int) baselineY);
  }

  public Rectangle2D getDifficultyButtonBounds(PuzzleLoader.Difficulty difficulty) {
    Rectangle2D panel = getStartPanelBounds();
    int index = difficulty.ordinal();
    double totalHeight = PuzzleLoader.Difficulty.values().length * BUTTON_HEIGHT
        + (PuzzleLoader.Difficulty.values().length - 1) * BUTTON_GAP;
    double startY = panel.getCenterY() - totalHeight / 2 + 44;
    double x = panel.getCenterX() - BUTTON_WIDTH / 2;
    double y = startY + index * (BUTTON_HEIGHT + BUTTON_GAP);
    return new Rectangle2D.Double(x, y, BUTTON_WIDTH, BUTTON_HEIGHT);
  }

  public Rectangle2D getRestartButtonBounds() {
    Rectangle2D panel = getCompletionPanelBounds();
    double x = panel.getCenterX() - BUTTON_WIDTH / 2;
    double y = panel.getMaxY() - BUTTON_HEIGHT - OVERLAY_PADDING;
    return new Rectangle2D.Double(x, y, BUTTON_WIDTH, BUTTON_HEIGHT);
  }

  public Rectangle2D getPauseButtonBounds() {
    double x = getWidth() - OUTER_MARGIN - PAUSE_BUTTON_WIDTH;
    double y = getHeight() - OUTER_MARGIN - PAUSE_BUTTON_HEIGHT;
    return new Rectangle2D.Double(x, y, PAUSE_BUTTON_WIDTH, PAUSE_BUTTON_HEIGHT);
  }

  public Rectangle2D getResumeButtonBounds() {
    Rectangle2D panel = getPausePanelBounds();
    double x = panel.getCenterX() - BUTTON_WIDTH / 2;
    double y = panel.getY() + 126;
    return new Rectangle2D.Double(x, y, BUTTON_WIDTH, BUTTON_HEIGHT);
  }

  public Rectangle2D getPauseDifficultyButtonBounds() {
    Rectangle2D panel = getPausePanelBounds();
    double x = panel.getCenterX() - BUTTON_WIDTH / 2;
    double y = panel.getY() + 126 + BUTTON_HEIGHT + 14;
    return new Rectangle2D.Double(x, y, BUTTON_WIDTH, BUTTON_HEIGHT);
  }

  public Rectangle2D getControlsButtonBounds() {
    Rectangle2D panel = getPausePanelBounds();
    double x = panel.getCenterX() - BUTTON_WIDTH / 2;
    double y = panel.getY() + 126 + 2 * (BUTTON_HEIGHT + 14);
    return new Rectangle2D.Double(x, y, BUTTON_WIDTH, BUTTON_HEIGHT);
  }

  public Rectangle2D getBackToPauseButtonBounds() {
    Rectangle2D panel = getControlsPanelBounds();
    double x = panel.getCenterX() - BUTTON_WIDTH / 2;
    double y = panel.getMaxY() - BUTTON_HEIGHT - OVERLAY_PADDING;
    return new Rectangle2D.Double(x, y, BUTTON_WIDTH, BUTTON_HEIGHT);
  }

  public void setPressedDifficulty(PuzzleLoader.Difficulty pressedDifficulty) {
    this.pressedDifficulty = pressedDifficulty;
    repaint();
  }

  public void clearPressedDifficulty() {
    this.pressedDifficulty = null;
    repaint();
  }

  private Rectangle2D getStartPanelBounds() {
    double width = 420;
    double height = 300;
    double x = (getWidth() - width) / 2.0;
    double y = (getHeight() - height) / 2.0;
    return new Rectangle2D.Double(x, y, width, height);
  }

  private Rectangle2D getCompletionPanelBounds() {
    double width = 420;
    double height = 240;
    double x = (getWidth() - width) / 2.0;
    double y = (getHeight() - height) / 2.0;
    return new Rectangle2D.Double(x, y, width, height);
  }

  private Rectangle2D getPausePanelBounds() {
    double width = 440;
    double height = 360;
    double x = (getWidth() - width) / 2.0;
    double y = (getHeight() - height) / 2.0;
    return new Rectangle2D.Double(x, y, width, height);
  }

  private Rectangle2D getControlsPanelBounds() {
    double width = 500;
    double height = 330;
    double x = (getWidth() - width) / 2.0;
    double y = (getHeight() - height) / 2.0;
    return new Rectangle2D.Double(x, y, width, height);
  }

  public CellPositionToPixelConverter getCellPositionToPixelConverter() {
    Rectangle2D bounds = new Rectangle2D.Double(
        OUTER_MARGIN,
        OUTER_MARGIN,
        this.getWidth() - 2 * OUTER_MARGIN,
        this.getHeight() - 2 * OUTER_MARGIN - STATUS_AREA_HEIGHT);
    GridDimension gridSize = this.model.getDimension();
    return new CellPositionToPixelConverter(bounds, gridSize, INNER_MARGIN);
  }
}