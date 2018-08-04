package AbstractFactory;

public class abstractColorFactory extends abstracFactory {

	@Override
	public shap getShap(String string) {
		
		return null;
	}

	@Override
	public color getColor(String string) {
		if (string==null) {
			return null;
		}
		if (string.equals("red")) {
			return new red();
		}
		if (string.equals("blue")) {
			return new blue();
		}
		return null;
	}

}
