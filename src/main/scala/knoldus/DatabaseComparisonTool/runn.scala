package knoldus.DatabaseComparisonTool



object MainClass extends App with Database {


  val mySqlTuple = MySQLService.queryTime("/src/test/resources/CSVInputFiles/MySQLDDL.csv")
  val postgreSQLTuple = PostgreSQLService.queryTime("/src/test/resources/CSVInputFiles/PostgreSQLDDL.csv")
  val SQLiteTuple = SQLiteService.queryTime("/src/test/resources/CSVInputFiles/SQLiteDDL.csv")

  WriteFinalFileService.writeFinalFile(mySqlTuple._1, mySqlTuple._2, postgreSQLTuple._2, SQLiteTuple._2)
  
}
