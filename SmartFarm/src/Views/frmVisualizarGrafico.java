package Views;

import java.awt.Dimension;
import javax.swing.JFrame;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PiePlot3D;
import org.jfree.data.general.PieDataset;
import org.jfree.util.Rotation;

public class frmVisualizarGrafico extends JFrame {

    public frmVisualizarGrafico(String applicationTitle, String chartTitle, PieDataset pDataSet) {

        super(applicationTitle);
        JFreeChart graficoPizza3D = createChart(pDataSet, chartTitle);       
        ChartPanel painelParaOGrafico = new ChartPanel(graficoPizza3D);       
        painelParaOGrafico.setPreferredSize(new Dimension(650, 450));
        setLocation(new java.awt.Point(350, 140));
        setResizable(false);    
        this.add(painelParaOGrafico);
    }

    private JFreeChart createChart(PieDataset pPieDataset, String pTituloGrafico) {

        JFreeChart grafico = ChartFactory.createPieChart3D(
                pTituloGrafico,
                pPieDataset,
                true,
                true,
                false
        );       
        PiePlot3D plot = (PiePlot3D) grafico.getPlot();      
        plot.setForegroundAlpha(0.7f);       
        plot.setStartAngle(0);      
        plot.setDirection(Rotation.CLOCKWISE);       
        return grafico;
    }
}
