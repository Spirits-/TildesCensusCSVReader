package representation;

import com.opencsv.bean.CsvBindByName;

public class RawFormEntry {

    @CsvBindByName(column = "Country")
    private String country;

    @CsvBindByName(column = "What's your age?")
    private String age;

    @CsvBindByName(column = "What's your gender?")
    private String gender;

    @CsvBindByName(column = "Are you transgender?")
    private String trans;

    @CsvBindByName(column = "How do you define your sexuality?")
    private String sexuality;

    @CsvBindByName(column = "Are you religious, if yes, what religion are you a part of?")
    private String religion;

    @CsvBindByName(column = "Aside of English, what languages do you speak?")
    private String language;

    @CsvBindByName(column = "Economy")
    private String economy;

    @CsvBindByName(column = "Diplomacy")
    private String diplomacy;

    @CsvBindByName(column = "State")
    private String state;

    @CsvBindByName(column = "Society")
    private String society;

    @CsvBindByName(column = "What's your current field of work? (According to this list: https://www.recruiter.com/careers/ )")
    private String work;

    @CsvBindByName(column = "What's your highest reached educational level (Or currently in progress)?")
    private String education;

    @CsvBindByName(column = "What mobile Operating System do you use?")
    private String mobileOS;

    @CsvBindByName(column = "What Computer Operating System(s) do you use?")
    private String computerOS;

    @CsvBindByName(column = "Do you have a Tildes account?")
    private String tildesAccount;

    @CsvBindByName(column = "On what device do you access Tildes the most?")
    private String tildesAccess;

    @CsvBindByName(column = "How often do you access Tildes?")
    private String tildesAccessAmount;

    @CsvBindByName(column = "What do you LIKE most about Tildes?")
    private String likeTildes;

    @CsvBindByName(column = "What do you DISLIKE most about Tildes?")
    private String dislikeTildes;

    @CsvBindByName(column = "What would you change about Tildes?")
    private String changeTildes;

    public RawFormEntry() {}

    public RawFormEntry(String country, String age, String gender, String trans, String sexuality, String religion, String language, String economy, String diplomacy, String state, String society, String work, String education, String mobileOS, String computerOS, String tildesAccount, String tildesAccess, String tildesAccessAmount, String likeTildes, String dislikeTildes, String changeTildes) {
        this.country = country;
        this.age = age;
        this.gender = gender;
        this.trans = trans;
        this.sexuality = sexuality;
        this.religion = religion;
        this.language = language;
        this.economy = economy;
        this.diplomacy = diplomacy;
        this.state = state;
        this.society = society;
        this.work = work;
        this.education = education;
        this.mobileOS = mobileOS;
        this.computerOS = computerOS;
        this.tildesAccount = tildesAccount;
        this.tildesAccess = tildesAccess;
        this.tildesAccessAmount = tildesAccessAmount;
        this.likeTildes = likeTildes;
        this.dislikeTildes = dislikeTildes;
        this.changeTildes = changeTildes;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getTrans() {
        return trans;
    }

    public void setTrans(String trans) {
        this.trans = trans;
    }

    public String getSexuality() {
        return sexuality;
    }

    public void setSexuality(String sexuality) {
        this.sexuality = sexuality;
    }

    public String getReligion() {
        return religion;
    }

    public void setReligion(String religion) {
        this.religion = religion;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public String getEconomy() {
        return economy;
    }

    public void setEconomy(String economy) {
        this.economy = economy;
    }

    public String getDiplomacy() {
        return diplomacy;
    }

    public void setDiplomacy(String diplomacy) {
        this.diplomacy = diplomacy;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getSociety() {
        return society;
    }

    public void setSociety(String society) {
        this.society = society;
    }

    public String getWork() {
        return work;
    }

    public void setWork(String work) {
        this.work = work;
    }

    public String getEducation() {
        return education;
    }

    public void setEducation(String education) {
        this.education = education;
    }

    public String getMobileOS() {
        return mobileOS;
    }

    public void setMobileOS(String mobileOS) {
        this.mobileOS = mobileOS;
    }

    public String getComputerOS() {
        return computerOS;
    }

    public void setComputerOS(String computerOS) {
        this.computerOS = computerOS;
    }

    public String getTildesAccount() {
        return tildesAccount;
    }

    public void setTildesAccount(String tildesAccount) {
        this.tildesAccount = tildesAccount;
    }

    public String getTildesAccess() {
        return tildesAccess;
    }

    public void setTildesAccess(String tildesAccess) {
        this.tildesAccess = tildesAccess;
    }

    public String getTildesAccessAmount() {
        return tildesAccessAmount;
    }

    public void setTildesAccessAmount(String tildesAccessAmount) {
        this.tildesAccessAmount = tildesAccessAmount;
    }

    public String getLikeTildes() {
        return likeTildes;
    }

    public void setLikeTildes(String likeTildes) {
        this.likeTildes = likeTildes;
    }

    public String getDislikeTildes() {
        return dislikeTildes;
    }

    public void setDislikeTildes(String dislikeTildes) {
        this.dislikeTildes = dislikeTildes;
    }

    public String getChangeTildes() {
        return changeTildes;
    }

    public void setChangeTildes(String changeTildes) {
        this.changeTildes = changeTildes;
    }

    @Override
    public String toString() {
        return "FormRaw{" +
                "country='" + country + '\'' +
                ", age='" + age + '\'' +
                ", gender='" + gender + '\'' +
                ", trans='" + trans + '\'' +
                ", sexuality='" + sexuality + '\'' +
                ", religion='" + religion + '\'' +
                ", language='" + language + '\'' +
                ", economy='" + economy + '\'' +
                ", diplomacy='" + diplomacy + '\'' +
                ", state='" + state + '\'' +
                ", society='" + society + '\'' +
                ", work='" + work + '\'' +
                ", education='" + education + '\'' +
                ", mobileOS='" + mobileOS + '\'' +
                ", computerOS='" + computerOS + '\'' +
                ", tildesAccount='" + tildesAccount + '\'' +
                ", tildesAccess='" + tildesAccess + '\'' +
                ", tildesAccessAmount='" + tildesAccessAmount + '\'' +
                ", likeTildes='" + likeTildes + '\'' +
                ", dislikeTildes='" + dislikeTildes + '\'' +
                ", changeTildes='" + changeTildes + '\'' +
                '}';
    }
}
