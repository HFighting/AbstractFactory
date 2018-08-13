package AbstractFactory;

public class getType {

	public static void main(String[] args) {
		abstracFactory shapfactory = abstractTypeFactory.getAbstracFactory("shap");
		//有父类存在的地方,子类一定可以存在,强转就行
		circle circle = (circle) shapfactory.getShap("circle");
		circle.draw();
		circle.getR();
	}
}
