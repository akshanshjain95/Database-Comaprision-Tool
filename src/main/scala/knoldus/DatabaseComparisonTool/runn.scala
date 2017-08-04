package knoldus.DatabaseComparisonTool



object MainClass extends App with Database {


  val mySqlTuple = MySQLService.queryTime("/home/knoldus/CSVInputFiles/MySQLDDL.csv")
  val postgreSQLTuple = PostgreSQLService.queryTime("/home/knoldus/CSVInputFiles/PostgreSQLDDL.csv")
  val SQLiteTuple = SQLiteService.queryTime("/home/knoldus/CSVInputFiles/SQLiteDDL.csv")

  WriteFinalFileService.writeFinalFile(mySqlTuple._1, mySqlTuple._2, postgreSQLTuple._2, SQLiteTuple._2)
  
}
