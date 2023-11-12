package draudimas.api.model

import groovy.transform.Canonical

@Canonical
class Risk {
    String riskType
    double sumInsured
    double premium
}