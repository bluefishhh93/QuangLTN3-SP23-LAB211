/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author xuant
 */
class HocVien {

    private String id;
    private String fullName;
    private int yob;
    private double score_1;
    private double score_2;
    private double scoreFinal;

    public HocVien() {
        
    }

    public HocVien(String id, String fullName, int yob, double score_1, double score_2, double scoreFinal) {
        this.id = id;
        this.fullName = fullName;
        this.yob = yob;
        this.score_1 = score_1;
        this.score_2 = score_2;
        this.scoreFinal = scoreFinal;
    }

    public double averageScore() {
        return ((this.score_1 + this.score_2) / 2 + scoreFinal * 2) / 3;
    }

    public void Classsification() {
        double average = averageScore();
        if (average >= 8) {
            System.out.println("Excellent");
        } else if (average >= 7) {
            System.out.println("Good");
        } else if (average >= 5) {
            System.out.println("Average");
        } else {
            System.out.println("Failed");
        }
    }

    @Override
    public String toString() {
        return "HocVien{" + "id=" + id + ", fullName=" + fullName + ", yob=" + yob + ", score_1=" + score_1 + ", score_2=" + score_2 + ", scoreFinal=" + scoreFinal + '}';
    }
    
}

class PhanSo {

    private int tuSo;
    private int mauSo;

    public PhanSo() {
    }

    public PhanSo(int tuSo, int mauSo) {
        this.tuSo = tuSo;
        if (mauSo != 0) {
            this.mauSo = mauSo;
        }
        rutGon();
    }

    public int getTuSo() {
        return tuSo;
    }

    public void setTuSo(int tuSo) {
        this.tuSo = tuSo;
    }

    public int getMauSo() {
        return mauSo;
    }

    public void setMauSo(int mauSo) {
        this.mauSo = mauSo;
    }

    public boolean isValid(PhanSo s) {
        return s.mauSo != 0;
    }

    public void NhapTuvaMau() {

    }

    public void rutGon() {
        int tuSo = getTuSo();
        int mauSo = getMauSo();
        int ucln = 1;
        for (int i = 1; i <= tuSo; i++) {
            if (tuSo % i == 0 && mauSo % i == 0) {
                ucln = i;
            }
        }
        setTuSo(tuSo / ucln);
        setMauSo(mauSo / ucln);
    }

    public PhanSo Add(PhanSo s1, PhanSo s2) {
        if (!isValid(s1) || !isValid(s2)) {
            System.out.println("phan so khong hop le");
            return null;
        }
        int mauSo;
        int tuSo;
        tuSo = s1.tuSo * s2.mauSo + s1.mauSo * s2.tuSo;
        mauSo = s1.mauSo * s2.mauSo;
        PhanSo s3 = new PhanSo(tuSo, mauSo);
        return s3;
    }

    public PhanSo Subtract(PhanSo s1, PhanSo s2) {
        if (!isValid(s1) || !isValid(s2)) {
            System.out.println("phan so khong hop le");
            return null;
        }
        int mauSo;
        int tuSo;
        tuSo = s1.tuSo * s2.mauSo - s1.mauSo * s2.tuSo;
        mauSo = s1.mauSo * s2.mauSo;
        PhanSo s3 = new PhanSo(tuSo, mauSo);
        return s3;
    }

    public PhanSo Multiply(PhanSo s1, PhanSo s2) {
        if (!isValid(s1) || !isValid(s2)) {
            System.out.println("phan so khong hop le");
            return null;
        }
        int mauSo;
        int tuSo;
        tuSo = s1.tuSo * s2.tuSo;
        mauSo = s1.mauSo * s2.mauSo;
        PhanSo s3 = new PhanSo(tuSo, mauSo);
        return s3;
    }

    public PhanSo Divide(PhanSo s1, PhanSo s2) {
        if (!isValid(s1) || !isValid(s2)) {
            System.out.println("phan so khong hop le");
            return null;
        }
        int mauSo;
        int tuSo;
        tuSo = s1.tuSo * s2.mauSo;
        mauSo = s1.mauSo * s2.tuSo;
        PhanSo s3 = new PhanSo(tuSo, mauSo);
        return s3;
    }

    @Override
    public String toString() {
        return this.tuSo + "/" + this.mauSo;
    }

    public void Compare(PhanSo s1, PhanSo s2) {
        if (!isValid(s1) || !isValid(s2)) {
            System.out.println("phan so khong hop le");
            return;
        }
        int tuSo1 = s1.tuSo * s2.mauSo;
        int tuSo2 = s2.tuSo * s1.mauSo;
        if (tuSo1 > tuSo2) {
            System.out.println(s1 + "  >  " + s2);
        } else if (tuSo1 < tuSo2) {
            System.out.println(s1 + "  <  " + s2);
        } else {
            System.out.println(s1 + "  =  " + s2);
        }
    }

}

public class FinalExam {

    public static void main(String[] args) {
        System.out.println("========================= TEST cau 1===================================");
        HocVien hv1 = new HocVien("s1", "Thanh", 2003, 8, 7, 9);
        System.out.println(hv1);
        System.out.println("Average: " + hv1.averageScore());
        hv1.Classsification();

        System.out.println("========================= TEST cau 2===================================");
        PhanSo ketQua = new PhanSo();
        PhanSo s1 = new PhanSo(3, 2);
        PhanSo s2 = new PhanSo(4, 2);
        System.out.println(s1 + "  va  " + s2);
        System.out.println("Cong 2 phan so: " + ketQua.Add(s1, s2));
        System.out.println("Tru 2 phan so: " + ketQua.Subtract(s1, s2));
        System.out.println("Nhan 2 phanh so: " + ketQua.Multiply(s1, s2));
        System.out.println("Chia 2 phan so: " + ketQua.Divide(s1, s2));
        System.out.print("So sanh 2 phan so: ");
        ketQua.Compare(s1, s2);
    }
}
