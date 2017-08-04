package knoldus.DatabaseComparisonTool

import java.sql.Connection

import org.scalatest.FunSuite
import org.scalatest.mockito.MockitoSugar
import org.mockito.Mockito._
import org.mockito.internal.handler.MockHandlerFactory



class DatabaseTest extends FunSuite with MockitoSugar with Database {

  val database = mockFunction[Unit, Connection]

  test("Testing time taken by query method executeQueries")
  {
    val testCase= TestCase(1, " Creating Employee table"
      , " DROP TABLE IF EXISTS Employee;", " CREATE TABLE Employee(name VARCHAR(20), EmployeeID INT, zipcode INT, PhoneNo BIGINT);",
      " DROP TABLE Employee;")

    when(executeQueries(testCase, database.connectToDatabase)).thenReturn(100)

    assert(executeQueries(testCase, database.connectToDatabase) === 100)

  }

}
