package kr.or.ddit.basic.hw;

import java.math.BigDecimal;
import java.text.DecimalFormat;

public class HomeworkEnum {
    public enum Planet {
        수성(2439), 
        금성(6052), 
        지구(6371), 
        화성(3390), 
        목성(69911), 
        토성(58232), 
        천왕성(25362), 
        해왕성(24622);

        private int radius;
        
        Planet(int radius) {
            this.radius = radius;
        }

        public int getRadius() {
            return this.radius;
        }

        public double getArea() {
            return 4*Math.PI*Math.pow(radius, 2);
        }

    }

    public static void main(String[] args) {
        Planet[] planetArr = Planet.values();

        for (Planet p : planetArr) {
            BigDecimal area = new BigDecimal(p.getArea()).setScale(4, BigDecimal.ROUND_HALF_UP);
            DecimalFormat formatP = new DecimalFormat("###,###.####");
            System.out.println(p.name() + "의 반지름 : " + formatP.format(p.getRadius()) + "Km \n" + p.name() + "의 면적 : " + formatP.format(p.getArea()) + "km²");
       }
    }
}

