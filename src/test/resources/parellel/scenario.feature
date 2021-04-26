Feature: wikipedia user run tests on different browsers

  @Wiki
  Scenario Outline: Open page on 2 browsers

    Given User choose the "<BrowserName>" browser
    When The Home page is load
    Then Close the browser

    Examples:
      | TCID | BrowserName |
      | 02   | firefox     |
