package edu.gcsc.vrl.swcdensityvis;

import edu.gcsc.vrl.swcdensityvis.ext.quickhull3d.Point3d;
import edu.gcsc.vrl.swcdensityvis.ext.quickhull3d.QuickHull3D;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import javax.vecmath.Vector3f;

/**
 * @brief computational utilities for density vis
 * @author stephan
 */
public final class CompUtility {
	private final static Vector3f ORIGO = new Vector3f(0, 0, 0);
	private final static Vector3f X_UNIT_VECTOR = new Vector3f(1, 0, 0);
	private final static Vector3f Y_UNIT_VECTOR = new Vector3f(0, 1, 0);
	private final static Vector3f Z_UNIT_VECTOR = new Vector3f(0, 0, 1);

	/**
	 * @brief private ctor
	 */
	private CompUtility() {
	}

	/**
	 * @brief gets all convex hulls in 3d for all files (cells)
	 * @param cells
	 * @return
	 */
	public static HashMap<String, QuickHull3D> hull(HashMap<String, ArrayList<SWCCompartmentInformation>> cells) {
		HashMap<String, ArrayList<Point3d>> points = new HashMap<String, ArrayList<Point3d>>();
		HashMap<String, QuickHull3D> hulls = new HashMap<String, QuickHull3D>();
		Iterator<Map.Entry<String, ArrayList<SWCCompartmentInformation>>> it = cells.entrySet().iterator();
		while (it.hasNext()) {
			Map.Entry<String, ArrayList<SWCCompartmentInformation>> entry = it.next();
			ArrayList<SWCCompartmentInformation> compartments = entry.getValue();
			String key = entry.getKey();
			for (SWCCompartmentInformation point : compartments) {
				points.get(key).add(new Point3d(point.getCoordinates().x, point.getCoordinates().y, point.getCoordinates().z));
			}
		}
		Iterator<Map.Entry<String, ArrayList<Point3d>>> it2 = points.entrySet().iterator();
		while (it2.hasNext()) {
			QuickHull3D hull = new QuickHull3D();
			Map.Entry<String, ArrayList<Point3d>> entry = it2.next();
			String key = entry.getKey();
			Point3d[] values = (Point3d[]) entry.getValue().toArray();
			hull.build(values);
			hulls.put(key, hull);
		}
		return hulls;
	}
	
	/**
	 * @brief projects a point q to the plane defined by n and p
	 * @param q - initial point
	 * @param n - normal of the plane (can be non-normalized)
	 * @param p - point within the plane
	 * @return 
	 */
	public static Vector3f projectToPlane(Vector3f q, Vector3f n, Vector3f p) {
		n.normalize();
		Vector3f d = new Vector3f(q);
		d.sub(p);
		n.scale(n.dot(d));
		Vector3f qPrime = new Vector3f(q);
		qPrime.sub(n);
		return qPrime;
	}
	
	/**
	 * @brief projects to xy-plane
	 * @param q
	 * @return 
	 */
	public static Vector3f projectToXYPlane(Vector3f q) {
		return projectToPlane(q, Z_UNIT_VECTOR, ORIGO);
	}

	/**
	 * @brief projects to xz-plane
	 * @param q
	 * @return 
	 */
	public static Vector3f projectToXZPlane(Vector3f q) {
		return projectToPlane(q, Y_UNIT_VECTOR, ORIGO);
	}
	
	/**
	 * @brief proejcts to yz-plane
	 * @param q
	 * @return 
	 */
	public static Vector3f projectToYZPlane(Vector3f q) {
		return projectToPlane(q, X_UNIT_VECTOR, ORIGO);
	}
	
	
	/**
	 * @brief main for some tests
	 * @param args 
	 */
	public static void main(String... args) {
		Vector3f q = new Vector3f(1, 2, 10);
		Vector3f p = new Vector3f(0, 0, 0);
		Vector3f a = new Vector3f(0, 10, 0);
		Vector3f b = new Vector3f(10, 0, 0);
		Vector3f n = new Vector3f();
		n.cross(a, b);
		System.err.println("n:= " + n);
		System.err.println("p:= " + p);
		System.err.println("q:= " + q);
		
		System.err.println("q':= " + projectToPlane(q, n, p));
	}
}
