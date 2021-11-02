package Classes;

import GUI.Welcome;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {

        ArrayList<Masini> arrayList_masini = new ArrayList<>();

        FirstThread firstThread = new FirstThread();
        SecondThread secondThread = new SecondThread();

        Thread thread1 = new Thread(firstThread);
        Thread thread2 = new Thread(secondThread);

        Welcome welcomeFrame = new Welcome("Login");
    }
}
