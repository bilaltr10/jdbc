@staffDetails @db
Feature: Staff table automation features

  Scenario Outline: Get a list of all staff
    Given the staff service is up and running
    When I request a list of all staff
    Then I should receive a list containing all staff in the database
      | staffId    | <staffId>    |
      | firstName  | <firstName>  |
      | lastName   | <lastName>   |
      | addressId  | <addressId>  |
      | email      | <email>      |
      | storeId    | <storeId>    |
      | active     | <active>     |
      | userName   | <userName>   |
      | password   | <password>   |
      | lastUpdate | <lastUpdate> |
    Examples:
      | staffId | firstName | lastName   | addressId | email                          | storeId | active | userName | password                                   | lastUpdate                  |
      | 1       | "Mike"    | "Hillyer"  | 3         | "Mike.Hillyer@sakilastaff.com" | 1       | true   | "Mike"   | "8cb2237d0679ca88db6464eac60da96345513964" | "2006-05-16 16:13:11.79328" |
      | 2       | "Jon"     | "Stephens" | 4         | "Jon.Stephens@sakilastaff.com" | 2       | true   | "Jon"    | "8cb2237d0679ca88db6464eac60da96345513964" | "2006-05-16 16:13:11.79328" |



