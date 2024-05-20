@ui
  Feature: Users

    @uiAddUser
    Scenario: Add user
      Given Kullanici URL gider
      And Kullanici "Sign up" butonuna tiklar
      And Kullanici "First Name" girer
      And Kullanici "Last Name" girer
      And Kullanici "Email" girer
      And Kullanici "Password" girer
      And Kullanici "Submit" butonuna tiklar

