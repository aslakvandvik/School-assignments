[Tilbake til oppgave 5](./05-grid.md)

## Tester til oppgave 5

Her er tester til Grid klassen når den er ferdig omgjort.

```Java
  @Test
  public void sanityTest() {
    Grid<Color> grid = new Grid<Color>(3, 4);

    // Check that number of rows and cols match up
    assertEquals(3, grid.rows());
    assertEquals(4, grid.cols());

    // Check that default value is null
    assertEquals(null, grid.get(new CellPosition(1, 2)));

    // Check that we can set a value and retrieve it again
    grid.set(new CellPosition(1, 2), Color.RED);
    assertEquals(Color.RED, grid.get(new CellPosition(1, 2)));
    assertEquals(null, grid.get(new CellPosition(2, 1)));

    // Check that we can set a new value and retrieve it again
    grid.set(new CellPosition(1, 2), Color.GREEN);
    assertEquals(Color.GREEN, grid.get(new CellPosition(1, 2)));
  }

  @Test
  public void testDimension() {
    GridDimension gd = new Grid<Color>(10, 20);
    assertEquals(10, gd.rows());
    assertEquals(20, gd.cols());

    gd = new Grid<Color>(1, 1);
    assertEquals(1, gd.rows());
    assertEquals(1, gd.cols());
  }

  @Test
  public void testGetDefaultValue() {
    IGrid<Color> grid = new Grid<Color>(10, 20);
    assertNull(grid.get(new CellPosition(0, 0)));
    assertNull(grid.get(new CellPosition(2, 3)));
  }

  @Test
  public void testSetGetInCorners() {
    IGrid<Color> grid = new Grid<Color>(10, 20);
    // Set color in corners
    grid.set(new CellPosition(0, 0), Color.RED);
    grid.set(new CellPosition(0, 19), Color.GREEN);
    grid.set(new CellPosition(9, 0), Color.BLUE);
    grid.set(new CellPosition(9, 19), Color.YELLOW);

    // Get color in corners
    assertEquals(Color.RED, grid.get(new CellPosition(0, 0)));
    assertEquals(Color.GREEN, grid.get(new CellPosition(0, 19)));
    assertEquals(Color.BLUE, grid.get(new CellPosition(9, 0)));
    assertEquals(Color.YELLOW, grid.get(new CellPosition(9, 19)));
  }

  @Test
  public void testGetCells() {
    IGrid<Color> grid = new Grid<Color>(2, 2);

    grid.set(new CellPosition(0, 0), Color.RED);
    grid.set(new CellPosition(0, 1), Color.GREEN);
    grid.set(new CellPosition(1, 0), Color.BLUE);
    grid.set(new CellPosition(1, 1), Color.BLACK);

    List<GridCell<Color>> expected = Arrays.asList(
        new GridCell<Color>(new CellPosition(0, 0), Color.RED),
        new GridCell<Color>(new CellPosition(0, 1), Color.GREEN),
        new GridCell<Color>(new CellPosition(1, 0), Color.BLUE),
        new GridCell<Color>(new CellPosition(1, 1), Color.BLACK)
    );
    List<GridCell<Color>> actual = grid.getCells();

    assertEquals(expected.size(), actual.size());
    for (GridCell<Color> cp : actual) {
      assertTrue(expected.contains(cp));
    }
    for (GridCell<Color> cp : expected) {
      assertTrue(actual.contains(cp));
    }
  }

  @Test
  public void testGetCellsWithNull() {
    IGrid<Color> grid = new Grid<Color>(3, 1);

    grid.set(new CellPosition(2, 0), Color.GREEN);

    List<GridCell<Color>> expected = Arrays.asList(
        new GridCell<Color>(new CellPosition(0, 0), null),
        new GridCell<Color>(new CellPosition(1, 0), null),
        new GridCell<Color>(new CellPosition(2, 0), Color.GREEN)
    );
    List<GridCell<Color>> actual = grid.getCells();

    assertEquals(expected.size(), actual.size());
    for (GridCell<Color> cp : actual) {
      assertTrue(expected.contains(cp));
    }
    for (GridCell<Color> cp : expected) {
      assertTrue(actual.contains(cp));
    }
  }

  @Test
  public void testIndexOutOfBoundsException() {
    IGrid<Color> grid = new Grid<Color>(10, 20);

    // Test out of bounds for get
    assertThrows(IndexOutOfBoundsException.class, () -> grid.get(new CellPosition(-1, 0)));
    assertThrows(IndexOutOfBoundsException.class, () -> grid.get(new CellPosition(0, -1)));
    assertThrows(IndexOutOfBoundsException.class, () -> grid.get(new CellPosition(10, 0)));
    assertThrows(IndexOutOfBoundsException.class, () -> grid.get(new CellPosition(0, 20)));

    // Test out of bounds for set
    assertThrows(IndexOutOfBoundsException.class, () -> grid.set(new CellPosition(-1, 0), Color.RED));
    assertThrows(IndexOutOfBoundsException.class, () -> grid.set(new CellPosition(0, -1), Color.RED));
    assertThrows(IndexOutOfBoundsException.class, () -> grid.set(new CellPosition(10, 0), Color.RED));
    assertThrows(IndexOutOfBoundsException.class, () -> grid.set(new CellPosition(0, 20), Color.RED));
  }
```