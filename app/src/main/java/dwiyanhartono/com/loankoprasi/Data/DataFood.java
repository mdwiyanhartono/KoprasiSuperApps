package dwiyanhartono.com.loankoprasi.Data;

public class DataFood {
    private int image;
    private String labelnama;
    private String labelkategory;
    private String bintang;
    private String jarak;

    public DataFood(int image, String labelnama, String labelkategory, String bintang, String jarak) {
        this.image = image;
        this.labelnama = labelnama;
        this.labelkategory = labelkategory;
        this.bintang = bintang;
        this.jarak = jarak;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public String getLabelnama() {
        return labelnama;
    }

    public void setLabelnama(String labelnama) {
        this.labelnama = labelnama;
    }

    public String getLabelkategory() {
        return labelkategory;
    }

    public void setLabelkategory(String labelkategory) {
        this.labelkategory = labelkategory;
    }

    public String getBintang() {
        return bintang;
    }

    public void setBintang(String bintang) {
        this.bintang = bintang;
    }

    public String getJarak() {
        return jarak;
    }

    public void setJarak(String jarak) {
        this.jarak = jarak;
    }
}
