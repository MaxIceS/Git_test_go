
public class Main {

	public static void main(String[] args) {
		Birds bird = new Birds("������", true);
		Birds bird2 = new Birds("������", false);		
		
		System.out.println(bird.getName());
		System.out.println(bird.isCanFly());
		System.out.println(bird2.getName());
		System.out.println(bird2.isCanFly());		
		
		
	}

}
