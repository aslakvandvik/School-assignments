package no.uib.this OOP course.gridview;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.geom.Rectangle2D;

import no.uib.this OOP course.datastructure.IGrid;
import no.uib.this OOP course.datastructure.GridCell;
import no.uib.this OOP course.datastructure.GridCellCollection;

public class ColorGridView extends GridView<Color> {

	public ColorGridView(IGrid<Color> colorGrid) {
		super(colorGrid, new Dimension(400, 300), 30);
	}

	@Override
	protected void drawCells(Graphics2D g2, GridCellCollection<Color> cellCollection,
			CellPositionToPixelConverter converter) {
		for (GridCell<Color> cell : cellCollection.getCells()) {
			Rectangle2D box = converter.getBoundsForCell(cell.pos());
			Color color = cell.elem();
			if (color == null)
				color = Color.DARK_GRAY;
			g2.setColor(color);
			g2.fill(box);
		}
	}

}
