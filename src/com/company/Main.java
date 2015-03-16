package com.company;

public class Main {

    public void main(String[] args) {
        Tiles[][] tile = new Tiles[4][4];
        Helper caddy = new Helper();

        //Заполняем поле нулями
        Game.createNewField(tile);

        //Начинаем игру
        while (Game.getIsMovesPossible() == true) {
            //Создаем случайную плитку
            caddy.createRandomTile(tile);

            //Двигаем плитки в зависимости от ввода
            Game.findMotion(tile);

            //Выводим поле на экран
        }
    }
}
