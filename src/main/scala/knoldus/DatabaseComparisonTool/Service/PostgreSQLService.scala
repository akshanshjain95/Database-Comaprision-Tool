package knoldus.DatabaseComparisonTool

import java.sql.Connection



object PostgreSQLService extends DatabaseService {

  val connection: Connection = PostgreSQL.connectToDatabase
  val fileName: String = "PostgreSQL"

}
