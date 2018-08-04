package AbstractFactory;

public class getType {

	public static void main(String[] args) {
		abstracFactory shapfactory = abstractTypeFactory.getAbstracFactory("shap");
		shap circle = shapfactory.getShap("circle");
		circle.draw();
	}

}
