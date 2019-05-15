package sample;

/**
 * @ClassName Position
 * @Author solstice
 * @Date 19/5/15 15:15
 * @Version 1.0.0
 * @Description
 **/
public class Position {

    private String city;
    private String state;
    private double latDegree;
    private double latMinute;
    private double longDegree;
    private double longMinute;

    public Position(){}


    public Position(String city, String state, double latDegree, double latMinute, double longDegree, double longMinute) {
        this.city = city;
        this.state = state;
        this.latDegree = latDegree;
        this.latMinute = latMinute;
        this.longDegree = longDegree;
        this.longMinute = longMinute;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public double getLatDegree() {
        return latDegree;
    }

    public void setLatDegree(double latDegree) {
        this.latDegree = latDegree;
    }

    public double getLatMinute() {
        return latMinute;
    }

    public void setLatMinute(double latMinute) {
        this.latMinute = latMinute;
    }

    public double getLongDegree() {
        return longDegree;
    }

    public void setLongDegree(double longDegree) {
        this.longDegree = longDegree;
    }

    public double getLongMinute() {
        return longMinute;
    }

    public void setLongMinute(double longMinute) {
        this.longMinute = longMinute;
    }

    @Override
    public String toString() {
        return "Position{" +
                "city='" + city + '\'' +
                ", state='" + state + '\'' +
                ", latDegree=" + latDegree +
                ", latMinute=" + latMinute +
                ", longDegree=" + longDegree +
                ", longMinute=" + longMinute +
                '}';
    }
}
