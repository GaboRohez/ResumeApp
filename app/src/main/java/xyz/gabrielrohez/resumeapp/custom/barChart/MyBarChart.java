package xyz.gabrielrohez.resumeapp.custom.barChart;

import android.content.Context;
import android.util.Log;

import androidx.core.content.ContextCompat;
import androidx.core.content.res.ResourcesCompat;

import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.components.Legend;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.components.YAxis;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.formatter.ValueFormatter;
import com.github.mikephil.charting.interfaces.datasets.IBarDataSet;

import java.util.ArrayList;
import java.util.List;

import xyz.gabrielrohez.resumeapp.R;
import xyz.gabrielrohez.resumeapp.data.model.DataCharts;

public class MyBarChart {

    private BarChart chart;
    private Context context;
    private List<DataCharts> list;

    public MyBarChart(BarChart chart, Context context, List<DataCharts> list) {
        this.chart = chart;
        this.context = context;
        this.list = list;
    }

    public void showBarChart(){
        Log.i("MyBarChart", "The BarChar is showing");
        configChart();
    }

    private void configChart() {
        chart.setDrawBarShadow(false);
        chart.setDrawValueAboveBar(true);

        chart.getDescription().setEnabled(false);

        // if more than 60 entries are displayed in the chart, no values will be
        // drawn
        chart.setMaxVisibleValueCount(60);

        // scaling can now only be done on x- and y-axis separately
        chart.setPinchZoom(false);

        chart.setDrawGridBackground(false);
        // chart.setDrawYLabels(false);
        //chart.getXAxis().setDrawLabels(false);  //// hide labels bottom

        ValueFormatter xAxisFormatter = new AxisValueFormatter(chart, list); // formater to x

        XAxis xAxis = chart.getXAxis();
        xAxis.setPosition(XAxis.XAxisPosition.BOTTOM);
        xAxis.setTypeface(ResourcesCompat.getFont(context, R.font.work_sans));
        xAxis.setDrawGridLines(false);
        xAxis.setGranularity(1f); // only intervals of 1 day
        xAxis.setLabelCount(7);
        xAxis.setValueFormatter(xAxisFormatter);

        //ValueFormatter custom = new MyValueFormatter("$");    // sufix in y
        ValueFormatter custom = new MyValueFormatter("");       //formater to y

        YAxis leftAxis = chart.getAxisLeft();
        leftAxis.setTypeface(ResourcesCompat.getFont(context, R.font.work_sans));
        //leftAxis.setLabelCount(5, true);
        leftAxis.setValueFormatter(custom);
        leftAxis.setPosition(YAxis.YAxisLabelPosition.OUTSIDE_CHART);
        leftAxis.setSpaceTop(15f);
        leftAxis.setAxisMaximum(4.0f); //  value max in leftAxis
        leftAxis.setAxisMinimum(0.0f); //  value min in leftAxis
        leftAxis.setAxisMinimum(0f); // this replaces setStartAtZero(true)
        leftAxis.setGranularityEnabled(true); //  Force leftAxis to always display integers

        /*YAxis rightAxis = chart.getAxisRight();
        rightAxis.setDrawGridLines(false);
        rightAxis.setTypeface(ResourcesCompat.getFont(context, R.font.work_sans));
        rightAxis.setLabelCount(8, false);
        rightAxis.setValueFormatter(custom);
        rightAxis.setSpaceTop(15f);
        rightAxis.setAxisMinimum(0f); // this replaces setStartAtZero(true)
        */

        //  hide data in right
        YAxis rightAxis = chart.getAxisRight();
        rightAxis.setDrawAxisLine(false);
        rightAxis.setDrawGridLines(false);
        rightAxis.setDrawLabels(false);

        /*Legend l = chart.getLegend();
        l.setVerticalAlignment(Legend.LegendVerticalAlignment.BOTTOM);
        l.setHorizontalAlignment(Legend.LegendHorizontalAlignment.LEFT);
        l.setOrientation(Legend.LegendOrientation.HORIZONTAL);
        l.setDrawInside(false);
        l.setForm(Legend.LegendForm.SQUARE);
        l.setFormSize(9f);
        l.setTextSize(11f);
        l.setXEntrySpace(4f);
        l.setEnabled(true);*/       //legend below chart
        Legend l = chart.getLegend();
        l.setEnabled(false);

        // chart.setDrawLegend(false);
        setData();
    }

    private void setData() {

        ArrayList<BarEntry> entries = new ArrayList<>();

        for (int i = 0; i<list.size(); i++){
            entries.add(new BarEntry(i+1, list.get(i).getValue()));
        }

        //***************************************************

        BarDataSet set1;

        set1 = new BarDataSet(entries, "");
        set1.setDrawIcons(false);
//            set1.setColors(ColorTemplate.MATERIAL_COLORS);

        /*int startColor = ContextCompat.getColor(this, android.R.color.holo_blue_dark);
        int endColor = ContextCompat.getColor(this, android.R.color.holo_blue_bright);
        set1.setGradientColor(startColor, endColor);*/
        List<Integer> colors = new ArrayList<>();
        colors.add(ContextCompat.getColor(context, android.R.color.holo_orange_light));
        colors.add(ContextCompat.getColor(context, android.R.color.holo_blue_light));
        colors.add(ContextCompat.getColor(context, android.R.color.holo_green_light));
        colors.add(ContextCompat.getColor(context, android.R.color.holo_red_light));
        colors.add(ContextCompat.getColor(context, android.R.color.holo_purple));

        set1.setColors(colors);

        ArrayList<IBarDataSet> dataSets = new ArrayList<>();
        dataSets.add(set1);

        BarData data = new BarData(dataSets);
        data.setValueTextSize(10f);
        data.setValueTypeface(ResourcesCompat.getFont(context, R.font.work_sans));
        data.setBarWidth(0.9f);
        data.setDrawValues(false);  //hide labels in top of chart

        /*data.setValueFormatter(new MyValueFormatter("") {
            @Override
            public String getFormattedValue(float value, Entry entry, int dataSetIndex, ViewPortHandler viewPortHandler) {
                return barName[(int) entry.getX()];
            }
        });*/
        chart.setData(data);
    }
}
