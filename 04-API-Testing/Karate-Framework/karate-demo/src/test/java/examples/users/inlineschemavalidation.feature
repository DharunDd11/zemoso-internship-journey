Feature: Inline Strict Schema Validation

Scenario: Validate Complete User Response

Given url 'https://jsonplaceholder.typicode.com/users/1'
When method get
Then status 200

Then match response ==
"""
{
  id: '#number',
  name: '#string',
  username: '#string',
  email: '#string',

  address:
  {
    street: '#string',
    suite: '#string',
    city: '#string',
    zipcode: '#string',

    geo:
    {
      lat: '#string',
      lng: '#string'
    }
  },

  phone: '#string',
  website: '#string',

  company:
  {
    name: '#string',
    catchPhrase: '#string',
    bs: '#string'
  }
}
"""