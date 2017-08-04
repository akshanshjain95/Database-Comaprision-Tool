package knoldus.DatabaseComparisonTool

import java.sql.Connection



object SQLiteService extends DatabaseService {

  override val connection: Connection = SQLite.connectToDatabase
  val fileName: String = "SQLite"

}
