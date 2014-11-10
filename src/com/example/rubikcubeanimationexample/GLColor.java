package com.example.rubikcubeanimationexample;

/**
 * @author SalinasHFX
 *Determina el color de cada cara del cubo 
 */
public class GLColor {
    public final int red;
    public final int green;
    public final int blue;
    public final int alpha;
    /**
     * @param red
     * @param green
     * @param blue
     * @param alpha
     */
    public GLColor(int red, int green, int blue, int alpha) {
        this.red = red;
        this.green = green;
        this.blue = blue;
        this.alpha = alpha;
    }
    
    /**
     * @param red
     * @param green
     * @param blue
     */
    public GLColor(int red, int green, int blue) {
        this.red = red;
        this.green = green;
        this.blue = blue;
        this.alpha = 0x10000;
        
    }
    /* (non-Javadoc)
     * @see java.lang.Object#equals(java.lang.Object)
     */
    @Override
    public boolean equals(Object other) {
        if (other instanceof GLColor) {
            GLColor color = (GLColor)other;
            return (red == color.red &&
                    green == color.green &&
                    blue == color.blue &&
                    alpha == color.alpha);
        }
        return false;
    }
}