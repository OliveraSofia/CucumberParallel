Feature: wikipedia user run tests on different browsers

  @Wiki
  Scenario Outline: Open page on 2 browsers

    Given User choose the "<BrowserName>" browser
    When The Home page is load
    Then Close the browser

    Examples:
      | TCID | BrowserName |
      | 01   | chrome      |

  Scenario Outline: Select Language and go to login Page

    Given User choose the "<BrowserName>" browser
    When The Home page is load
    And Language "<Language>" is Selected
    When User clicks on language Link


    Examples:
      | TCID | BrowserName | Language |
      | 01   | chrome      | Japanese |
      | 02   | chrome      | Español  |
      | 03   | chrome      | Russian  |

# Language options: "English","Español","Japanese","Deutsch","French","Chinese", "Polski", "Russian", "Italian", "Portugues".



