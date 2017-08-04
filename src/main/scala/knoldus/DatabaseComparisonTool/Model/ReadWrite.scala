package knoldus.DatabaseComparisonTool


trait ReadWrite {

  def read(fileLocation: String): String

  def write(fileName: String, content: String, dirPath: String): Boolean

}
