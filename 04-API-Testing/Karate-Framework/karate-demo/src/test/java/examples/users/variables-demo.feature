Feature: Variables Demo

Background:
    * url baseUrl

Scenario: Works for both DEV and QA

    # Global Variables
    * print 'Username:', username
    * print 'Role:', role
    * print 'Base URL:', baseUrl

    # Scenario Variable
    * def userId = 1

    # GET User
    Given path 'users', userId
    When method get
    Then status 200

    # Environment Specific Extraction
    * def firstName = karate.env == 'qa' ? response.name.firstname : response.firstName

    * print 'First Name:', firstName

    # Environment Specific POST

    * if (karate.env == 'qa') karate.set('productPath', 'products')
    * if (karate.env != 'qa') karate.set('productPath', 'products/add')

    Given path productPath

    And request
    """
    {
      "title": "Karate Practice Product",
      "price": 100
    }
    """

    When method post

    # Different status per environment
    * if (karate.env == 'qa') karate.match(responseStatus, 201)
    * if (karate.env != 'qa') karate.match(responseStatus, 200)

    * print response