package com.time.tracker.model;

import java.io.Serializable;

public interface Identifier<ID extends Serializable> {

    ID getIdentifier();

}
