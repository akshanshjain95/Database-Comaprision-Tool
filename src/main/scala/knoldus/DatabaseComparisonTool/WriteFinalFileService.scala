package knoldus.DatabaseComparisonTool



object WriteFinalFileService {

  def writeFinalFile(testCaseList: List[TestCase], mySQLTimeList: List[Long],
                     postgreSQLTimeList: List[Long], SQLiteTimeList: List[Long]): Boolean = {

    val listZip = testCaseList zip mySQLTimeList zip postgreSQLTimeList zip SQLiteTimeList map {
      case (((testCase,mySQLTime),postgreSQLTime),sqliteTime) => (testCase,mySQLTime,postgreSQLTime,sqliteTime)
    }

    ReadWriteFromFile.write("FinalResult.csv", listZip.map(tuple => tuple._1.testCaseID + ", "
    + tuple._1.testCaseDescription + ", MySQl - " + tuple._2 + ", PostgreSQl - " + tuple._3 + ", SQLite - " + tuple._4).mkString("\n"),
      "src/test/resources/outputCSVFiles")
  }
}
