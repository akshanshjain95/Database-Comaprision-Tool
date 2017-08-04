package knoldus.DatabaseComparisonTool

import org.scalatest.FunSuite
import org.scalatest.mockito.MockitoSugar
import org.mockito.Mockito._



class DatabaseTest extends FunSuite with MockitoSugar {

  val database = mock[Database]

  test("Testing time taken by query method executeQueries")
  {
    val testCase= TestCase(1, " Creating Employee table"
      , " DROP TABLE IF EXISTS Employee;", " CREATE TABLE Employee(name VARCHAR(20), EmployeeID INT, zipcode INT, PhoneNo BIGINT);",
      " DROP TABLE Employee;")

    when(database.executeQueries(testCase, database.connectToDatabase)).thenReturn(100)

    assert(database.executeQueries(testCase, database.connectToDatabase) === 100)

  }
}
