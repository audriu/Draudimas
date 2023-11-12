package draudimas.api

import draudimas.api.model.Bicycle
import draudimas.api.model.BicycleRequest
import draudimas.api.model.PremiumResponse
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping()
class BicycleInsuranceController {

    @Autowired
    InsuranceCalculationService insuranceCalculationService

    @PostMapping(value = "/api/v1/calculate", produces = "application/json")
    ResponseEntity<PremiumResponse> calculatePremiums(@RequestBody BicycleRequest request) {

        Bicycle[] bicycles = request.bicycles
        PremiumResponse response = insuranceCalculationService.calculate(bicycles)
        return new ResponseEntity<>(response, HttpStatus.OK)
    }
}


