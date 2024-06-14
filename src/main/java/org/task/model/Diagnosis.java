package org.task.model;

public class Diagnosis {

    private Integer id;
    private String name;
    private Long severity;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getSeverity() {
        return severity;
    }

    public void setSeverity(Long severity) {
        this.severity = severity;
    }
}
