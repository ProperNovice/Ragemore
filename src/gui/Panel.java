package gui;

import enums.ELayerZ;
import utils.Background;

public class Panel extends Parent {

	public Panel() {

		GuiInstances.INSTANCE.setParent(this);
		new Background(ELayerZ.BACKGROUND);

	}

}
