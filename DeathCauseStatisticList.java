import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class DeathCauseStatisticList {
    List<DeathCauseStatistic> deathList = new ArrayList<>();
    public void repopulate(String path) throws FileNotFoundException {
        deathList = new ArrayList<>();
        File file = new File(path);
        if(file.exists()){
            Scanner scanner = new Scanner(file);
            scanner.nextLine();
            scanner.nextLine();
            while(scanner.hasNextLine()){
                String line = scanner.nextLine();
                deathList = (DeathCauseStatistic.fromCsvLine(line));
            }
        }

    }

    public List<DeathCauseStatistic> mostDeadlyDiseases(int age, int n){
        List<DeathCauseStatistic> results = new ArrayList<>(deathList);
        int index = age/5;

    }
}
