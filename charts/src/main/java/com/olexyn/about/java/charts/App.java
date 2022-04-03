package com.olexyn.about.java.charts;


import org.knowm.xchart.BitmapEncoder;
import org.knowm.xchart.QuickChart;
import org.knowm.xchart.SwingWrapper;
import org.knowm.xchart.XYChart;
import org.knowm.xchart.XYChartBuilder;
import org.knowm.xchart.XYSeries;
import org.knowm.xchart.style.Styler;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import java.awt.BorderLayout;
import java.io.IOException;


public class App {


    public static void main(String[] args) throws IOException {

        int points = 30;

        double[] xData = new double[points];
        double[] yData = new double[points];



        for (int i = 0; i < points ; i++) {


                xData[i] = i;
                yData[i] = i;

        }



        // Create Chart
        XYChart chart = QuickChart.getChart("Sample Chart", "X", "Y", "y(x)", xData, yData);





        // Show it
        new SwingWrapper(chart).displayChart();

        // Save it
        BitmapEncoder.saveBitmap(chart, "./Sample_Chart", BitmapEncoder.BitmapFormat.PNG);

        // or save it in high-res
        BitmapEncoder.saveBitmapWithDPI(chart, "./Sample_Chart_300_DPI", BitmapEncoder.BitmapFormat.PNG, 300);

        //XYChart exampleChart = new XYChart();
        XYChart chart2 = getChart();
        new SwingWrapper<XYChart>(chart).displayChart();


    }


    public static XYChart getChart() {

        // Create Chart
        XYChart chart = new XYChartBuilder().width(800).height(600).title(App.class.getSimpleName()).xAxisTitle("X").yAxisTitle("Y").build();

        // Customize Chart
        chart.getStyler().setLegendPosition(Styler.LegendPosition.InsideNE);
        chart.getStyler().setAxisTitlesVisible(false);
        chart.getStyler().setDefaultSeriesRenderStyle(XYSeries.XYSeriesRenderStyle.Area);

        // Series
        chart.addSeries("a", new double[]{0, 3, 5, 7, 9}, new double[]{-3, 5, 9, 6, 5});
        chart.addSeries("b", new double[]{0, 2, 4, 6, 9}, new double[]{-1, 6, 4, 0, 4});
        chart.addSeries("c", new double[]{0, 1, 3, 8, 9}, new double[]{-2, -1, 1, 0, 1});

        return chart;
    }
}

