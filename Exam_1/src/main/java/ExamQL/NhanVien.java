package ExamQL;

public class NhanVien extends CanBo {
private String job;

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }

    public NhanVien() {

    }

    public NhanVien(String hoVaTen, int tuoi, String gioiTinh, String diaChi, String job) {
        super(hoVaTen, tuoi, gioiTinh, diaChi);
        this.job = job;
    }
}
