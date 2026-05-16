Feature: CRUD Operations

Background:
    * url 'http://localhost:3000'


@crud
Scenario: Perform Complete CRUD Flow

    # CREATE USER

    Given path 'users'

    And request
    """
    {
      "name": "Rahul",
      "role": "Developer"
    }
    """

    When method post
    Then status 201

    * def userId = response.id
    * print 'Created User ID:', userId

    * karate.pause(5000)

    # READ CREATED USER

    Given path 'users', userId
    When method get
    Then status 200

    * karate.pause(5000)

    

    Given path 'users', userId

    And request
    """
    {
      "id": #(userId),
      "name": "Rahul Updated",
      "role": "Senior Developer"
    }
    """

    When method put
    Then status 200

    * karate.pause(5000)
    # PATCH USER

   Given path 'users', userId

And request
"""
{
  "role": "Team Lead"
}
"""

When method patch
Then status 200

* karate.pause(5000)

    # VERIFY UPDATED USER

    Given path 'users', userId
    When method get
    Then status 200
    And match response.name == 'Rahul Updated'

    * karate.pause(5000)
    # PATCH USER

Given path 'users', userId

And request
"""
{
  "role": "Team Lead"
}
"""

When method patch
Then status 200

* karate.pause(5000)

    # DELETE USER

    Given path 'users', userId
    When method delete
    Then status 200