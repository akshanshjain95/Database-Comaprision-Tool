package knoldus.DatabaseComparisonTool

/**
  * Created by knoldus on 3/8/17.
  */
object WriteFinalFileService {

  def writeFinalFile(testCaseList: List[TestCase], mySQLTimeList: List[Long],
                     postgreSQLTimeList: List[Long], SQLiteTimeList: List[Long]) = {

    val listZip = testCaseList zip mySQLTimeList zip postgreSQLTimeList zip SQLiteTimeList map {
      case (((a,b),c),d) => (a,b,c,d)
    }

    ReadWriteFromFile.write("FinalResult.csv", listZip.map(tuple => tuple._1.testCaseID + ", "
    + tuple._1.testCaseDescription + ", " + tuple._2 + ", " + tuple._3 + ", " + tuple._4).mkString("\n"),
      "/home/knoldus/outputCSVFiles")
  }
}
