package knoldus.DatabaseComparisonTool


object MySQL extends Database {

  override val url = "jdbc:mysql://localhost:3306/test?allowMultiQueries=true"
  override val driver = "com.mysql.cj.jdbc.Driver"
  override val username = "root"
  override val password = "knoldus"

}
