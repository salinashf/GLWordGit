package com.example.rubikcubeanimationexample;

import android.util.Log;
import java.nio.ShortBuffer;
import java.util.ArrayList;

/**
 * @author SalinasHFX
 *
 */
public class GLFace {

	/**
	 * Elemento mVertexListde tipo ArrayList<GLVertex> contiene todo los vertices del cubo 8 vertices 
	 */
	private ArrayList<GLVertex> mVertexList = new ArrayList<GLVertex>();
	/**
	 * Elemento mColorde tipo GLColor determina el color de la cara del cubo  
	 */
	private GLColor mColor;

	public GLFace() {

	}

	// for triangles
	public GLFace(GLVertex v1, GLVertex v2, GLVertex v3) {
		addVertex(v1);
		addVertex(v2);
		addVertex(v3);
	}

	// for quadrilaterals
	public GLFace(GLVertex v1, GLVertex v2, GLVertex v3, GLVertex v4) {
		addVertex(v1);
		addVertex(v2);
		addVertex(v3);
		addVertex(v4);
	}

	public void addVertex(GLVertex v) {
		mVertexList.add(v);
	}

	// must be called after all vertices are added
	public void setColor(GLColor c) {

		int last = mVertexList.size() - 1;
		if (last < 2) {
			Log.e("GLFace", "not enough vertices in setColor()");
		} else {
			GLVertex vertex = mVertexList.get(last);

			// only need to do this if the color has never been set
			if (mColor == null) {
				while (vertex.color != null) {
					mVertexList.add(0, vertex);
					mVertexList.remove(last + 1);
					vertex = mVertexList.get(last);
				}
			}

			vertex.color = c;
		}
		mColor = c;
	}

	public int getIndexCount() {
		return (mVertexList.size() - 2) * 3;
	}

	public void putIndices(ShortBuffer buffer) {
		int last = mVertexList.size() - 1;
		GLVertex v0 = mVertexList.get(0);
		GLVertex vn = mVertexList.get(last);

		// push triangles into the buffer
		for (int i = 1; i < last; i++) {
			GLVertex v1 = mVertexList.get(i);
			buffer.put(v0.index);
			buffer.put(v1.index);
			buffer.put(vn.index);
			v0 = v1;
		}
	}

}