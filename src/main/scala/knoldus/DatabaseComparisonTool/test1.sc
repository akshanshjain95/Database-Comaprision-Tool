import java.io.File

//import knoldus.DatabaseComparisonTool.CSVTestCaseParser

import scala.annotation.tailrec
import scala.io.Source.fromFile

object CSVTestCaseParser {

  def parseContent(content: String): TestCase = {

    @tailrec
    def contentToList(content: String, index: Int, quoteCount: Int, contentAccumulator: String, list: List[String]): List[String] = {

      if (index == content.length)
        contentAccumulator :: list
      else {
        content(index) match {
          case ',' => {
            if (quoteCount % 2 == 0) {
              val newList = contentAccumulator :: list
              contentToList(content, index + 1, 0, "", newList)
            }
            else {
              val newContentAccumulator = contentAccumulator + content(index)
              contentToList(content, index + 1, quoteCount, newContentAccumulator, list)
            }
          }
          case '\"' => {
            val quotes = quoteCount + 1
            val newContentAccumulator = contentAccumulator + content(index)
            contentToList(content, index + 1, quotes, newContentAccumulator, list)
          }
          case _ => {
            val newContentAccumulator = contentAccumulator + content(index)
            contentToList(content, index + 1, quoteCount, newContentAccumulator, list)
          }
        }
      }
    }
    TestCase(contentToList(content, 0, 0, "", List()).reverse)
  }

}

val content = read("/home/knoldus/CSVInputFiles/MySQLDDL.csv")

val list = content.split("\n").toList

val listOfContent = list.map(CSVTestCaseParser.parseContent(_))