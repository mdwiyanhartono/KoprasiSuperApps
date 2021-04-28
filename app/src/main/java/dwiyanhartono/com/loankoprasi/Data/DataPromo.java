package dwiyanhartono.com.loankoprasi.Data;

public class DataPromo {
    private int image;
    private String label;

    public DataPromo(int image, String label) {
        this.image = image;
        this.label = label;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }
}
