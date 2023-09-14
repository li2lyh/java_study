package ch13_thread;

public class ThreadEx3 {
	public static void main(String[] args) throws Exception{
		// Thread의 자손클래스의 인스턴스 생성
		ThreadEx3_1 t1 = new ThreadEx3_1();
		// 쓰레드 실행
		t1.start();
	}
}

class ThreadEx3_1 extends Thread {
	// Thread클래스의 run()재정의
	public void run() {
		throwException();
	}
	
	public void throwException() {
		try {
			throw new Exception();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
}
