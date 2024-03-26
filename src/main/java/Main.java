import java.util.List;

public class Main {
    public static void main(String[] args) {
        ReadFile readFile=new ReadFile();
        readFile.readFile();

        List<Personel> personelList=readFile.getEmpList();
        for (Personel personel:personelList){
            System.out.println(personel);
        }
        PayrollDocument doc=new PayrollDocument();
        doc.printPayroll();
    }
}
