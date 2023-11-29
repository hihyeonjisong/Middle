package kr.or.ddit.basic.hw;

import java.text.DecimalFormat;

public class homework {
//	문제) 태양계 행성을 나타내는 enum Planet을 이용하여 면적을 구하시오.
//	(단, enum 객체 생성시 반지름을 이용하도록 정의하시오.) 
//
//	예) 행성의 반지름(KM):

	public enum Planet {
		수성(2439), 
		금성(6052), 
		지구(6371), 
		화성(3390), 
		목성(69911), 
		토성(58232), 
		천왕성(25362), 
		해왕성(24622);

		private long i;
		
		Planet(int i) {
			this.i = i;
		}

		public long getI() {
			return this.i;
		}
	}

	public static void main(String[] args) {
		Planet[] enumArr = Planet.values();
		
		DecimalFormat df = new DecimalFormat("###,###.####");
		for (Planet p : enumArr) {
			System.out.println(p.name()+"의 반지름은" + df.format(p.getI()) + "Km" );
			System.out.println(p.name()+"의 면적은" + 4*p.getI()*p.getI()*3.14);
			System.out.println(p.name()+"의 면적은" + 4*Math.PI*Math.pow(p.getI(), 2));
			System.out.println(p.name()+"의 면적은" + df.format(4*Math.PI*Math.pow(p.getI(), 2))+ "Km²");
			System.out.println();
		}
	}
}
