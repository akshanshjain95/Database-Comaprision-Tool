package knoldus.DatabaseComparisonTool



object runn extends App with Database {


  val mySqlTuple = MySQLService.queryTime("/home/knoldus/CSVInputFiles/MySQLDDL.csv")
  val postgreSQLTuple = PostgreSQLService.queryTime("/home/knoldus/CSVInputFiles/PostgreSQLDDL.csv")
  val SQLiteTuple = SQLiteService.queryTime("/home/knoldus/CSVInputFiles/SQLiteDDL.csv")

  WriteFinalFileService.writeFinalFile(mySqlTuple._1, mySqlTuple._2, postgreSQLTuple._2, SQLiteTuple._2)
  /*val conn = PostgreSQL.connectToDatabase
  val state = conn.createStatement()
  state.execute("\\t;")*/



 /* //val sqliteObj = new SQLite
  val sqliteconnection = SQLite.connectToDatabase
  val sqlitestatement = sqliteconnection.createStatement
  val t0 = System.nanoTime()
  val sqliters = sqlitestatement.executeUpdate("CREATE TABLE Employee(name VARCHAR(20), " +
    "EmployeeID INT, zipcode INT, PhoneNo BIGINT);")
  val t1 = System.nanoTime()
  val sqliters1 = sqlitestatement.executeUpdate("DROP TABLE Employee;")
  SQLite.closeConnection(sqliteconnection)
  println("SQLite = " + (t1 - t0))

  //val postgresObj = new PostgreSQL
  val postgresconnection = PostgreSQL.connectToDatabase
  val postgresstatement = postgresconnection.createStatement
  val t2 = System.nanoTime()
  val postgresrs = postgresstatement.executeUpdate("CREATE TABLE Employee(name VARCHAR(20), " +
    "EmployeeID INT, zipcode INT, PhoneNo BIGINT);")
  val t3 = System.nanoTime()
  val postgresrs1 = postgresstatement.executeUpdate("DROP TABLE Employee;")
  PostgreSQL.closeConnection(postgresconnection)
  println("PostgreSQL = " + (t3 - t2))

  //val mysqlObj = new MySQL
  val mysqlconnection = MySQL.connectToDatabase
  val mysqlstatement = mysqlconnection.createStatement
  val t4 = System.nanoTime()
  val mysqlrs = mysqlstatement.executeUpdate("CREATE TABLE Employee(name VARCHAR(20), " +
    "EmployeeID INT, zipcode INT, PhoneNo BIGINT);")
  val t5 = System.nanoTime()
  val mysqlrs1 = mysqlstatement.executeUpdate("DROP TABLE Employee;")
  MySQL.closeConnection(mysqlconnection)
  println("MySQl = " + (t5 - t4))*/

}
