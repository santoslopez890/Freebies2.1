package com.HerreraCodes.FreebiesBackend.Enum;

public enum Categories {
    cat1home("home"),
    cat2vehicles("vehicles"),
    cat3apparel("apparel"),
    cat4electronics("electronics"),
    cat5entertainment("entertainment"),
    cat6("free"),
    cat7garden("garden"),
    cat8hobbies("hobbies"),
    cat9home("home"),
    cat10instruments("instruments"),
    cat11office("office-supplies"),
    cat12pets("pets"),
    cat13sports("sports"),
    cat14toys("toys"),
    cat15homeimprovements("home-improvements");

    private final String link;

    Categories(String link) {
        this.link = link;
    }

    public String getLink() {
        return link;
    }
}
