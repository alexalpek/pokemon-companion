package com.codecool.pokemoncompanion.model.wrapper;

import com.codecool.pokemoncompanion.model.generated.ResultsItem;
import com.codecool.pokemoncompanion.util.Util;

public class ResultItemWithId extends ResultsItem {

    private long id;

    public ResultItemWithId(ResultsItem item) {
        this.setName(item.getName());
        this.setUrl(item.getUrl());
        this.id = Util.getIdFromUrl(item.getUrl());
    }

    public long getId() {
        return this.id;
    }
}
