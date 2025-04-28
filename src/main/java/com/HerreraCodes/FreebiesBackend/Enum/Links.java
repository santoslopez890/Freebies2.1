package com.HerreraCodes.FreebiesBackend.Enum;
//https://www.facebook.com/marketplace/113215245355796/home
// ?minPrice=0&maxPrice=0&daysSinceListed=1&deliveryMethod=local_pick_up&sortBy=creation_time_descend&exact=false
//so we need to add the zip to p1 and then a "/(category)"
public enum Links {
    linkp1("https://www.facebook.com/marketplace/"),
    linkp2("?minPrice=0&maxPrice=0&daysSinceListed=1&deliveryMethod=local_pick_up&sortBy=creation_time_descend&exact=false");


    private final String link;

    Links(String link) {
        this.link = link;
    }

    public String getLink() {
        return link;
    }
}
