curl -X POST \
  http://localhost:8080/api/v1/calculate \
  -H 'Content-Type: application/json' \
  -d '{
  "bicycles" : [
    {
      "make" : "Pearl",
      "model" : "Gravel SL EVO",
      "coverage" : "EXTRA",
      "manufactureYear" : 2015,
      "sumInsured" : 1000,
      "risks" : [
        "THEFT",
        "DAMAGE",
        "THIRD_PARTY_DAMAGE"
      ]
    },
    {
      "make" : "Sensa",
      "model" : "V2",
      "coverage" : "STANDARD",
      "manufactureYear" : 2020,
      "sumInsured" : 225,
      "risks" : [
        "DAMAGE"
      ]
    },
    {
      "make" : "OTHER",
      "model" : "OTHER",
      "coverage" : "STANDARD",
      "manufactureYear" : 2019,
      "sumInsured" : 200,
      "risks" : [
        "DAMAGE",
        "THIRD_PARTY_DAMAGE"
      ]
    }
  ]
}'
