public class Manager extends Personel{


    Double hourlyWage;
   public Manager(String name, String surname,Double workHour) {
        super(name, surname,workHour);
        this.bonus = hourlyWage*90;
        this.hourlyWage=500.0;
        this.baseSalary=this.hourlyWage*this.workHour;
    }


    public Double getBonus() {
        return bonus;
    }

    public void setBonus(Double bonus) {
        this.bonus = bonus;
    }

    public Double getHourlyWage() {
        return hourlyWage;
    }

    public void setHourlyWage(Double hourlyWage) {
        this.hourlyWage = hourlyWage;
    }

    @Override
   public void calculateSalary() {
       this.totalSalary=(this.hourlyWage*this.workHour)+this.bonus;

    }
}
