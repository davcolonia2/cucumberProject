Feature: list data type
@ListDataTable
  Example: Data Table as a list
  Given this is a data table as a list
  |Omar|
  |John|
  |Mark|
  |Harry|
  |Joe|

  Example: Data table as a map
    Given this is a data table as a map
  |firstName  | Omar |
  |lastName   | Ramo |
  |middleName  | John |



  @listofListsDataTable
  Example: Data table as a list of lists
    Given this is a data table as a list of lists
      |11111   | Yoll       | Academy |
      |14829   | Michael Ch | Jackson |
      |14840   | Kiana      | Jacob   |