package com.company;

public class Main {

    public void main(String[] args) {
        Tiles[][] tile = new Tiles[4][4];
        Helper caddy = new Helper();
        Game play = new Game();

        //Заполняем поле нулями
        play.createNewField(tile);

        //Начинаем игру
        while (play.getIsMovesPossible() == true) {
            //Создаем случайную плитку
            caddy.createRandomTile(tile);

            //Двигаем плитки в зависимости от ввода
            play.findMotion(tile);

            //Выводим поле на экран
        }
    }
}
