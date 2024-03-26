import org.json.simple.JSONObject;

import java.io.FileWriter;
import java.io.IOException;

public class PayrollDocument {

    public PayrollDocument(){}

    public void printPayroll(){
        ReadFile readFile=new ReadFile();
        JSONObject obj=new JSONObject();
        for (Personel personel:readFile.empList) {
            obj.put("Payroll Day:",personel.getPayrollDay());
            obj.put("Name: ", personel.getName());
            obj.put("Surname: ", personel.getSurname());
            obj.put("Work Hour: ",personel.getWorkHour());
            obj.put("Base Salary: ", personel.getBaseSalary());
            obj.put("Extra Pay: ", personel.getExtraPay());
            obj.put("Bonus: ", personel.getBonus());
            obj.put("Total Salary: ", personel.getTotalSalary());

        }
        try(FileWriter file=new FileWriter("employee.json")) {
            file.write(obj.toJSONString());
            file.flush();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }


    }
}
