public class Officer extends Personel {
    ERank rank;
    Double hourlyWage;


    public Officer(String name, String surname, ERank rank, Double workHour) {
        super(name, surname,workHour);
        this.rank = rank;
        this.hourlyWage = 500.0;
    }

    public ERank getRank() {
        return rank;
    }

    public void setRank(ERank rank) {
        this.rank = rank;
    }

    public Double getHourlyWage() {
        return hourlyWage;
    }

    public void setHourlyWage(ERank rank) {
        if (getRank().equals(rank.SENIOR)) {
            this.hourlyWage = 1500.0;
        } else if (getRank().equals(rank.MID)) {
            this.hourlyWage = 1000.0;
        }
    }

    @Override
    public void calculateSalary() {
        if (hourlyWage <= 180.0) {
            this.baseSalary = hourlyWage * workHour;
        } else if (hourlyWage>180.0) {
            Double extraHour = workHour - 180.0;
            Double extraHourPay = hourlyWage*1.5;
            this.baseSalary = 180.0 * workHour;
            this.extraPay=extraHourPay*extraHour;
            this.totalSalary=baseSalary+extraPay;
        }
    }
}
