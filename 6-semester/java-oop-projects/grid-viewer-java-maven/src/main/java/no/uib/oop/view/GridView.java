package no.uib.oop.view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Rectangle2D;

import javax.swing.JPanel;

import no.uib.oop.grid.GridCell;
import no.uib.oop.grid.IGrid;

public class GridView extends JPanel {

    private final IGrid grid;
    private final ColorTheme theme;

    public static final int OUTERMARGIN = 20;
    public static final int INNERMARGIN = 4;

    public GridView(IGrid grid) {
        this.grid = grid;
        this.theme = new ColorTheme();
        this.setPreferredSize(new Dimension(400, 400));
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;
        drawGrid(g2);
    }

    private void drawGrid(Graphics2D g2) {
        int w = getWidth();
        int h = getHeight();

        Rectangle2D box = new Rectangle2D.Double(OUTERMARGIN, OUTERMARGIN, w - 2 * OUTERMARGIN,
                h - 2 * OUTERMARGIN);

        // background
        g2.setColor(Color.WHITE);
        g2.fillRect(0, 0, w, h);

        CellPositionToPixelConverter conv = new CellPositionToPixelConverter(box, grid, INNERMARGIN);
        drawCells(g2, conv);
    }

    private void drawCells(Graphics2D g2, CellPositionToPixelConverter conv) {
        for (GridCell cell : grid) {
            Rectangle2D r = conv.getBoundsForCell(cell.pos());
            Character symbol = cell.symbol();
            Color c = theme.getCellColor(symbol == null ? '-' : symbol);
            g2.setColor(c);
            g2.fill(r);
            g2.setColor(Color.DARK_GRAY);
            g2.draw(r);
        }
    }
}
