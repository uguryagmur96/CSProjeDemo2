import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;


import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ReadFile {
    List<Personel> empList;
    public ReadFile() {
        this.empList=new ArrayList<>();
    }

    public List<Personel> getEmpList() {
        return empList;
    }

    public  void readFile() {
        ObjectMapper objectMapper=new ObjectMapper();
        ERank rank=ERank.MID;

        try {
            JsonNode rootNode=objectMapper.readTree(new File("src/main/resources/employees.json"));
            Iterator<JsonNode> iterator=rootNode.elements();
            while (iterator.hasNext()){
                JsonNode node=iterator.next();
                String role=node.get("Role").asText();
                String name=node.get("Name").asText();
                String surname=node.get("Surname").asText();
                Double workHour=node.get("WorkHour").asDouble();
                if (role.equals("Officer")) {
                    Officer person = new Officer(name, surname, rank, workHour);
                    person.setHourlyWage(person.rank);
                    person.calculateSalary();
                    LocalDate date = LocalDate.now();
                    person.setPayrollDay(date);
                    empList.add(person);
                }else if (role.equals("Manager")) {
                    Manager person=new Manager(name, surname,workHour);
                    person.setBonus();
                    person.calculateSalary();
                    LocalDate date=LocalDate.now();
                    person.setPayrollDay(date);
                    empList.add(person);
                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
