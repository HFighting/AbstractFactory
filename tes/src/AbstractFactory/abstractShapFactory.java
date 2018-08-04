package AbstractFactory;


public class abstractShapFactory extends abstracFactory {

	@Override
	public shap getShap(String string) {
		if (string==null) {
			return null;
		}
		if (string.equals("circle")) {
			return new circle();
		}
		if (string.equals("rectangle")) {
			return new rectangle();
		}
		return null;
	}

	@Override
	public color getColor(String string) {
		
		return null;
	}

}
