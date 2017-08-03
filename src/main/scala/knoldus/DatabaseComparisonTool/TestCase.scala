package knoldus.DatabaseComparisonTool


case class TestCase(testCaseID: Int, testCaseDescription: String, preCondition: String,
                      query: String, postCondition: String)

object TestCase {

  def apply(list: List[String]): TestCase = {

    TestCase(list.head.toInt, list(1), list(2), list(3), list(4))

  }

}
