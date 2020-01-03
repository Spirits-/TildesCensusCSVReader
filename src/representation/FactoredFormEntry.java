package representation;

import java.util.Arrays;

public class FactoredFormEntry {

    private String country;
    private int age;
    private String gender;
    private Boolean trans;
    private String sexuality;
    private String religion;
    private String[] language;
    private int[] politics;
    private String work;
    private String education;
    private String mobileOS;
    private String[] compOS;
    private Boolean tildesAccount;
    private String tildesAccess;
    private String tildesAccessAmount;
    private String likeTildes;
    private String dislikeTildes;
    private String changeTildes;

    public String getLikeTildes() {
        return likeTildes;
    }

    public String getDislikeTildes() {
        return dislikeTildes;
    }

    public String getChangeTildes() {
        return changeTildes;
    }

    public String getCountry() {
        return country;
    }

    public int getAge() {
        return age;
    }

    public String getGender() {
        return gender;
    }

    public Boolean getTrans() {
        return trans;
    }

    public String getSexuality() {
        return sexuality;
    }

    public String getReligion() {
        return religion;
    }

    public String[] getLanguage() {
        return language;
    }

    public int[] getPolitics() {
        return politics;
    }

    public String getWork() {
        return work;
    }

    public String getEducation() {
        return education;
    }

    public String getMobileOS() {
        return mobileOS;
    }

    public String[] getCompOS() {
        return compOS;
    }

    public Boolean getTildesAccount() {
        return tildesAccount;
    }

    public String getTildesAccess() {
        return tildesAccess;
    }

    public String getTildesAccessAmount() {
        return tildesAccessAmount;
    }


    @Override
    public String toString() {
        return "FactoredFormEntry{" +
                "country='" + country + '\'' +
                ", age=" + age +
                ", gender='" + gender + '\'' +
                ", trans=" + trans +
                ", sexuality='" + sexuality + '\'' +
                ", religion='" + religion + '\'' +
                ", language=" + Arrays.toString(language) +
                ", politics=" + Arrays.toString(politics) +
                ", work='" + work + '\'' +
                ", education='" + education + '\'' +
                ", mobileOS='" + mobileOS + '\'' +
                ", compOS=" + Arrays.toString(compOS) +
                ", tildesAccount=" + tildesAccount +
                ", tildesAccess='" + tildesAccess + '\'' +
                ", tildesAccessAmount='" + tildesAccessAmount + '\'' +
                ", likeTildes='" + likeTildes + '\'' +
                ", dislikeTildes='" + dislikeTildes + '\'' +
                ", changeTildes='" + changeTildes + '\'' +
                '}';
    }

    public FactoredFormEntry(RawFormEntry e){
        this.country = e.getCountry();

        if(!e.getAge().equals("")) this.age = Integer.parseInt(e.getAge());
        else this.age = -1;

        this.gender = e.getGender();

        String trans = e.getTrans();
        switch (trans) {
            case "Yes":
                this.trans = true;
                break;
            case "No":
                this.trans = false;
                break;
            default:
                this.trans = null;
                break;
        }

        this.sexuality = e.getSexuality();
        this.religion = e.getReligion();
        this.language = e.getLanguage().split(";");
        Arrays.setAll(language, i -> language[i].trim());

        //0 = economy, 1 = diplomacy, 2 = state, 3 = society; no answer -> -1
        this.politics = new int[4];
        String econ = e.getEconomy(), dipl = e.getDiplomacy(),
        stat = e.getState(), soci = e.getSociety();

        if(!econ.equals("")) politics[0] = Integer.parseInt(econ);
        else politics[0] = -1;
        if(!dipl.equals("")) politics[1] = Integer.parseInt(dipl);
        else politics[1] = -1;
        if(!stat.equals("")) politics[2] = Integer.parseInt(stat);
        else politics[2] = -1;
        if(!soci.equals("")) politics[3] = Integer.parseInt(soci);
        else politics[3] = -1;

        this.work = e.getWork();
        this.education = e.getEducation();
        this.mobileOS = e.getMobileOS();
        this.compOS = e.getComputerOS().split(";");

        String tildAcc = e.getTildesAccount();
        if(tildAcc.equals("Yes")) this.tildesAccount = true;
        else if(tildAcc.equals("No")) this.tildesAccount = false;
        else this.tildesAccount = null;

        this.tildesAccess = e.getTildesAccess();
        this.tildesAccessAmount = e.getTildesAccessAmount();
        this.likeTildes = e.getLikeTildes();
        this.dislikeTildes = e.getDislikeTildes();
        this.changeTildes = e.getChangeTildes();
    }
}