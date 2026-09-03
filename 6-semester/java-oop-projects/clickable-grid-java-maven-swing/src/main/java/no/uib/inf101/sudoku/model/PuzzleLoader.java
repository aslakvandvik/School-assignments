package no.uib.this OOP course.sudoku.model;

import java.util.Random;

/**
 * Loads predefined Sudoku puzzles.
 * This keeps puzzle data separate from the game model.
 */
public final class PuzzleLoader {

  /**
   * Difficulty levels for Sudoku puzzles.
   */
  public enum Difficulty {
    EASY("Lett"),
    MEDIUM("Middels"),
    HARD("Vanskelig");

    private final String displayName;

    Difficulty(String displayName) {
      this.displayName = displayName;
    }

    public String displayName() {
      return displayName;
    }
  }

  private static final Random RANDOM = new Random();

  private static final String[][] EASY_PUZZLES = {
    {
      "103000089",
      "000789100",
      "089100056",
      "214005897",
      "300897204",
      "807204065",
      "501040978",
      "040978030",
      "978001042"
    },
    {
      "120000089",
      "456000100",
      "789100006",
      "214365000",
      "000897214",
      "097214300",
      "531000970",
      "000978031",
      "978531000"
    },
    {
      "120450789",
      "450789123",
      "789120456",
      "200360897",
      "365800000",
      "890214300",
      "531040978",
      "642978000",
      "900531642"
    }
  };

  private static final String[][] MEDIUM_PUZZLES = {
    {
      "530070000",
      "600195000",
      "098000060",
      "800060003",
      "400803001",
      "700020006",
      "060000280",
      "000419005",
      "000080079"
    },
    {
      "003020600",
      "900305001",
      "001806400",
      "008102900",
      "700000008",
      "006708200",
      "002609500",
      "800203009",
      "005010300"
    },
    {
      "200080300",
      "060070084",
      "030500209",
      "000105408",
      "000000000",
      "402706000",
      "301007040",
      "720040060",
      "004010003"
    }
  };

  private static final String[][] HARD_PUZZLES = {
    {
      "000000907",
      "000420180",
      "000705026",
      "100904000",
      "050000040",
      "000507009",
      "920108000",
      "034059000",
      "507000000"
    },
    {
      "030000080",
      "009000500",
      "000904000",
      "800020003",
      "000000000",
      "700090004",
      "000405000",
      "001000700",
      "040000060"
    },
    {
      "000900000",
      "050123400",
      "000000000",
      "000000000",
      "000509000",
      "000000000",
      "000000000",
      "001804090",
      "000007000"
    }
  };

  private PuzzleLoader() {
    // Utility class
  }

  public static SudokuBoard loadEasyPuzzle() {
    return loadPuzzle(Difficulty.EASY);
  }

  /**
   * Loads one random puzzle for the requested difficulty.
   *
   * @param difficulty selected difficulty
   * @return a SudokuBoard for that difficulty
   */
  public static SudokuBoard loadPuzzle(Difficulty difficulty) {
    String[][] pool = switch (difficulty) {
      case EASY -> EASY_PUZZLES;
      case MEDIUM -> MEDIUM_PUZZLES;
      case HARD -> HARD_PUZZLES;
    };

    String[] puzzle = pool[RANDOM.nextInt(pool.length)];
    return new SudokuBoard(puzzle);
  }
}