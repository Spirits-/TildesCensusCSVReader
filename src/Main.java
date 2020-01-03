import com.opencsv.CSVWriter;
import com.opencsv.bean.CsvToBeanBuilder;
import representation.FactoredFormEntry;
import representation.RawFormEntry;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        try {
            List<RawFormEntry> beans = new CsvToBeanBuilder<RawFormEntry>(new FileReader("src/data/The-2019ish-Tildes-Census.csv")).withType(RawFormEntry.class).build().parse();

            HashMap<Integer, Integer> age = new HashMap<>();
            HashMap<Boolean, Integer> trans = new HashMap<>(),
                    tildesAccount = new HashMap<>();
            HashMap<String, Integer> countries = new HashMap<>(),
                    gender = new HashMap<>(),
                    sexuality = new HashMap<>(),
                    religion = new HashMap<>(),
                    languages = new HashMap<>(),
                    work = new HashMap<>(),
                    education = new HashMap<>(),
                    mobOS = new HashMap<>(),
                    compOS = new HashMap<>(),
                    tildesAccess = new HashMap<>(),
                    tildesAccessAmount = new HashMap<>();
            HashSet<String> likeTildes = new HashSet<>();
            HashSet<String> dislikeTildes = new HashSet<>();
            HashSet<String> changeTildes = new HashSet<>();

            int avgEcon = 0, avgDipl = 0, avgStat = 0, avgSoci = 0, noPolitics = 0;
            for (RawFormEntry b : beans) {
                FactoredFormEntry e = new FactoredFormEntry(b);

                if (countries.containsKey(e.getCountry())) countries.computeIfPresent(e.getCountry(), (k, v) -> v + 1);
                else countries.put(e.getCountry(), 1);

                if (age.containsKey(e.getAge())) age.computeIfPresent(e.getAge(), (k, v) -> v + 1);
                else age.put(e.getAge(), 1);

                if (gender.containsKey(e.getGender())) gender.computeIfPresent(e.getGender(), (k, v) -> v + 1);
                else gender.put(e.getGender(), 1);

                if (trans.containsKey(e.getTrans())) trans.computeIfPresent(e.getTrans(), (k, v) -> v + 1);
                else trans.put(e.getTrans(), 1);

                if (sexuality.containsKey(e.getSexuality())) sexuality.computeIfPresent(e.getSexuality(), (k, v) -> v + 1);
                else sexuality.put(e.getSexuality(), 1);

                if (religion.containsKey(e.getReligion())) religion.computeIfPresent(e.getReligion(), (k, v) -> v + 1);
                else religion.put(e.getReligion(), 1);

                for (String lang : e.getLanguage()) {
                    if (languages.containsKey(lang)) languages.computeIfPresent(lang, (k, v) -> v + 1);
                    else languages.put(lang, 1);
                }

                int[] pol = e.getPolitics();

                if (pol[0] != -1) avgEcon += pol[0];
                else noPolitics++;
                if (pol[1] != -1) avgDipl += pol[1];
                if (pol[2] != -1) avgStat += pol[2];
                if (pol[3] != -1) avgSoci += pol[3];

                if (work.containsKey(e.getWork())) work.computeIfPresent(e.getWork(), (k, v) -> v + 1);
                else work.put(e.getWork(), 1);

                if (education.containsKey(e.getEducation())) education.computeIfPresent(e.getEducation(), (k, v) -> v + 1);
                else education.put(e.getEducation(), 1);

                if (mobOS.containsKey(e.getMobileOS())) mobOS.computeIfPresent(e.getMobileOS(), (k, v) -> v + 1);
                else mobOS.put(e.getMobileOS(), 1);

                for (String cOS : e.getCompOS()) {
                    if (compOS.containsKey(cOS)) compOS.computeIfPresent(cOS, (k, v) -> v + 1);
                    else compOS.put(cOS, 1);
                }

                if (tildesAccount.containsKey(e.getTildesAccount())) tildesAccount.computeIfPresent(e.getTildesAccount(), (k, v) -> v + 1);
                else tildesAccount.put(e.getTildesAccount(), 1);

                if (tildesAccess.containsKey(e.getTildesAccess())) tildesAccess.computeIfPresent(e.getTildesAccess(), (k, v) -> v + 1);
                else tildesAccess.put(e.getTildesAccess(), 1);

                if (tildesAccessAmount.containsKey(e.getTildesAccessAmount())) tildesAccessAmount.computeIfPresent(e.getTildesAccessAmount(), (k, v) -> v + 1);
                else tildesAccessAmount.put(e.getTildesAccessAmount(), 1);

                likeTildes.add(e.getLikeTildes());
                dislikeTildes.add(e.getDislikeTildes());
                changeTildes.add(e.getChangeTildes());
            }

                for (String s : changeTildes){
                    System.out.println(s);
                }
            String[] StringFiles = {
                    "src/data/aggregated/country.csv",
                    "src/data/aggregated/gender.csv",
                    "src/data/aggregated/sexuality.csv",
                    "src/data/aggregated/religion.csv",
                    "src/data/aggregated/language.csv",
                    "src/data/aggregated/work.csv",
                    "src/data/aggregated/education.csv",
                    "src/data/aggregated/mobileOS.csv",
                    "src/data/aggregated/compOS.csv",
                    "src/data/aggregated/tildesAccess.csv",
                    "src/data/aggregated/tildesAccessAmount.csv",
            };

            String[] booleanFiles = {
                    "src/data/aggregated/trans.csv",
                    "src/data/aggregated/tildesAccount.csv",
            };

            ArrayList<HashMap<String, Integer>> stringData = new ArrayList<>();
            stringData.add(countries);
            stringData.add(gender);
            stringData.add(sexuality);
            stringData.add(religion);
            stringData.add(languages);
            stringData.add(work);
            stringData.add(education);
            stringData.add(mobOS);
            stringData.add(compOS);
            stringData.add(tildesAccess);
            stringData.add(tildesAccessAmount);

            ArrayList<HashMap<Boolean, Integer>> booleanData = new ArrayList<>();
            booleanData.add(trans);
            booleanData.add(tildesAccount);

            System.out.println("Average Economy: " + round((double) avgEcon / (beans.size() - noPolitics), 2));
            System.out.println("Average Diplomacy: " + round((double) avgDipl / (beans.size() - noPolitics), 2));
            System.out.println("Average State: " + round((double) avgStat / (beans.size() - noPolitics), 2));
            System.out.println("Average Society: " + round((double) avgSoci / (beans.size() - noPolitics), 2));

            //Printing aggregated data into a new CSV files.

            for (int i = 0; i < StringFiles.length; i++) {
                printStringToCSV(StringFiles[i], stringData.get(i));
            }

            for (int i = 0; i < booleanFiles.length; i++) {
                printBooleanToCSV(booleanFiles[i], booleanData.get(i));
            }

            printIntToCSV("src/data/aggregated/age.csv", age);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //Thanks, Stack Overflow.
    public static double round(double value, int places) {
        if (places < 0) throw new IllegalArgumentException();

        BigDecimal bd = BigDecimal.valueOf(value);
        bd = bd.setScale(places, RoundingMode.HALF_UP);
        return bd.doubleValue();
    }

    public static void printStringToCSV(String filePath, HashMap<String, Integer> data) throws IOException {
        CSVWriter writer = new CSVWriter(new FileWriter(filePath));

        String[] header = new String[data.keySet().size()];
        Integer[] values = new Integer[data.values().size()];
        String[] valuesStr = new String[values.length];

        data.keySet().toArray(header);
        data.values().toArray(values);

        for (int j = 0; j < values.length; j++) {
            valuesStr[j] = String.valueOf(values[j]);
        }

        writer.writeNext(header);
        writer.writeNext(valuesStr, false);
        writer.close();
    }

    public static void printIntToCSV(String filepath, HashMap<Integer, Integer> data) throws IOException {
        CSVWriter writer = new CSVWriter(new FileWriter(filepath));

        Integer[] header = new Integer[data.keySet().size()];
        String[] headerStr = new String[header.length];
        Integer[] values = new Integer[data.values().size()];
        String[] valuesStr = new String[values.length];

        data.keySet().toArray(header);
        data.values().toArray(values);

        for (int i = 0; i < values.length; i++) {
            headerStr[i] = String.valueOf(header[i]);
            valuesStr[i] = String.valueOf(values[i]);
        }
        writer.writeNext(headerStr);
        writer.writeNext(valuesStr, false);
        writer.close();
    }

    public static void printBooleanToCSV(String filepath, HashMap<Boolean, Integer> data) throws IOException {
        CSVWriter writer = new CSVWriter(new FileWriter(filepath));

        Boolean[] header = new Boolean[data.keySet().size()];
        String[] headerStr = new String[header.length];
        Integer[] values = new Integer[data.values().size()];
        String[] valuesStr = new String[values.length];

        data.keySet().toArray(header);
        data.values().toArray(values);

        for (int i = 0; i < values.length; i++) {
            valuesStr[i] = String.valueOf(values[i]);
            headerStr[i] = String.valueOf(header[i]);
        }

        writer.writeNext(headerStr);
        writer.writeNext(valuesStr, false);
        writer.close();
    }

}