package thread;

import java.util.ArrayList;

// 동작하고 있는 프로그램을 프로세스(process)라고 한다. 보통 한 개의 프로세스는 한 가지의 일을 하지만, 스레드(thread)를 이용하면 한 프로세스 내에서 두 가지 또는 그 이상의 일을 동시에 할 수 있다

public class Thread3 extends Thread {
    int seq;

    public Thread3(int seq){
        this.seq = seq;
    }

    public void run(){
        System.out.println(this.seq + "thread start");  // 쓰레드 시작
        try{
            Thread.sleep(1000); // 1초 대기한다
        } catch (Exception e){
        }
        System.out.println(this.seq + "thread end");    // 쓰레드 종료
    }

    public static void main(String[] args) {
        ArrayList<Thread> threads = new ArrayList<>();
        for(int i=0; i<10; i++){    // 총 10개의 쓰레드를 생성하여 실행한다
            Thread t = new Thread3(i);
            t.start();
            threads.add(t);
        }
        for(int i=0; i<threads.size(); i++){
            Thread t = threads.get(i);
            try{
                t.join();   // t 쓰레드가 종료할 때까지 기다린다
            } catch(Exception e){
            }
        }
        System.out.println("main end"); // main 메서드 종료
    }
}
