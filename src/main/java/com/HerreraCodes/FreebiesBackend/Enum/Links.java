package com.HerreraCodes.FreebiesBackend.Enum;

public enum Links {
    linkp1("https://www.facebook.com/marketplace/category/"),
    linkp2("?minPrice=0&maxPrice=0&daysSinceListed=1&deliveryMethod=local_pick_up&sortBy=creation_time_descend&exact=false");


    private final String link;

    Links(String link) {
        this.link = link;
    }

    public String getLink() {
        return link;
    }
}
