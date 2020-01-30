@sprint3 @candidates
Feature: Candidates

  Background: 
    Given i am logged into HRMS
    And i navigate to Candidates Page

  @smoke
  Scenario Outline: Searching a candidate by name
    When i enter "<CandidateName>"
    And i click search button in Candidate
    Then i see candidate name in search results

    Examples: 
      | CandidateName |
      | Satish Jha    |
      | Dan Cons      |
      | Dan Em Cons   |

  @regression
  Scenario Outline: Adding new Candidates to Candidates Page
    When i click Add button
    And i enter "<FirstName>", "<LastName>", "<Email>" and "<ContactNo>"
    And i select Job Vacancy
    And i select "<Month>", "<Day>" and "<Year>" of Application
    And i click Save button
    Then i see Candidate is added successfully

    Examples: 
      | FirstName | LastName | Email            | ContactNo  | Month    | Day | Year |
      | Lionel    | Messi    | lionel@messi.com | 1112223344 | January  |  31 | 2020 |
      | Russel    | Crowl    | russel@crowl.com | 2223334455 | February |  14 | 2020 |

  @regression
  Scenario Outline: Deleting Candidates from the Candidates list
    When i find "<CandidateName>" from the list
    And i click select button
    And i click Delete button
    And i confirm delete
    Then i see given Candidate is deleted from Candidate List
