/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author xuant
 */
public class EastAsiaCountries extends Country
        implements Comparable<EastAsiaCountries> {

    private String countryTerrain;

    public EastAsiaCountries(String countryCode,
            String countryName, float totalArea, String countryTerrain) {
        super(countryCode, countryName, totalArea);
        this.countryTerrain = countryTerrain;
    }

    public EastAsiaCountries() {

    }

    public String getCountryTerrain() {
        return countryTerrain;
    }

    public void setCountryTerrain(String countryTerrain) {
        this.countryTerrain = countryTerrain;
    }

    @Override
    public void display() {
        String areaFormat = ((this.getTotalArea() % 1.0f) == 0)
            ? "%-16.1f" //Display 1 zero after radix point if it is integer
            : "%-16.16s"; //Display full fraction
        System.out.printf("%-16.16s%-16.16s" + areaFormat + "%-16.16s\n\n",
                this.getCountryCode(),
                this.getCountryName(),
                this.getTotalArea(),
                this.getCountryTerrain());
    }

    @Override
    public int compareTo(EastAsiaCountries t) {
        return this.getCountryName().compareTo(t.getCountryName());
    }


}
