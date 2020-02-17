package br.edu.univas.si7.lab7;

import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.ui.ApplicationFrame;
import org.jfree.ui.RefineryUtilities;

import br.edu.univas.si7.lab7.model.GraficoDeLinha;

public class Runner {

	public static void main(String[] args) {

		GraficoDeLinha chartBuilder = new GraficoDeLinha();

		//cria o gráfico
		JFreeChart chart = chartBuilder.createChart("Gráfico de Escolas");
		
		//salva a imagem do gráfico
		chartBuilder.saveToFile("target/gráficoDeLinha.jpeg", chart);

		//cria um painel
		ChartPanel chartPanel = new ChartPanel(chart);
		chartPanel.setPreferredSize(new java.awt.Dimension(560, 367));

		//cria uma janena
		ApplicationFrame frame = new ApplicationFrame("Gráfico Aula 10");
		frame.setContentPane(chartPanel);
		frame.pack();
		RefineryUtilities.centerFrameOnScreen(frame);
		frame.setVisible(true);
	}

}