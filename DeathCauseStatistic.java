import java.io.BufferedReader;
import java.io.FileReader;
public class DeathCauseStatistic {
    private String ICD_10;
    private int[] AgeDeathStat;

    public DeathCauseStatistic(String ICD_10, int [] AgeDeathStat) {
        this.ICD_10 = ICD_10;
        this.AgeDeathStat = AgeDeathStat;
}

    public static DeathCauseStatistic fromCsvLine(int x){
        String FilePath = "src/zgony (1).csv";
        String line = "";
        String icd_10 = "";
        int sum = 0;
        int [] ADS = new int [20];

        try{
            BufferedReader reader = new BufferedReader(new FileReader(FilePath));
            for(int i = 0; i < x; i++)
            {
               line = reader.readLine();
            }

            String[] fields = line.split( ",");

            icd_10 = fields[0].trim();

            for(int i = 2; i < 22; i++)
            {
                if(fields[i].equals("-"))
                {
                    ADS[i-2] = 0;
                }
                else {
                    ADS[i - 2] = Integer.parseInt(fields[i]);
                }

            }

            reader.close();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        DeathCauseStatistic test = new DeathCauseStatistic(icd_10, ADS);

        return test;
    }
    @Override
    public String toString(){
        String cos;
        cos = (ICD_10 + "   ");
        for(int i = 0; i < 20; i++)
        {
            cos += (" " + AgeDeathStat[i]);
        }
        return cos;
        }


        public AgeBracketDeaths GetAgeBracketDeaths(int age){
            if(age > 95)
            {
                age = 95;
            }

            int start = age/5*5;
            int end = (age/5*5)+4;
            int index = age/5;

            AgeBracketDeaths ABD = new AgeBracketDeaths(start, end, AgeDeathStat[index]);

            return ABD;

        }
        public class AgeBracketDeaths {
            public final int young;
            public final int old;
            public final int deathCount;

            public AgeBracketDeaths(int young, int old, int deathCount) {
                this.young = young;
                this.old = old;
                this.deathCount = deathCount;

            }
        }

}
