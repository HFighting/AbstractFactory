package AbstractFactory;

public class abstractTypeFactory {
	public static abstracFactory getAbstracFactory(String string){
		if (string.equals("shap")) {
			return new abstractShapFactory();
		}
		if (string.equals("color")) {
			return new abstractColorFactory();
		}
		return null;
	}
}
