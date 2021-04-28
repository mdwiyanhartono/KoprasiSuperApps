package dwiyanhartono.com.loankoprasi.Data;

public class DataFoodDetail {
    private int image;
    private String labelnama;
    private String labelkategory;
    private String desc;
    private String harga;

    public DataFoodDetail(int image, String labelnama, String labelkategory, String desc, String harga) {
        this.image = image;
        this.labelnama = labelnama;
        this.labelkategory = labelkategory;
        this.desc = desc;
        this.harga = harga;
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

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getHarga() {
        return harga;
    }

    public void setHarga(String harga) {
        this.harga = harga;
    }
}
