// 3-22/3-23 2018

public class ConnectFour {

  private char token1 = '@';
  private char token2 = 'O';
  private char token0 = '.';
  private boolean rotateTurns = true;
  private boolean running = true;
  private int activePlayer = 0;

  private char[][] board = new char[6][7];

  private char playerToken(int player) {
    switch (player) {
      case 0:
        return token1;
      case 1:
        return token2;
      default:
        break;
    }
    return token0;
  }

  private void rotatePlayer() {
    switch (activePlayer) {
      case 0:
        activePlayer = 1;
        break;
      case 1:
        activePlayer = 0;
        break;
      default:
        activePlayer = 0;
    }
  }

  private void checkIfFull() {
    boolean full = true;
    for (int row = board.length - 1; row >= 0; row--) {
      for (int col = board[row].length - 1; col >= 0; col--) {
        if (board[row][col] == token0) {
          full = false;
          break;
        }
      }
    }
    if (full) {
      System.out.println("DRAW");
      System.out.println("Game Over.");
      running = false;
    }
  }

  private void checkForWin(int posX, int posY) {
    char token = board[posX][posY];
    int lineSum = 1;
    // check horz
    if (checkHere(token, posX, posY + 1)) {
      lineSum++;
      if (checkHere(token, posX, posY + 2)) {
        lineSum++;
        if (checkHere(token, posX, posY + 3)) {
          lineSum++;
        }
      }
    }
    if (checkHere(token, posX, posY - 1) && lineSum < 4) {
      lineSum++;
      if (checkHere(token, posX, posY - 2) && lineSum < 4) {
        lineSum++;
        if (checkHere(token, posX, posY - 3) && lineSum < 4) {
          lineSum++;
        }
      }
    }
    if (lineSum >= 4) {
      win();
      posX = -5;
      posY = -5;
    } else {

      lineSum = 1;
      // check vert
      if (checkHere(token, posX + 1, posY)) {
        lineSum++;
        if (checkHere(token, posX + 2, posY)) {
          lineSum++;
          if (checkHere(token, posX + 3, posY)) {
            lineSum++;
          }
        }
      }
      if (checkHere(token, posX - 1, posY) && lineSum < 4) {
        lineSum++;
        if (checkHere(token, posX - 2, posY) && lineSum < 4) {
          lineSum++;
          if (checkHere(token, posX - 3, posY) && lineSum < 4) {
            lineSum++;
          }
        }
      }
      if (lineSum >= 4) {
        win();
        posX = -5;
        posY = -5;
      } else {

        lineSum = 1;
        // check diag /
        if (checkHere(token, posX + 1, posY - 1)) {
          lineSum++;
          if (checkHere(token, posX + 2, posY - 2)) {
            lineSum++;
            if (checkHere(token, posX + 3, posY - 3)) {
              lineSum++;
            }
          }
        }
        if (checkHere(token, posX - 1, posY + 1) && lineSum < 4) {
          lineSum++;
          if (checkHere(token, posX - 2, posY + 2) && lineSum < 4) {
            lineSum++;
            if (checkHere(token, posX - 3, posY + 3) && lineSum < 4) {
              lineSum++;
            }
          }
        }
        if (lineSum >= 4) {
          win();
          posX = -5;
          posY = -5;
        } else {

          lineSum = 1;
          // check diag \
          if (checkHere(token, posX + 1, posY + 1)) {
            lineSum++;
            if (checkHere(token, posX + 2, posY + 2)) {
              lineSum++;
              if (checkHere(token, posX + 3, posY + 3)) {
                lineSum++;
              }
            }
          }
          if (checkHere(token, posX - 1, posY - 1) && lineSum < 4) {
            lineSum++;
            if (checkHere(token, posX - 2, posY - 2) && lineSum < 4) {
              lineSum++;
              if (checkHere(token, posX - 3, posY - 3) && lineSum < 4) {
                lineSum++;
              }
            }
          }
          if (lineSum >= 4) {
            win();
          } else {
            posX = -5;
            posY = -6;
          }
        }
      }
    }

  }

  private boolean checkHere(char token, int posX, int posY) {
    try {
      return (token == board[posX][posY]);
    } catch (Exception e) {
      return false;
    }
  }

  private void win() {
    System.out.println(getActivePlayer() + " wins!");
    running = false;
  }

  /**
   * Fills the board with empty slots.
   */
  public ConnectFour() {
    for (int row = board.length - 1; row >= 0; row--) {
      for (int col = board[row].length - 1; col >= 0; col--) {
        board[row][col] = token0;
      }
    }
  }

  public boolean isItRunning() {
    return running;
  }

  /**
   * Prints out the current game board to the console.
   */
  public void displayBoard() {
    for (int num = 1; num <= board[0].length; num++) {
      System.out.print(num);
      if (num < board[0].length) {
        System.out.print(" ");
      }
    }
    System.out.println();
    for (int row = board.length - 1; row >= 0; row--) {
      for (int col = 0; col < board[row].length; col++) {
        System.out.print(board[row][col]);
        if (col < board[row].length - 1) {
          System.out.print(" ");
        }
      }
      System.out.println();
    }
  }

  /**
   * Returns the name of the current player.
   * 
   * @return Can return "Player 1" or "Player 2".
   */

  public String getActivePlayer() {
    switch (activePlayer) {
      case 0:
        return "Player 1";
      case 1:
        return "Player 2";
      default:
        break;
    }
    return "";
  }

  /**
   * Tries to place a token of the corresponding player.
   * 
   * @param col
   *          A column on the board. At the standard size, Only 1-7 can result
   *          in a placement.
   */
  public void placeToken(int col) {
    boolean moved = false;
    int lastMoveX = -1;
    int lastMoveY = -1;
    for (int row = 0; row < board.length; row++) {
      if (board[row][col - 1] == token0) {
        board[row][col - 1] = playerToken(activePlayer);
        moved = true;
        lastMoveX = row;
        lastMoveY = col - 1;
        row = board.length;
        displayBoard();
      }
    }
    if (!moved) {
      System.out.println("Invalid input.");
    } else {
      checkForWin(lastMoveX, lastMoveY);
      if (running) {
        checkIfFull();
      }
      if (rotateTurns && running) {
        rotatePlayer();
      }
    }
  }

  public void shutDown() {
    running = false;
  }
}
