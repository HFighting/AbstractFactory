package AbstractFactory;

public class circle extends shap{

	@Override
	public void draw() {
		System.out.println("draw a circle");
	}
	public void getR(){
		System.out.println("半径为r");
	}

}
