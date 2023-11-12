package draudimas.api.model

import groovy.transform.Canonical

@Canonical
class Bicycle {
    private String make
    private String model
    private String coverage
    private int manufactureYear
    private int sumInsured
    private List<String> risks
}
