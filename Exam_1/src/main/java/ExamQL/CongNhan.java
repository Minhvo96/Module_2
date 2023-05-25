package ExamQL;

public class CongNhan extends CanBo {
    private int capBac;

    public CongNhan() {
    }

    public CongNhan(String hoVaTen, int tuoi, String gioiTinh, String diaChi, int capBac) {
        super(hoVaTen, tuoi, gioiTinh, diaChi);
        this.capBac = capBac;
    }

    public int getCapBac() {
        return capBac;
    }

    public void setCapBac(int capBac) {
        this.capBac = capBac;
    }
}
