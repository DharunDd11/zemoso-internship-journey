Feature: Third Party Schema Validation

Scenario: Validate Using NetworkNT Validator

Given url 'https://jsonplaceholder.typicode.com/users/1'
When method get
Then status 200

* def SchemaValidator = Java.type('helpers.SchemaValidator')

* def jsonString = karate.pretty(response)

* def result = SchemaValidator.validate(jsonString)

Then match result == true