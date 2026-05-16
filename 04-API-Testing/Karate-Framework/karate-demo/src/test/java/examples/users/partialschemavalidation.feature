Feature: Partial Schema Validation

Scenario: Validate Important Fields Only

Given url 'https://jsonplaceholder.typicode.com/users/1'
When method get
Then status 200

Then match response contains
"""
{
  id: '#number',
  name: '#string',
  email: '#string'
}
"""