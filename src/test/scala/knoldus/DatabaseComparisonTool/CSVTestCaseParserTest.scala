package knoldus.DatabaseComparisonTool



class CSVTestCaseParserTest extends org.scalatest.FunSuite {

  test("Testing CSVTestCaseParser")
  {
    val testCase= "1, Creating Employee table, DROP TABLE IF EXISTS Employee;, " +
      "\"CREATE TABLE Employee(name VARCHAR(20), EmployeeID INT, zipcode INT, " +
      "PhoneNo BIGINT);\", DROP TABLE Employee;"

    assert(CSVTestCaseParser.parseTestCase(testCase) === TestCase(1, " Creating Employee table"
    , " DROP TABLE IF EXISTS Employee;", " CREATE TABLE Employee(name VARCHAR(20), EmployeeID INT, zipcode INT, PhoneNo BIGINT);",
    " DROP TABLE Employee;"))

  }
}
