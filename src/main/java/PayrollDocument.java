import com.fasterxml.jackson.core.exc.StreamWriteException;
import com.fasterxml.jackson.databind.DatabindException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import org.json.simple.JSONObject;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.time.format.DateTimeFormatter;

public class PayrollDocument {

    public PayrollDocument(){}

    public void printPayroll(){
        ReadFile readFile=new ReadFile();
        ObjectMapper  objectMapper=new ObjectMapper();
        ArrayNode  arrayNode=objectMapper.createArrayNode();
        ObjectNode  objectNode=objectMapper.createObjectNode();
        DateTimeFormatter  formatter=DateTimeFormatter.ofPattern("dd/MM/yyyy");
        for (Personel personel:readFile.empList){
            String payrollDay=formatter.format(personel.getPayrollDay());
            objectNode.put("Payroll Day: ",payrollDay);
            objectNode.put("Name: ", personel.getName());
            objectNode.put("Surname: ", personel.getSurname());
            objectNode.put("Work Hour: ", personel.getWorkHour());
            objectNode.put("Base Salary: ", personel.getBaseSalary());
            objectNode.put("Extra Pay: ", personel.getExtraPay());
            objectNode.put("Bonus: ", personel.getBonus());
            objectNode.put("Total Salary: ", personel.getTotalSalary());
            arrayNode.add(objectNode);
        }
       try {
           objectMapper.writeValue(new File("payroll.json"),arrayNode);
           System.out.println("Payroll is printed.");
       } catch (StreamWriteException e) {
           throw new RuntimeException(e);
       } catch (DatabindException e) {
           throw new RuntimeException(e);
       } catch (IOException e) {
           throw new RuntimeException(e);
       }

    }
}
