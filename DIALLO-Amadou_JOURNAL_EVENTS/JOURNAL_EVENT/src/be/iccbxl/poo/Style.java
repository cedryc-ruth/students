package be.iccbxl.poo;

public enum Style {
    ROCK("ROCK"), HIP_HOP("HIP HOP"), REGGAE("REGGAE");

    private String style;
    Style(String style) {
        this.style = style;
    }

    public String getStyle() {
        return style;
    }
}
