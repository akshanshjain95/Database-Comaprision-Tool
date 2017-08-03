import java.io.File


import knoldus.DatabaseComparisonTool.ReadWriteFromFile._

import scala.annotation.tailrec
import scala.io.Source.fromFile

val fileContent = fromFile("/home/knoldus/CSVInputFiles/MySQLDDL.csv").getLines.mkString("\n")

val fileContentList = fileContent.split("\n").toList

def createList(str: String): List[String] = {

  @tailrec
  def createList1(str: String, n: Int, qC: Int, accStr: String, list: List[String]): List[String] = {

    if(n == str.length)
      accStr :: list
    else
      {
        if(str(n) == ',')
          {
            if (qC % 2 == 0) {
              val list1 = accStr :: list
              createList1(str, n+1, 0, "", list1)
            }
            else {
              val newAccStr = accStr + str(n)
              createList1(str, n + 1, qC, newAccStr, list)
            }
          }
        else if(str(n) == '\"')
          {
            val quoteCount = qC + 1
            val newAccStr = accStr + str(n)
            createList1(str, n+1, quoteCount, newAccStr, list)
          }
        else
          {
            val newAccStr = accStr + str(n)
            createList1(str, n+1, qC, newAccStr, list)
          }
      }
  }
  createList1(str, 0, 0, "", List())
}

fileContentList(0)

createList(fileContentList(0))
/*
val statement = connection.createStatement
val rs = statement.executeUpdate("CREATE TABLE Employee(name VARCHAR(20), EmployeeID INT, zipcode INT, PhoneNo BIGINT);")*/

read("/home/knoldus/CSVInputFiles/MySQLDDL.csv")