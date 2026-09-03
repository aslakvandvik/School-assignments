package no.uib.this OOP course.gridview;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.geom.Rectangle2D;

import no.uib.this OOP course.datastructure.GridCell;
import no.uib.this OOP course.datastructure.GridCellCollection;
import no.uib.this OOP course.datastructure.IGrid;

public class TextGridView extends GridView<String> {

	public TextGridView(IGrid<String> textGrid) {
		super(textGrid, new Dimension(1000, 300), 5);
	}

	@Override
	protected void drawCells(Graphics2D g2, GridCellCollection<String> cellCollection,
			CellPositionToPixelConverter converter) {

		for (GridCell<String> cell : cellCollection.getCells()) {
			// Draw box for text
			Rectangle2D box = converter.getBoundsForCell(cell.pos());
			g2.setColor(Color.BLUE);
			g2.fill(box);

			// check text content
			String text = cell.elem();
			if (text == null)
				continue;

			// draw text
			g2.setColor(Color.WHITE);
			this OOP courseGraphics.drawScaledCenteredString(g2, text, box);
		}
	}
}
