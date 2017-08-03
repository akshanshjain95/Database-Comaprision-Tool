package knoldus.DatabaseComparisonTool

import scala.annotation.tailrec


object CSVTestCaseParser {

  def parseTestCase(testCase: String): TestCase = {

    @tailrec
    def testCaseToList(testCase: String, index: Int, quoteCount: Int, contentAccumulator: String, list: List[String]): List[String] = {

      if (index == testCase.length)
        {contentAccumulator :: list}
      else {
        testCase(index) match {
          case ',' => {
            if (quoteCount % 2 == 0) {
              val newList = contentAccumulator :: list
              testCaseToList(testCase, index + 1, 0, "", newList)
            }
            else {
              val newContentAccumulator = contentAccumulator + testCase(index)
              testCaseToList(testCase, index + 1, quoteCount, newContentAccumulator, list)
            }
          }
          case '\"' => {
            val quotes = quoteCount + 1
            testCaseToList(testCase, index + 1, quotes, contentAccumulator, list)
          }
          case _ => {
            val newContentAccumulator = contentAccumulator + testCase(index)
            testCaseToList(testCase, index + 1, quoteCount, newContentAccumulator, list)
          }
        }
      }
    }
    TestCase(testCaseToList(testCase, 0, 0, "", List()).reverse)
  }

}
