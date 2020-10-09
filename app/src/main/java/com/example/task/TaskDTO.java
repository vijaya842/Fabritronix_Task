package com.example.task;

public class TaskDTO {
    private String link;
    private String state;
    private String type;
    private String name ;
    private String label   ;



    public TaskDTO(String link, String state, String type, String name, String label) {
        this.link = link;
        this.state = state;
        this.type = type;
        this.name = name;
        this.label = label;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public void setState(String state) {
        this.state = state;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public String getLabel() {
        return label;
    }

    public String getLink() {
        return link;
    }

    public String getState() {
        return state;
    }

    public String getType() {
        return type;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setLabel(String label) {
        this.label = label;
    }
}
