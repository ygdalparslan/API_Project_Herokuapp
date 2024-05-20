@api
Feature: Users

  @addUser
  Scenario: Add User Geçerli veriler ile Kullanıcı Ekleme
    Given "Add User" icin URL duzenlenir
    And "Add User" icin Payload duzenlenir
    And "POST" Request gonderilir ve Response alinir
    Then Add User icin Response Body dogrulanir

  @getUser
  Scenario: Get User Profile
    Given "Get User" icin URL duzenlenir
    And "GET" Request gonderilir ve Response alinir
    Then Status kodun 200 oldugu dogrulanir
    Then Get User icin Response Body dogrulanir

  @upDateUser
  Scenario: Update User
    Given "Update User" icin URL duzenlenir
    And "Update User" icin Payload duzenlenir
    And "PATCH" Request gonderilir ve Response alinir
    Then Status kodun 200 oldugu dogrulanir
    Then Update User icin Response Body dogrulanir

  @logOutUser
  Scenario: Log Out User
    Given "Log Out User" icin URL duzenlenir
    And "Log Out POST" Request gonderilir ve Response alinir
    Then Status kodun 200 oldugu dogrulanir