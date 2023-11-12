package draudimas.api

import draudimas.api.model.Bicycle
import draudimas.api.model.PremiumResponse
import org.junit.jupiter.api.Test

import static org.junit.jupiter.api.Assertions.assertEquals

class InsuranceCalculationServiceTests {

    private final InsuranceCalculationService service = new InsuranceCalculationService()

    @Test
    void testCalculate() {
        final Bicycle[] bicycles = [
                new Bicycle(
                        make: "Pearl",
                        model: "Gravel SL EVO",
                        coverage: "EXTRA",
                        manufactureYear: 2015,
                        sumInsured: 1000,
                        risks: ["THEFT", "DAMAGE", "THIRD_PARTY_DAMAGE"]
                ),
                new Bicycle(
                        make: "Sensa",
                        model: "V2",
                        coverage: "STANDARD",
                        manufactureYear: 2020,
                        sumInsured: 225,
                        risks: ["DAMAGE"]
                ),
                new Bicycle(
                        make: "OTHER",
                        model: "OTHER",
                        coverage: "STANDARD",
                        manufactureYear: 2019,
                        sumInsured: 200,
                        risks: ["DAMAGE", "THIRD_PARTY_DAMAGE"]
                )
        ]

        final PremiumResponse expectedResponse = new PremiumResponse(
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

        final PremiumResponse actualResponse = service.calculate(bicycles)

        assertEquals(expectedResponse, actualResponse)
    }
}
