package com.company;

public class Main {
    static Helper caddy = new Helper();
    static Tiles[][] tile = new Tiles[4][4];

    static Game play = new Game();

    public static void main(String[] args) {
        System.out.println("Hello!");

        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                tile[i][j] = new Tiles();
            }
        }

        //Заполняем поле нулями
        play.createNewField(tile);
        caddy.createRandomTile(tile);
        play.showTiles(tile);

        //Начинаем игру
        do {
            //Проверяем возможность создания новой плитки
            play.checkPossibility(tile);

            //Двигаем плитки в зависимости от ввода
            play.findMotion(tile);

            //Создаем случайную плитку
            caddy.createRandomTile(tile);

            //Выводим поле на экран
            play.showTiles(tile);
        } while (play.getIsMovesPossible() == true);
    }
}
