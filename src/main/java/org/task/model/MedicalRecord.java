package org.task.model;

public class MedicalRecord {

    private Long id;
    private Long timestamp;
    private Diagnosis diagnosis;
    private Vitals vitals;
    private Doctor doctor;
    private Long userId;
    private String userName;
    private String userDob;
    private Meta meta;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Long timestamp) {
        this.timestamp = timestamp;
    }

    public Diagnosis getDiagnosis() {
        return diagnosis;
    }

    public void setDiagnosis(Diagnosis diagnosis) {
        this.diagnosis = diagnosis;
    }

    public Vitals getVitals() {
        return vitals;
    }

    public void setVitals(Vitals vitals) {
        this.vitals = vitals;
    }

    public Doctor getDoctor() {
        return doctor;
    }

    public void setDoctor(Doctor doctor) {
        this.doctor = doctor;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserDob() {
        return userDob;
    }

    public void setUserDob(String userDob) {
        this.userDob = userDob;
    }

    public Meta getMeta() {
        return meta;
    }

    public void setMeta(Meta meta) {
        this.meta = meta;
    }
}
