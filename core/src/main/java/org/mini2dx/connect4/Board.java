/*
/*******************************************************************************
 * Copyright 2019 Viridian Software Limited
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 ******************************************************************************/
package org.mini2dx.connect4;
import org.mini2Dx.core.Graphics;

// import static org.mini2dx.connect4.Box.BoxColour.BOX;
import static org.mini2dx.connect4.Tile.TileColour.*;
import java.util.Random;

public class Board {    // class field //

    protected final int BOARD_SIZE = 6, TILE_SIZE = 100, MINCOL = 0, SELECTION_TILE_Y = 20;
    protected final int BOARD_XSTART = 400, BOARD_YSTART = 200, WIN_CONDITION = 4;

    protected Tile[][] board = new Tile[BOARD_SIZE][BOARD_SIZE];
    private static InputHandler input;
    private int selectedCol = 0;
    private boolean isBluesTurn = true, endOfGame = false;
    protected Tile rTile, bTile, eTile, selectionTile;
    protected Tile boxTile;
    // private Box boxTile;
    private String previousColour;
    private TileAudio audio;

//    private RandomNum randomNum;

    Random rand = new Random();     // random function //
    private int upperBound = 4;
    private int num_rand = rand.nextInt(upperBound);

    public Board() {    // constructor //

        input = new InputHandler();     // class variable //
        eTile = new Tile(EMPTY);
        bTile = new Tile(BLUE);
        rTile = new Tile(RED);
        boxTile = new Tile(BOX);
        // boxTile = new Box(BOX);
        selectionTile = new Tile(BOARD_XSTART, SELECTION_TILE_Y);
        selectionTile.setColour(BLUE);
        audio = new TileAudio();


        for (int row = 0; row < BOARD_SIZE; row++)      // draw the board
        {
            for (int col = 0; col < BOARD_SIZE; col++)
            {
                Tile empty = eTile.clone();

                empty.setX(BOARD_XSTART + (TILE_SIZE * col));
                empty.setY(BOARD_YSTART + (TILE_SIZE * row));

                board[row][col] = empty;


//                if(randomNum.getRandNum() == 0)
//                {
//                    Tile box0 = boxTile.clone();
//                    box0.setX(BOARD_XSTART + (TILE_SIZE * 0));
//                    box0.setY(BOARD_YSTART + (TILE_SIZE * 5));
//
//                    board[5][0] = box0;
//                    board[row][col].initialise();
//                }
//                else if(randomNum.getRandNum() == 1)
//                {
//                    Tile box1 = boxTile.clone();
//                    box1.setX(BOARD_XSTART + (TILE_SIZE * 1));
//                    box1.setY(BOARD_YSTART + (TILE_SIZE * 5));
//
//                    board[5][1] = box1;
//                    board[row][col].initialise();
//                }
//                else if(randomNum.getRandNum() == 2)
//                {
//                    Tile box2 = boxTile.clone();
//                    box2.setX(BOARD_XSTART + (TILE_SIZE * 2));
//                    box2.setY(BOARD_YSTART + (TILE_SIZE * 5));
//
//                    board[5][2] = box2;
//                    board[row][col].initialise();
//                }
//                else if(randomNum.getRandNum() == 3)
//                {
//                    Tile box3 = boxTile.clone();
//                    box3.setX(BOARD_XSTART + (TILE_SIZE * 3));
//                    box3.setY(BOARD_YSTART + (TILE_SIZE * 5));
//
//                    board[5][3] = box3;
//                    board[row][col].initialise();
//                }

                switch (num_rand)        // draw the board from random number
                {
                    case 0:                             // if random number is 0
                        Tile box0 = boxTile.clone();
                        Tile box1 = boxTile.clone();
                        Tile box2 = boxTile.clone();
                        Tile box20 = boxTile.clone();
                        Tile box21 = boxTile.clone();

                        box0.setX(BOARD_XSTART + (TILE_SIZE * 0));
                        box0.setY(BOARD_YSTART + (TILE_SIZE * 5));

                        box1.setX(BOARD_XSTART + (TILE_SIZE * 0));
                        box1.setY(BOARD_YSTART + (TILE_SIZE * 4));

                        box2.setX(BOARD_XSTART + (TILE_SIZE * 5));
                        box2.setY(BOARD_YSTART + (TILE_SIZE * 5));

                        box20.setX(BOARD_XSTART + (TILE_SIZE * 0));
                        box20.setY(BOARD_YSTART + (TILE_SIZE * 3));

                        box21.setX(BOARD_XSTART + (TILE_SIZE * 0));
                        box21.setY(BOARD_YSTART + (TILE_SIZE * 2));

                        board[5][0] = box0;
                        board[4][0] = box1;
                        board[5][5] = box2;

                        board[row][col].initialise();
                        break;

                    case 1:                             // if random number is 1
                        Tile box3 = boxTile.clone();
                        Tile box4 = boxTile.clone();
                        Tile box5 = boxTile.clone();

                        box3.setX(BOARD_XSTART + (TILE_SIZE * 1));
                        box3.setY(BOARD_YSTART + (TILE_SIZE * 5));

                        box4.setX(BOARD_XSTART + (TILE_SIZE * 1));
                        box4.setY(BOARD_YSTART + (TILE_SIZE * 4));

                        box5.setX(BOARD_XSTART + (TILE_SIZE * 4));
                        box5.setY(BOARD_YSTART + (TILE_SIZE * 5));

                        board[5][1] = box3;
                        board[4][1] = box4;
                        board[5][4] = box5;

                        board[row][col].initialise();
                        break;

                    case 2:                             // if random number is 2
                        Tile box6 = boxTile.clone();
                        Tile box7 = boxTile.clone();
                        Tile box8 = boxTile.clone();

                        box6.setX(BOARD_XSTART + (TILE_SIZE * 1));
                        box6.setY(BOARD_YSTART + (TILE_SIZE * 4));

                        box7.setX(BOARD_XSTART + (TILE_SIZE * 2));
                        box7.setY(BOARD_YSTART + (TILE_SIZE * 5));

                        box8.setX(BOARD_XSTART + (TILE_SIZE * 3));
                        box8.setY(BOARD_YSTART + (TILE_SIZE * 4));

                        board[4][1] = box6;
                        board[5][2] = box7;
                        board[4][3] = box8;

                        board[row][col].initialise();
                    break;

                    case 3:                             // if random number is 3
                        Tile box9 = boxTile.clone();
                        Tile box10 = boxTile.clone();
                        Tile box11 = boxTile.clone();

                        box9.setX(BOARD_XSTART + (TILE_SIZE * 1));
                        box9.setY(BOARD_YSTART + (TILE_SIZE * 2));

                        box10.setX(BOARD_XSTART + (TILE_SIZE * 3));
                        box10.setY(BOARD_YSTART + (TILE_SIZE * 4));

                        box11.setX(BOARD_XSTART + (TILE_SIZE * 5));
                        box11.setY(BOARD_YSTART + (TILE_SIZE * 5));

                        board[2][1] = box9;
                        board[4][3] = box10;
                        board[5][5] = box11;

                        board[row][col].initialise();
                    break;
                }
            }
        }

    }

    public static Board instance()      // method //
    {
        Board instance = new Board();
        return instance;
    }

    public void addTileAt(Tile tile, int col)       // add tile at selected column
    {
        for (int filledSpace = BOARD_SIZE - 1; filledSpace >= 0; filledSpace--)
        {
            if (board[filledSpace][col].getColour().equals(EMPTY))
            {
                tile.setX(board[filledSpace][col].getX());
                tile.setY(board[filledSpace][col].getY());
                board[filledSpace][col] = tile;
                board[filledSpace][col].initialise();
                if (hasGameBeenWon(filledSpace))
                {
                    audio.play(TileAudio.SoundId.GAME_WON);
                }
                return;
            }
        }
    }

    public void update(float delta)                 // update the status of the game
    {
        checkInput();   // check for the input
        for (int row = 0; row < BOARD_SIZE; row++)
        {
            for (int col = 0; col < BOARD_SIZE; col++)
            {
                board[row][col].update(delta);
            }
        }

        selectionTile.update(delta);

        if(selectionTile.getColour().equals(RED))    // if the current tile is red then previous tile is blue
        {
            previousColour = "BLUE";
        }
        else                                         // else the previous colour is red
        {
            previousColour = "RED";
        }

    }


    public void render(Graphics g)                    // render the tile in board
    {
        for (Tile row[] : board)
        {
            for (Tile tile : row)
            {
                tile.render(g);
            }
        }

        selectionTile.render(g);

        if(endOfGame)                                 // if the game is over then render the message below
        {
            g.scale(3,3);
            g.drawString("Game over "+ previousColour + " has won",BOARD_XSTART/3,TILE_SIZE/3);
        }

    }


    public void initialise()            // initial
    {
        for (int row = 0; row < BOARD_SIZE; row++)
        {
            for (int col = 0; col < BOARD_SIZE; col++)
            {
                board[row][col].initialise();
            }
        }
        selectionTile.initialise();
    }

    private void checkInput() {     // check for the player input
        if(!endOfGame) {    // if the game is not over
            if (input.isEnterPressed()) {
                audio.play(TileAudio.SoundId.TILE_FALL);
                flipTile();
            }

            if (input.isLeftPressed()) {
                if (selectedCol != MINCOL) {        // move the tile left
                    selectedCol--;
                    selectionTile.setX(selectionTile.getX() - TILE_SIZE);
                }
            }

            if (input.isRightPressed()) {           // move the tile right
                if (selectedCol != BOARD_SIZE - 1) {
                    selectedCol++;
                    selectionTile.setX(selectionTile.getX() + TILE_SIZE);
                }

            }
        }

    }

    private void flipTile() {     // change the tile colour
        if (isBluesTurn) {              // if it is blue turn then bTile.clone() at the selected column
            addTileAt(bTile.clone(), selectedCol);
            isBluesTurn = false;        // if not then set the tile colour as red
            selectionTile.setColour(RED);
        } else {
            addTileAt(rTile.clone(), selectedCol);
            isBluesTurn = true;
            selectionTile.setColour(BLUE);
        }
    }

    private boolean hasGameBeenWon(int selectedRow) {      // win condition check

        if (verticalWin()){                         // tiles form 4 in a line in vertical
            endOfGame = true;
        } else if (horizontalWin(selectedRow)){     // tiles form 4 in a line in horizontal
            endOfGame = true;
        } else if (diagonalWin(selectedRow)){       // tiles form 4 in a line in diagonal
            endOfGame = true;
        }

        return endOfGame;                    // if one following statement is ture then return endOfGame(game over)
    }

    private boolean verticalWin() {      // check for vertical win in the board
        int colourMatchs = 0, colourMismatch = 0, boxFound = 0;
        int row = 5;   // set count of row in the board as 5 (actually 6 start from 0-5)
        Tile.TileColour colour = board[row][selectedCol].getColour();

        do {
            if (!(colour.equals(board[row][selectedCol].getColour())))
            {
                colourMismatch++;
                colourMatchs = 0;
                if (colourMismatch > (BOARD_SIZE - WIN_CONDITION))    // if colourMismatch > 2 then return false
                {                    //   6      -      4
                    return false;
                }
            } else {
                colourMatchs++;
                if (colourMatchs == WIN_CONDITION) {        // if colourMatchs == 4, return true
                    return true;
                }
            }
            System.out.println(colourMatchs);   // just for testing
            row--;                              // after finish checking decrease the row
        }
        while (row >= 0);                       // checking from the top row of the board

        return false;                           // if there is no vertical 4 tiles return false
    }

    private boolean horizontalWin(int selectedRow) {     // horizontal win check
        int colourMatches = 0, colourMismatches = 0;
        Tile.TileColour colour = board[selectedRow][selectedCol].getColour();

        for (int col = 0; col < BOARD_SIZE; col++) {  // start checking form left column of the board, while col < 6
            if (!(colour.equals(board[selectedRow][col].getColour()))) {
                colourMismatches++;
                colourMatches = 0;
                if (colourMismatches > (BOARD_SIZE - WIN_CONDITION)) {
                    return false;
                }
            } else {
                colourMatches++;
                if (colourMatches == WIN_CONDITION) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean diagonalWin(int selectedRow) {      // diagonal win check

        if(bottomLeftDiagonal(selectedRow)){            // is the tiles form in diagonal bottom left?
            return true;
        }
        else if(bottomRightDiagonal(selectedRow)){      // is the tiles form in diagonal bottom right?
            return true;
        }
         else if (topLeftDiagonal(selectedRow)){        // is the tiles form in diagonal top left?
             return true;
        }
         else if (topRightDiagonal(selectedRow)){       // is the tiles form in diagonal top right?
             return true;
        }
        return false;                                   // else there is no diagonal win in the board
    }

    public boolean bottomLeftDiagonal(int selectedRow) {
        int colourMatches = 0, colourMismatches = 0;
        Tile.TileColour colour = board[selectedRow][selectedCol].getColour();
        int stepX = selectedRow;
        int stepY = selectedCol;

        while (stepX < BOARD_SIZE && stepY < BOARD_SIZE) {
            if (colour.equals(board[stepX][stepY].getColour())) {
                colourMatches++;
                if (colourMatches == WIN_CONDITION) {
                    return true;
                }
            } else {
                colourMismatches++;
                colourMatches = 0;
                if (colourMismatches > (BOARD_SIZE - WIN_CONDITION)) {
                    return false;
                }

            }
            stepX++;
            stepY++;
        }
        return false;
    }

    public boolean bottomRightDiagonal(int selectedRow) {
        int colourMatches = 0, colourMismatches = 0;
        Tile.TileColour colour = board[selectedRow][selectedCol].getColour();
        int stepX = selectedRow;
        int stepY = selectedCol;

        while (stepX < BOARD_SIZE && stepY >= MINCOL) {
            if (colour.equals(board[stepX][stepY].getColour())) {
                colourMatches++;
                if (colourMatches == WIN_CONDITION) {
                    return true;
                }
            } else {
                colourMismatches++;
                colourMatches = 0;
                if (colourMismatches > (BOARD_SIZE - WIN_CONDITION)) {
                    return false;
                }

            }
            stepX++;
            stepY--;
        }

        return false;
    }

    public boolean topLeftDiagonal(int selectedRow) {
        int colourMatches = 0, colourMismatches = 0;
        Tile.TileColour colour = board[selectedRow][selectedCol].getColour();
        int stepX = selectedRow;
        int stepY = selectedCol;

        while (stepX >= MINCOL && stepY < BOARD_SIZE) {
            if (colour.equals(board[stepX][stepY].getColour())) {
                colourMatches++;
                if (colourMatches == WIN_CONDITION) {
                    return true;
                }
            } else {
                colourMismatches++;
                colourMatches = 0;
                if (colourMismatches > (BOARD_SIZE - WIN_CONDITION)) {
                    return false;
                }

            }
            stepX--;
            stepY++;
        }

        return false;
    }


    public boolean topRightDiagonal(int selectedRow) {
        int colourMatches = 0, colourMismatches = 0;
        Tile.TileColour colour = board[selectedRow][selectedCol].getColour();
        int stepX = selectedRow;
        int stepY = selectedCol;

        while (stepX >= MINCOL && stepY >= MINCOL) {
            if (colour.equals(board[stepX][stepY].getColour())) {
                colourMatches++;
                if (colourMatches == WIN_CONDITION) {
                    return true;
                }
            } else {
                colourMismatches++;
                colourMatches = 0;
                if (colourMismatches > (BOARD_SIZE - WIN_CONDITION)) {
                    return false;
                }

            }
            stepX--;
            stepY--;
        }


        return false;
    }

}
