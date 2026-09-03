package no.uib.oop.gridview;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Rectangle2D;

import javax.swing.JPanel;

import no.uib.oop.datastructure.GridCellCollection;
import no.uib.oop.datastructure.IGrid;

public abstract class GridView<T> extends JPanel {

	protected IGrid<T> grid;
	protected static final double OUTERMARGIN = 20;
	protected static final Color MARGINCOLOR = Color.LIGHT_GRAY;
	protected final double innerMargin;

	public GridView(IGrid<T> grid, Dimension preferredSize, double innerMargin) {
		this.grid = grid;
		this.innerMargin = innerMargin;
		this.setPreferredSize(preferredSize);
	}

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D g2 = (Graphics2D) g;
		drawGrid(g2);
	}

	private void drawGrid(Graphics2D g2) {
		Rectangle2D box = new Rectangle2D.Double(OUTERMARGIN, OUTERMARGIN, this.getWidth() - OUTERMARGIN * 2,
				this.getHeight() - OUTERMARGIN * 2);

		g2.setColor(MARGINCOLOR);
		g2.fill(box);

		CellPositionToPixelConverter converter = new CellPositionToPixelConverter(box, grid, innerMargin);
		drawCells(g2, grid, converter);
	}

	protected abstract void drawCells(Graphics2D g2, GridCellCollection<T> cellCollection,
			CellPositionToPixelConverter converter);

}
