public class Main {
    public static void main(String[] args) {
        System.out.println(DeathCauseStatistic.fromCsvLine(5).toString());

        DeathCauseStatistic stat = DeathCauseStatistic.fromCsvLine(5);
        DeathCauseStatistic.AgeBracketDeaths something = stat.GetAgeBracketDeaths(45);

        System.out.println("Wiek: " + something.young + " - " + something.old);
        System.out.println("Liczba zgonów: " + something.deathCount);

    }
}
