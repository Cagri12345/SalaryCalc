package ProjectClass;

/*
Java'da "Employee" adında fabrika çalışanlarını temsil eden ve metotları ile çalışanların maaşlarını hesaplayan bir sınıf yazmalısınız. Bu sınıf 4 nitelik ve 5 metoda sahip olacaktır.

Sınıfın Nitelikleri

name : Çalışanın adı ve soyadı
salary : Çalışanın maaşı
workHours : Haftalık çalışma saati
hireYear : İşe başlangıç yılı
Sınıfın Metotları

Employee(name,salary,workHours,hireYear) : Kurucu metot olup 4 parametre alacaktır.
tax() : Maaşa uygulanan vergiyi hesaplayacaktır.
Çalışanın maaşı 1000 TL'den az ise vergi uygulanmayacaktır.
Çalışanın maaşı 1000 TL'den fazla ise maaşının %3'ü kadar vergi uygulanacaktır.
bonus() : Eğer çalışan haftada 40 saatten fazla çalışmış ise fazladan çalıştığı her saat başına 30 TL olacak şekilde bonus ücretleri hesaplayacaktır.
raiseSalary() : Çalışanın işe başlangıç yılına göre maaş artışını hesaplayacaktır. Şuan ki yılı 2021 olarak alın.
Eğer çalışan 10 yıldan az bir süredir çalışıyorsa maaşına %5 zam yapılacaktır.
Eğer çalışan 9 yıldan fazla ve 20 yıldan az çalışıyorsa maaşına %10 zam yapılacaktır.
Eğer çalışan 19 yıldan fazla çalışıyorsa %15 zam yapılacaktır.
toString() : Çalışana ait bilgileri ekrana bastıracaktır.
 */

public class Employee {
    private String name;
    private double salary;
    private int workHours;
    private int hireYear;


    //Kurucu metot
    public Employee(String name,double salary,int workHours,int hireYear){
        this.name = name;
        this.salary = salary;
        this.workHours = workHours;
        this.hireYear = hireYear;
    }

    //Vergi hesaplama Metodu
    public double tax(){
        if(salary < 1000){
            return 0;
        } else {
            return salary * 0.03;
        }
    }

    //Bonusu hesaplama metodu
    public double bonus(){
        if(workHours > 40) {
            return (workHours - 40) * 30;
        } else {
            return 0;
        }
    }

    //Maaş artışını hesaplayan metot
    public double raiseSalary(){
        int currentYear = 2021;
        int workYears = currentYear - hireYear;

        if(workYears < 10){
            return salary * 0.05;
        } else if (workYears >= 10 && workYears < 20){
            return salary * 0.10;
        } else {
            return salary * 0.15;
        }
    }

    //Çalışanın bilgilerini ekrana yazdıran metot
    public String toString(){
        double salaryWithTaxAndBonus = salary - tax() + bonus();
        double totalSalary = salaryWithTaxAndBonus + raiseSalary();

        return "Adı : " + name + "\n" +
                "Maaşı : " + salary + "\n" +
                "Çalışma Saati : " + workHours + "\n" +
                "Başlangıç Yılı : " + hireYear + "\n" +
                "Vergi : " + tax()+ "\n" +
                "Bonus : " + bonus() + "\n" +
                "Maaş Artışı : " + raiseSalary() + "\n" +
                "Vergi ve Bonuslar ile birlikte maaş : " + salaryWithTaxAndBonus + "\n" +
                "Toplam Maaş : " + totalSalary;

    }

    public static void main(String[] args) {

        Employee employee1 = new Employee("Kemal",2000.0,45,1985);
        System.out.println(employee1.toString());
    }
}
