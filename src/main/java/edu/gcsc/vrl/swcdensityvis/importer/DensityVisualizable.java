/// package's name
package edu.gcsc.vrl.swcdensityvis.importer;

/// imports
import eu.mihosoft.vrl.v3d.Shape3DArray;

/**
 * @brief density visualizable interface
 * @author stephan
 *
 * @note use an abstract factory to be more flexible in the end
 * @note each implementation can make use of the utility class, and also of the
 * density util and distance util
 * @note for computing the Density and DensityAlternative we use a strategy
 * pattern
 */
public interface DensityVisualizable extends DensityComputationStrategy {

	void parse();

	void parseStack();

	Shape3DArray calculateGeometry();

	void setContext(DensityComputationContext context);
}
