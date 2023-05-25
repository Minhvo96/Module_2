package ExamQL;

public class KySu extends CanBo {
    private String nganhDaoTao;


    public KySu() {
    }

    public KySu(String hoVaTen, int tuoi, String gioiTinh, String diaChi, String nganhDaoTao) {
        super(hoVaTen, tuoi, gioiTinh, diaChi);
        this.nganhDaoTao = nganhDaoTao;
    }

    public String getNganhDaoTao() {
        return nganhDaoTao;
    }

    public void setNganhDaoTao(String nganhDaoTao) {
        this.nganhDaoTao = nganhDaoTao;
    }
}

