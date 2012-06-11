package org.gpsanonymity.tests;

import org.junit.Test;

import com.panayotis.gnuplot.JavaPlot;
import com.panayotis.gnuplot.layout.AutoGraphLayout;
import com.panayotis.gnuplot.layout.StripeLayout;
import com.panayotis.gnuplot.plot.AbstractPlot;
import com.panayotis.gnuplot.plot.DataSetPlot;
import com.panayotis.gnuplot.style.NamedPlotColor;
import com.panayotis.gnuplot.style.PlotStyle;
import com.panayotis.gnuplot.style.Style;
import com.panayotis.gnuplot.terminal.FileTerminal;
import com.panayotis.gnuplot.terminal.TextFileTerminal;
import com.panayotis.iodebug.Debug;

public class PlotTest {
	private static final String gnuplotpath = "/usr/bin/gnuplot";
	@Test
	public void generalTest(){
		defaultTerminal(gnuplotpath,"output/plotTest.dat");
	}
    private static JavaPlot defaultTerminal(String gnuplotpath, String outputPath) {
        JavaPlot p = new JavaPlot(gnuplotpath);
        JavaPlot.getDebugger().setLevel(Debug.VERBOSE);
        p.setTitle("Default Terminal Title");
        p.newGraph();
        p.addPlot("sin(x+2");
        p.addPlot("sin(x+1)");

        p.setMultiTitle("Global test title");
        AutoGraphLayout lo = new AutoGraphLayout();
        p.getPage().setLayout(lo);
        p.plot();
        return p;
    }
}
