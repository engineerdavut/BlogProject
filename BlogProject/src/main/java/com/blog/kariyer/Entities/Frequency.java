package com.blog.kariyer.Entities;

import lombok.Getter;

@Getter
public enum Frequency {
    MAIN( "Ana Etiket"),
    LOW("Az Kullanilan Etiket"),
    HIGH("Cok Kullanilan Etiket");
    private String label;

    Frequency(String label) {
        this.label=label;
    }

}
