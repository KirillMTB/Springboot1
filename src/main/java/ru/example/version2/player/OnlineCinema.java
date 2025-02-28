package ru.example.version2.player;

public class OnlineCinema {
    public static void main(String[] args) {
        Player player = new Player();
        UI ui = new UI(player);
        ui.init();
    }
}
