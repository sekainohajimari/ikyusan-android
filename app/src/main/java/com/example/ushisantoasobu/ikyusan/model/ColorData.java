package com.example.ushisantoasobu.ikyusan.model;

import java.io.Serializable;

/**
 * Created by ushisantoasobu on 15/09/05.
 */
public class ColorData implements Serializable {

    private static final long serialVersionUID = 1L;

    private int color_colde_id;

    public int getColorColdeId() {
        return color_colde_id;
    }

    public void setColorColdeId(int colorColdeId) {
        this.color_colde_id = colorColdeId;
    }
}
