import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;


import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
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
        JSONParser parser = new JSONParser();
        try(FileReader fileReader=new FileReader("src/main/resources/employees.json")) {
            Object obj = parser.parse(fileReader);
            JSONObject jobj= (JSONObject) obj;
            String role=(String) jobj.get("Role");
            String name=(String) jobj.get("Name");
            String surname=(String) jobj.get("Surname");
            ERank rank=(ERank) jobj.get("Rank");
            Double workHour=(Double) jobj.get("WorkHour");
            if (role.equals("Officer")) {
            Officer person=new Officer(name,surname,rank,workHour);
                person.setHourlyWage(person.rank);
                person.calculateSalary();
                LocalDate date=LocalDate.now();
                person.setPayrollDay(date);
                empList.add(person);
            } else if (role.equals("Manager")) {
                Manager person=new Manager(name, surname,workHour);
                person.calculateSalary();
                LocalDate date=LocalDate.now();
                person.setPayrollDay(date);
                empList.add(person);
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
    }
}
