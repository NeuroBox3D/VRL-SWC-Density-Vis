/// package's name
package edu.gcsc.vrl.swcdensityvis;

/// imports
import eu.mihosoft.vrl.reflection.Pair;

/**
 * @brief cuboid utilities
 * @author stephan
 */
public final class CuboidUtility {
	/**
	 * @brief private ctor for utility pattern
	 */
	private CuboidUtility() {
		
	};
 
	/**
	 * @brief get index of sampling cube within the bounding box 
	 * @param bounding
	 * @param sample
	 * @param step_x
	 * @param step_y
	 * @param step_z
	 * @return 
	 */
	public static int[] getCuboidId(Cuboid bounding, Cuboid sample, float step_x, float step_y, float step_z) {
		return new int[]
		{
			(int) Math.abs((bounding.getX() + sample.getX() * step_x)),
			(int) Math.abs((bounding.getY() + sample.getY() * step_y)),
			(int) Math.abs((bounding.getZ() + sample.getZ() * step_z))
		};

	}
	
	/**
	 * @brief get cuboid by id 
	 * @todo implement
	 * 
	 * @param bounding
	 * @param id
	 * @param step_x
	 * @param step_y
	 * @param step_z
	 * @return 
	 */
	public static Cuboid getCuboidbyId(Cuboid bounding, int[] id, float step_x, float step_y, float step_z) {
		return new Cuboid(id[0], id[1], id[2], step_x, step_y, step_z);
	}
	
	
	/**
	 * @brief get bounding indices of of sample cube;
	 * with this indices we can iterate over the whole geometry
	 * bounding in a sparse sense...
	 * 
	 * @param bounding
	 * @param min
	 * @param max
	 * @param step_x
	 * @param step_y
	 * @param step_z
	 * @return 
	 */
	public static Pair<int[], int[]> getSampleCuboidBounding(Cuboid bounding, Cuboid min, Cuboid max, float step_x, float step_y, float step_z) {
		int[] lo = getCuboidId(bounding, new Cuboid(min.getX()-step_x, min.getY()-step_y, min.getZ()-step_z, min.getWidth()-step_x, min.getY()-step_y, min.getZ()-step_z), step_x, step_y, step_z);
		int[] hi = getCuboidId(bounding, new Cuboid(max.getX()+step_x, max.getY()+step_y, max.getZ()+step_z, max.getWidth()+step_x, max.getY()+step_y, max.getZ()+step_z), step_x, step_y, step_z);
		return new Pair<int[], int[]>(lo, hi);
	}
}
