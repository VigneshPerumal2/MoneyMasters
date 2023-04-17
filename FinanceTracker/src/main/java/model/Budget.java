package model;

public class Budget {

    private double food, socialLife, seldDevelopment, transportation, culture, household, apparel, beauty, health, education, gift, other, phone;

    public double getFood() {
        return food;
    }

    public double getSocialLife() {
        return socialLife;
    }

    public double getSeldDevelopment() {
        return seldDevelopment;
    }

    public double getTransportation() {
        return transportation;
    }

    public double getCulture() {
        return culture;
    }

    public double getHousehold() {
        return household;
    }

    public double getApparel() {
        return apparel;
    }

    public double getBeauty() {
        return beauty;
    }

    public double getHealth() {
        return health;
    }

    public double getEducation() {
        return education;
    }

    public double getGift() {
        return gift;
    }

    public double getOther() {
        return other;
    }

    public double getPhone() {
        return phone;
    }

    public void setFood(double food) {
        this.food = food;
    }

    public void setSocialLife(double socialLife) {
        this.socialLife = socialLife;
    }

    public void setSeldDevelopment(double seldDevelopment) {
        this.seldDevelopment = seldDevelopment;
    }

    public void setTransportation(double transportation) {
        this.transportation = transportation;
    }

    public void setCulture(double culture) {
        this.culture = culture;
    }

    public void setHousehold(double household) {
        this.household = household;
    }

    public void setApparel(double apparel) {
        this.apparel = apparel;
    }

    public void setBeauty(double beauty) {
        this.beauty = beauty;
    }

    public void setHealth(double health) {
        this.health = health;
    }

    public void setEducation(double education) {
        this.education = education;
    }

    public void setGift(double gift) {
        this.gift = gift;
    }

    public void setOther(double other) {
        this.other = other;
    }

    public void setPhone(double phone) {
        this.phone = phone;
    }

    public Budget(double food, double socialLife, double seldDevelopment, double transportation, double culture, double household, double apparel, double beauty, double health, double education, double gift, double other, double phone) {
        this.food = food;
        this.socialLife = socialLife;
        this.seldDevelopment = seldDevelopment;
        this.transportation = transportation;
        this.culture = culture;
        this.household = household;
        this.apparel = apparel;
        this.beauty = beauty;
        this.health = health;
        this.education = education;
        this.gift = gift;
        this.other = other;
        this.phone = phone;
    }

    public Budget() {
    }

    @Override
    public String toString() {
        return "Budget{" +
                "food=" + food +
                ", socialLife=" + socialLife +
                ", seldDevelopment=" + seldDevelopment +
                ", transportation=" + transportation +
                ", culture=" + culture +
                ", household=" + household +
                ", apparel=" + apparel +
                ", beauty=" + beauty +
                ", health=" + health +
                ", education=" + education +
                ", gift=" + gift +
                ", other=" + other +
                ", phone=" + phone +
                '}';
    }
}
