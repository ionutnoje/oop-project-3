package Classes;

import GUI.Welcome;

public class Main extends Thread{
    public static void main(String[] args) {


        Welcome welcomeFrame = new Welcome("Login");

        FirstThread firstThread = new FirstThread();
        SecondThread secondThread = new SecondThread();

        Thread thread1 = new Thread(firstThread);
        Thread thread2 = new Thread(secondThread);

    }
}
