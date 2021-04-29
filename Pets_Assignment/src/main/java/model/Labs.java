package model;

public class Labs {

    private int labId;
    private String labName;
    private int tribbleId;

    public Labs() {
    }

    public Labs(int labId, String labName, int tribbleId) {
        this.labId = labId;
        this.labName = labName;
        this.tribbleId = tribbleId;
    }

    public Labs(String labName, int tribbleId) {
        this.labName = labName;
        this.tribbleId = tribbleId;
    }

    public Labs(String labName) {
        this.labName = labName;
    }

    public int getLabId() {
        return labId;
    }

    public void setLabId(int labId) {
        this.labId = labId;
    }

    public String getLabName() {
        return labName;
    }

    public void setLabName(String labName) {
        this.labName = labName;
    }

    public int getTribbleId() {
        return tribbleId;
    }

    public void setTribbleId(int tribbleId) {
        this.tribbleId = tribbleId;
    }

    @Override
    public String toString() {
        return "Labs{" +
                "labName='" + labName + '\'' +
                ", tribbleId=" + tribbleId +
                '}';
    }
}
