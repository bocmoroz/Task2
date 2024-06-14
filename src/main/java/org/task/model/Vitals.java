package org.task.model;

public class Vitals {

    private Long bloodPressureDiastole;
    private Long bloodPressureSystole;
    private Long pulse;
    private Long breathingRate;
    private Float bodyTemperature;

    public Long getBloodPressureDiastole() {
        return bloodPressureDiastole;
    }

    public void setBloodPressureDiastole(Long bloodPressureDiastole) {
        this.bloodPressureDiastole = bloodPressureDiastole;
    }

    public Long getBloodPressureSystole() {
        return bloodPressureSystole;
    }

    public void setBloodPressureSystole(Long bloodPressureSystole) {
        this.bloodPressureSystole = bloodPressureSystole;
    }

    public Long getPulse() {
        return pulse;
    }

    public void setPulse(Long pulse) {
        this.pulse = pulse;
    }

    public Long getBreathingRate() {
        return breathingRate;
    }

    public void setBreathingRate(Long breathingRate) {
        this.breathingRate = breathingRate;
    }

    public Float getBodyTemperature() {
        return bodyTemperature;
    }

    public void setBodyTemperature(Float bodyTemperature) {
        this.bodyTemperature = bodyTemperature;
    }
}
