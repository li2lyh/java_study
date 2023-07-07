package ch11_collections;

import java.util.*;

public class QueueEx1 {
	static Queue q = new LinkedList();
	static final int MAX_SIZE = 5; // Queue에 최대 5개까지만 저장되도록 함

	public static void main(String[] args) {
		System.out.println("help를 입력하면 도움말을 볼 수 있습니다.");

		while (true) {
			System.out.print(">>");
			try {
				// 화면으로부터 라인단위로 입력받음
				Scanner s = new Scanner(System.in);
				String input = s.nextLine().trim();

				if ("".equals(input))
					continue;

				if (input.equalsIgnoreCase("q")) {
					System.exit(0);
				} else if (input.equalsIgnoreCase("help")) {
					System.out.println(" help - 도움말을 보여줍니다.");
					System.out.println(" q 또는 Q - 프로그램을 종료합니다.");
					System.out.println(" history = 최근에 입력한 명령어를 " + MAX_SIZE + "개 보여줍니다.");
				} else if (input.equalsIgnoreCase("history")) {
					int i = 0;
					// 입력받은 명령어를 저장
					save(input);

					// LinkedList의 내용을 보여줌
					LinkedList tmp = (LinkedList) q;
					ListIterator it = tmp.listIterator();

					while (it.hasNext())
						System.out.println(++i + "." + it.next());
				} else {
					save(input);
					System.out.println(input);
				} // if(input.euqalsIgnoreCase("q")){
			} catch (Exception e) {
				System.out.println("입력 오류입니다.");
			}
		}
	}

	public static void save(String input) {
		// queue에 저장
		if (!"".equals(input))
			q.offer(input);
		// queue의 최대 크기를 넘은 제일 처음 입력된 것을 삭제
		if (q.size() > MAX_SIZE) // size()는 Collection인터페이스에 정의
			q.remove();
	}
}
