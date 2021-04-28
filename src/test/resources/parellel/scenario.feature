Feature: wikipedia user run tests on different browsers

  @Wiki
  Scenario Outline: Open page on 2 browsers

    Given User choose the "<BrowserName>" browser
    When The Home page is load
    Then Close the browser

    Examples:
      | TCID | BrowserName |
      | 02   | firefox     |

  Scenario Outline: Select Language and go to login Page

    Given User choose the "<BrowserName>" browser
    When The Home page is load
    And Language "<Language>" is Selected
    When User clicks on language Link


    Examples:
      | TCID | BrowserName | Language |
      | 01   | firefox      | Japanese |
      | 02   | firefox      | Español  |
      | 03   | firefox      | Russian  |

# Language options: "English","Español","Japanese","Deutsch","French","Chinese", "Polski", "Russian", "Italian", "Portugues".

  Scenario Outline: Login on Chrome

    Given English user is on login Page
    When User login with "<username>" and "<password>"
    And Click on submit button

    Examples:
      | TCID | username  | password    |
      | 01   | Solive7   | ganeshA108  |
