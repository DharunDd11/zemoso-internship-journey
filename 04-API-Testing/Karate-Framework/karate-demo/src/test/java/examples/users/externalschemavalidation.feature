Feature: External Schema Validation

Scenario: Validate Response Using External Schema File

Given url 'https://jsonplaceholder.typicode.com/users/1'
When method get
Then status 200

* def schema = read('classpath:examples/schema/userSchema.json')

Then match response == schema