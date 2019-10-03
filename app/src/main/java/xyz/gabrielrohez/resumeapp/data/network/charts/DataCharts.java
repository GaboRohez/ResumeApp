package xyz.gabrielrohez.resumeapp.data.network.charts;

public class DataCharts {
    private String name;
    private float value;

    public DataCharts(String name, float value) {
        this.name = name;
        this.value = value;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }
}
