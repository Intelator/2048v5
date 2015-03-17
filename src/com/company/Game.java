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
        if ((Main.caddy.waitForUserInput().equals("a") == false) & (Main.caddy.waitForUserInput().equals("s") == false) &
                (Main.caddy.waitForUserInput().equals("d") == false) & (Main.caddy.waitForUserInput().equals("w")) == false) {
            System.out.println("Use keys a, s, d, or w!");
        }

        if (Main.caddy.waitForUserInput().equals("a") == true) {
            Move.toTheLeft(tile);
        }

        if (Main.caddy.waitForUserInput().equals("s") == true) {
            Move.toTheDown(tile);
        }

        if (Main.caddy.waitForUserInput().equals("d") == true) {
            Move.toTheRight(tile);
        }

        if (Main.caddy.waitForUserInput().equals("s") == true) {
            Move.toTheUp(tile);
        }

        return tile;
    }
}