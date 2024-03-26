import java.time.LocalDate;

public abstract class Personel {
    String name;
    String surname;
    Double baseSalary;
    Double totalSalary;
    Double workHour;
    LocalDate payrollDay;
    Double extraPay;
    Double bonus;

    Personel(String name, String surname,Double workHour){
        this.name = name;
        this.surname = surname;
        this.workHour=workHour;

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public Double getBaseSalary() {
        return baseSalary;
    }

    public Double getTotalSalary() {
        return totalSalary;
    }

    public Double getWorkHour() {
        return workHour;
    }

    public void setWorkHour(Double workHour) {
        this.workHour = workHour;
    }

    public LocalDate getPayrollDay() {
        return payrollDay;
    }

    public void setPayrollDay(LocalDate payrollDay) {
        this.payrollDay = payrollDay;
    }

    public Double getExtraPay() {
        return extraPay;
    }

    public Double getBonus() {
        return bonus;
    }

    abstract void calculateSalary();
}
