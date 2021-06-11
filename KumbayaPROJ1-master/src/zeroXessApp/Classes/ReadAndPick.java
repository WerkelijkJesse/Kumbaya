package zeroXessApp.Classes;

import javafx.scene.image.Image;

public class ReadAndPick {

    private String nameImage;

    private Image png;

    public ReadAndPick(String nameImage, Image png) {
        this.nameImage = nameImage;
        this.png = png;
    }

    public String getNameImage() {
        return nameImage;
    }

    public void setNameImage(String nameImage) {
        this.nameImage = nameImage;
    }

    public Image getPng() {
        return png;
    }

    public void setPng(Image png) {
        this.png = png;
    }
}
