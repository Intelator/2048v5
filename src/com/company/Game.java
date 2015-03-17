package com.company;
import java.io.BufferedReader;
import java.lang.String;
import java.lang.System;
import java.io.IOException;
import java.util.ArrayList;
import java.io.*;

/**
 * Created by User on 16.03.2015.
 */

public class Game {

    boolean isMovesPossible = false;

    public boolean getIsMovesPossible () {
        return isMovesPossible;
    }

    public void setIsMovesPossible (boolean possibility) {
        isMovesPossible = possibility;
    }

    public void createNewField (Tiles[][] tile) {
        int i = 0;
        int j = 0;
        while (i<4) {
            while (j<4) {
                tile[i][j].setY(j);
                tile[i][j].setValue(0);
                j++;
            }
            j = 0;
            tile[i][j].setX(i);
            i++;
        }

    }

    public boolean checkPossibility (Tiles[][] tile) {
        int i = 0;
        int j = 0;

        //Проверим наличие пустых клеток
        if (getIsMovesPossible() == false) {
            while (i<4) {
                while (j<4) {
                    if (tile[i][j].getValue() == 0) {
                        setIsMovesPossible(true);
                        break;
                    }
                    j++;
                }
                j = 0;
                i++;
            }
        }

        //Проверим возможность сдвинуть ячейки по горизонтали
        if (getIsMovesPossible() == false) {
            i = 0;
            j = 0;
            while (i<3) {
                while (j<3) {
                    if (tile[i][j].getValue() == tile[i][j+1].getValue()) {
                        setIsMovesPossible(true);
                        break;
                    }
                    j++;
                }
                j = 0;
                i++;
            }
        }

        //Проверим возможность сдваинуть ячейки по горизонтали
        if (getIsMovesPossible() == false) {
            i = 0;
            j = 0;
            while (j<3) {
                while (i<3) {
                    if (tile[i][j].getValue() == tile[i+1][j].getValue()) {
                        setIsMovesPossible(true);
                        break;
                    }
                    i++;
                }
                i = 0;
                j++;
            }
        }

        return isMovesPossible;
    }

    //Определяем движение
    public Tiles[][] findMotion (Tiles[][] tile) {
        String userInput = Main.caddy.waitForUserInput();
        if (!((userInput.equals("a")) || (userInput.equals("s")) ||
                (userInput.equals("d")) || (userInput.equals("w")))) {
            System.out.println("Use keys a, s, d, or w!");
        }

        userInputWay(tile, userInput);

        return tile;
    }

    private void userInputWay(Tiles[][] tile, String userInput) {
        if (userInput.equals("a")) {
            Move.toTheLeft(tile);
            System.out.println("Moved to the left");
        }

        if (userInput.equals("s")) {
            Move.toTheDown(tile);
            System.out.println("Moved to the down");

        }

        if (userInput.equals("d")) {
            Move.toTheRight(tile);
            System.out.println("Moved to the right");
        }

        if (userInput.equals("w")) {
            Move.toTheUp(tile);
            System.out.println("Moved to the up");
        }
    }

    public void showTiles (Tiles[][] tile) {
        for (int j = 0; j <4; j++) {
            System.out.println(" ");
            for (int i = 0; i < 4; i++) {
                System.out.print(tile[i][j].getValue() + " ");
            }
        }
    }
}