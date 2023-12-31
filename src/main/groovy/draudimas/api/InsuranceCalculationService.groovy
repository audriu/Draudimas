package draudimas.api

import draudimas.api.model.Bicycle
import draudimas.api.model.PremiumResponse
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Component

@Component
class InsuranceCalculationService {

    @Autowired
    BaseScript policies

    //todo calculate using groovy rule engine; Validations; Risk insurance sum calculation formula
    PremiumResponse calculate(Bicycle[] bicycles) {
        return new PremiumResponse(
                risks: [
                        [
                                attributes  : [
                                        MANUFACTURE_YEAR: 2015,
                                        MODEL           : "Gravel SL EVO",
                                        MAKE            : "Pearl"
                                ],
                                coverageType: "EXTRA",
                                risks       : [
                                        [
                                                riskType  : "THIRD_PARTY_DAMAGE",
                                                sumInsured: 100.00,
                                                premium   : 12.00
                                        ],
                                        [
                                                riskType  : "THEFT",
                                                sumInsured: 1000.00,
                                                premium   : 30.00
                                        ],
                                        [
                                                riskType  : "DAMAGE",
                                                sumInsured: 500.00,
                                                premium   : 6.95
                                        ]
                                ],
                                sumInsured  : 1000,
                                premium     : 48.95
                        ],
                        [
                                attributes  : [
                                        MANUFACTURE_YEAR: 2020,
                                        MODEL           : "V2",
                                        MAKE            : "Sensa"
                                ],
                                coverageType: "STANDARD",
                                risks       : [
                                        [
                                                riskType  : "DAMAGE",
                                                sumInsured: 112.50,
                                                premium   : 5.78
                                        ]
                                ],
                                sumInsured  : 225,
                                premium     : 5.78
                        ],
                        [
                                attributes  : [
                                        MANUFACTURE_YEAR: 2019,
                                        MODEL           : "OTHER",
                                        MAKE            : "OTHER"
                                ],
                                coverageType: "STANDARD",
                                risks       : [
                                        [
                                                riskType  : "THIRD_PARTY_DAMAGE",
                                                sumInsured: 100.00,
                                                premium   : 12.00
                                        ],
                                        [
                                                riskType  : "DAMAGE",
                                                sumInsured: 100.00,
                                                premium   : 11.00
                                        ]
                                ],
                                sumInsured  : 200,
                                premium     : 23.00
                        ]
                ],
                premium: 77.73
        )
    }
}
