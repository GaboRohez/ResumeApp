package xyz.gabrielrohez.resumeapp.custom.barChart;

import com.github.mikephil.charting.charts.BarLineChartBase;
import com.github.mikephil.charting.formatter.ValueFormatter;

import java.util.List;

import xyz.gabrielrohez.resumeapp.data.network.charts.DataCharts;

public class AxisValueFormatter extends ValueFormatter {

    private List<DataCharts> list;
    private final BarLineChartBase<?> chart;

    public AxisValueFormatter(BarLineChartBase<?> chart, List<DataCharts> list) {
        this.chart = chart;
        this.list = list;
    }

    @Override
    public String getFormattedValue(float value) {

            return list.get(Math.round(value)-1).getName();
    }
}


