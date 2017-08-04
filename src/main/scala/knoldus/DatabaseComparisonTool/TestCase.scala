package knoldus.DatabaseComparisonTool


case class TestCase(testCaseID: Int, testCaseDescription: String, preCondition: String,
                      query: String, postCondition: String)

object TestCase {

  def apply(list: List[String]): TestCase = {
    val ONE = 1
    val TWO = 2
    val THREE = 3
    val FOUR = 4
    TestCase(list.head.toInt, list(ONE), list(TWO), list(THREE), list(FOUR))

  }

}
