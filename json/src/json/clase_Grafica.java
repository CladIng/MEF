package json;

import java.util.ArrayList;
import javax.swing.JFrame;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;

public class clase_Grafica extends JFrame{

public void Generar(String tl,ArrayList T){
    String tX = "-- CICLOS --";
    String tY = "-- FUERZA --";
        ArrayList<String> X = (ArrayList<String>) T.get(0);
        ArrayList<String> Y = (ArrayList<String>) T.get(1);
        XYSeriesCollection datos = new XYSeriesCollection();
        JFreeChart grafica = ChartFactory.createXYLineChart(tl, tX, tY, datos, PlotOrientation.VERTICAL, true, true, true);
        
        XYSeries s = new XYSeries("GRAFICA");
        int n = X.size();
	 for (int i = 0; i < n; i++) {
                      
            s.add(Double.parseDouble(X.get(i)),Double.parseDouble(Y.get(i)));
           
        }
        datos.addSeries(s);
        
        ChartPanel panel = new ChartPanel(grafica);
        this.setSize(600,600);
        this.add(panel);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setVisible(true);
       
    }
}

