package knoldus.DatabaseComparisonTool


object PostgreSQL extends Database {

  override val url = "jdbc:postgresql://localhost:5432/test"
  override val driver = "org.postgresql.Driver"
  override val username = "postgres"
  override val password = "knoldus"

}
