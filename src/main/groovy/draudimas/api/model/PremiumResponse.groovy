package draudimas.api.model

import groovy.transform.Canonical

@Canonical
class PremiumResponse {
    int manufactureYear
    String model
    String make
    String coverageType
    List<Risk> risks
    double sumInsured
    double premium
}
        