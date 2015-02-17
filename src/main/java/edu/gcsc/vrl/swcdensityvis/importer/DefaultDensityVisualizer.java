/// package's name
package edu.gcsc.vrl.swcdensityvis.importer;

import edu.gcsc.vrl.densityvis.Density;
import eu.mihosoft.vrl.v3d.Shape3DArray;

/**
 * @brief provide default density vizualizer implementation
 *        other classes can make use of this and delegate to this implementation
 *        (see for instance XMLDensityVisualizer)
 * @author stephan
 */
public class DefaultDensityVisualizer implements DensityVisualizable {
	private DensityComputationContext context = new DensityComputationContext(new DefaultDensityComputation());

	@Override
	public void parse() {
		throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
	}

	@Override
	public void parseStack() {
		throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
	}

	@Override
	public void getDimension() {
		throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
	}

	@Override
	public void getBoundingBox() {
		throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
	}

	@Override
	public Density computeDensity() {
		return context.executeDensityComputation();
	}

	@Override
	public Shape3DArray calculateGeometry() {
		throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
	}


	@Override
	public void setContext(DensityComputationContext context) {
		this.context = context;
	}

}
