package models;

import controllers.Credentials;
import utils.HashMap;
import utils.Image;
import utils.ImageView;
import utils.Interfaces.IImageViewAble;
import utils.Vector2;

public enum CardIndicator {

	INSTANCE;

	private ImageViewClone imageViewClone = new ImageViewClone();

	private CardIndicator() {

	}

	public void setImage(Image image) {
		this.imageViewClone.setImage(image);
	}

	public void clear() {
		this.imageViewClone.clear();
	}

	private class ImageViewClone implements IImageViewAble {

		private HashMap<String, Image> map = new HashMap<>();
		private Image transparent = new Image("misc/invisible.png");
		private Vector2 coordinates = null;

		public ImageViewClone() {

			new ImageView(this.transparent, this);

			double x = Credentials.INSTANCE.gapBetweenBorders;
			double y = Credentials.INSTANCE.dFrame.y;
			y -= Credentials.INSTANCE.gapBetweenBorders;
			this.coordinates = new Vector2(x, y);

		}

		public void setImage(Image image) {

			String filePath = image.getFilePath();

			if (!this.map.containsKey(filePath))
				this.map.put(filePath, new Image(filePath));

			getImageView().setImage(this.map.getValue(filePath));
			getImageView().relocateBottomLeft(this.coordinates);

		}

		public void clear() {
			getImageView().setImage(this.transparent);
		}

	}

}
